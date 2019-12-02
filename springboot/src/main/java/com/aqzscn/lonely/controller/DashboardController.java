package com.aqzscn.lonely.controller;

import com.aqzscn.lonely.service.WebSocketServer;
import com.aqzscn.lonely.utils.JacksonUtil;
import com.aqzscn.lonely.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/dhb")
public class DashboardController {

    @GetMapping("/state")
    public boolean getState() {
        return GlobalCaches.isOpen;
    }

    @PutMapping("/state")
    public ReturnVo switchState(HttpServletRequest request) throws AppException, IOException {
        String token = (String) request.getAttribute("token");
        if (StringUtils.isNotBlank(token)) {
            if (token.equals(GlobalCaches.token)) {
                GlobalCaches.isOpen = !GlobalCaches.isOpen;
                // 通知网页端状态改变
                WebSocketVo vo = new WebSocketVo(WebSocketType.stateChange.name(), GlobalCaches.isOpen);
                WebSocketServer.sendInfo(JacksonUtil.me().toJson(vo), null);
                return ReturnVo.success();
            } else {
                throw AppException.of(HttpServletResponse.SC_FORBIDDEN);
            }
        } else {
            throw AppException.of(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    @GetMapping("/user-state")
    public ReturnVo login(HttpServletRequest request) throws AppException {
        String token = (String) request.getAttribute("token");
        if (StringUtils.isNotBlank(token)) {
            if (token.equals(GlobalCaches.token)) {
                return ReturnVo.success();
            } else {
                throw AppException.of(HttpServletResponse.SC_FORBIDDEN);
            }
        } else {
            throw AppException.of(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

}
