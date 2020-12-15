package com.hongtian.socket;

import com.alibaba.fastjson.JSON;
import com.hongtian.util.SystemInfo;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @author weed
 * @date 2020/11/30 0030 14:20
 * @description
 */
@Component
@ServerEndpoint("/system")
public class SystemSocket {
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        onConn();
        System.out.println("设备连接！连接数：" + getOnlineCount());
        new Thread(new runn(session)).start();
    }

    @OnMessage
    public void onMessage(String message,Session session) throws IOException {
        System.out.println("来自客户端的消息：" + message);
        session.getBasicRemote().sendText("你好啊");
    }

    @OnClose
    public void onClose() {
        onCloseCount();
        System.out.println("设备下线！");
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

        public runn(Session session) {
            this.session = session;
        }
        @Override
        public void run() {
            while(true) {
                try {
                    if (!session.isOpen()) {
                        break;
                    }
                    session.getBasicRemote().sendText(JSON.toJSONString(SystemInfo.getInfo()));
                    Thread.sleep(1000);
                    System.out.println("发送一次");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
