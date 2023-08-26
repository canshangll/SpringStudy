package com.lmj.controller;

import com.lmj.server.WebSocketServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@RestController
@RequestMapping("/websocket")
public class WebSocketController {

    @GetMapping("/push/{toUID}")
//    @ApiOperation(value = "指定用户进行消息推送", notes = "指定用户进行消息推送")
    public String pushToClient(String message, @PathVariable String toUID) throws IOException {
        WebSocketServer.sendInfo(message, toUID);
        return "send ok!";
    }

}