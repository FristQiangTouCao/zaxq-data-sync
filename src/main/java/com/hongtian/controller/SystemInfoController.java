package com.hongtian.controller;

import com.hongtian.common.response.CommonResult;
import com.hongtian.component.SystemInfoComponent;
import com.hongtian.dao.redisDao.RedisServices;
import com.hongtian.entity.dto.TaskVo;
import com.hongtian.entity.vo.TodayTaskInfoVo;
import com.hongtian.util.SystemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * @author weed
 * @date 2020/11/30 0030 15:12
 * @description
 */
@Controller
public class SystemInfoController {

    private String serverHost;

    @Value("${server.port}")
    private String serverPort;

    @Value("${dataDir}")
    public String dataDir;

    @Autowired
    private RedisServices redisServices;

    @Autowired
    private SystemInfoComponent systemInfoComponent;

    private String point = "/system";

    @PostConstruct
    public void init() throws UnknownHostException {
        InetAddress address =  InetAddress.getLocalHost();
        String ip = address.getHostAddress();
        serverHost = ip;
        SystemInfo.dataDir = dataDir;
    }
    @RequestMapping("/systemInfo")
    public String systemInfo(Model model){
        model.addAttribute("host",serverHost);
        model.addAttribute("port",serverPort);
        model.addAttribute("point",point);
        model.addAttribute("todayTaskInfo",systemInfoComponent.getTodayTaskInfo());
        model.addAttribute("redisInfo",redisServices.getRedisInfo());
        return "SystemInfo";
    }

    // 今日执行的任务
    @ResponseBody
    @GetMapping("/todayTaskInfo")
    public Object todayTaskExecuteCase() {
        List<TodayTaskInfoVo> todayTaskInfo = systemInfoComponent.getTodayTaskInfo();
        return CommonResult.successData(todayTaskInfo);
    }

    @ResponseBody
    @GetMapping("/getJobs")
    public Object getJobs() {
        List<TaskVo> jobs = systemInfoComponent.getJobs();
        return CommonResult.successData(jobs);
    }

    @ResponseBody
    @GetMapping("/updateJob")
    public Object startJob(@RequestParam("job") String job) {
        String result = systemInfoComponent.updateTask(job);
        if(result == null) {
           return CommonResult.successData("ok!");
        } else {
            return CommonResult.error(result);
        }
    }

    @ResponseBody
    @GetMapping("runningTaskList")
    public Object runningTaskList() {
        return null;
    }
}
