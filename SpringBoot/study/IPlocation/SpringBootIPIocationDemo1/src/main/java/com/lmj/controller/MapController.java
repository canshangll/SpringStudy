package com.lmj.controller;

import org.junit.platform.commons.util.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class MapController {
    //有百度开放平对生成
    private String ak = "IXE1rv5ERomb7eGN36fUXckyYZxo9O77";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/getIp")
    public Object getAddrByUserIP(HttpServletRequest request) throws URISyntaxException {
        String ip = request.getRemoteHost(); // 内网测试只能得到本地地址  放公网服务器上测试下？
        ip = "125.92.144.199";// 仅限公网ip
        // 百度地图API调用
        System.out.println(ip);
        String url = "https://api.map.baidu.com/location/ip?ip=" + ip + "&coor=bd09ll&ak=" + ak;
        //发送请求
        ResponseEntity<Map> forEntity = restTemplate.getForEntity(new URI(url), Map.class);
        Map result = forEntity.getBody();
        return result;
    }

}