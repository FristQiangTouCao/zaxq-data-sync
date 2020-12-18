package com.hongtian.socket;

import com.alibaba.fastjson.JSON;
import com.hongtian.component.SystemInfoComponent;
import com.hongtian.dao.redisDao.RedisServices;
import com.hongtian.util.SystemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;

/**
 * @author weed
 * @date 2020/11/30 0030 14:20
 * @description
 */
@Component
@ServerEndpoint("/system")
public class SystemSocket {


    static SystemInfoComponent systemInfoComponent;

    static RedisServices redisServices;

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    @Autowired
    public void setSystemInfoComponent(SystemInfoComponent systemInfoComponent) {
        SystemSocket.systemInfoComponent = systemInfoComponent;
    }

    @Autowired
    public void setRedisServices(RedisServices redisServices) {
        SystemSocket.redisServices = redisServices;
    }

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        onConn();
        new Thread(new runn(session,systemInfoComponent)).start();
    }

    @OnMessage
    public void onMessage(String message,Session session) throws IOException {
        System.out.println("来自客户端的消息：" + message);
        session.getBasicRemote().sendText("ok!");
    }

    @OnClose
    public void onClose() {
        onCloseCount();
    }

    public static synchronized int getOnlineCount(){
        return onlineCount;
    }

    public static synchronized  void onConn() {
        onlineCount++;
    }

    public static synchronized  void onCloseCount() {
        onlineCount--;
    }

    class runn implements Runnable{

        private Session session;

        private SystemInfoComponent systemInfoComponent;

        public runn(Session session,SystemInfoComponent systemInfoComponent) {
            this.session = session;
            this.systemInfoComponent = systemInfoComponent;
        }
        @Override
        public void run() {
            while(true) {
                try {
                    if (!session.isOpen()) {
                        break;
                    }
                    Map<String, Object> info = SystemInfo.getInfo();
                    info.put("todayTaskInfo",systemInfoComponent.getTodayTaskInfo());
                    info.put("redisInfo",redisServices.getRedisInfo());
                    session.getBasicRemote().sendText(JSON.toJSONString(info));
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
