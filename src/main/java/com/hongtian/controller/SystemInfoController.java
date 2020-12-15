package com.hongtian.controller;

import com.hongtian.util.SystemInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;

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
        return "SystemInfo";
    }
}
