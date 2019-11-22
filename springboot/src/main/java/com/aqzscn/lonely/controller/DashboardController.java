package com.aqzscn.lonely.controller;

import com.aqzscn.lonely.vo.AppException;
import com.aqzscn.lonely.vo.GlobalCaches;
import com.aqzscn.lonely.vo.ReturnVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/dhb")
public class DashboardController {

    @GetMapping("/state")
    public boolean getState() {
        return GlobalCaches.isOpen;
    }

    @PutMapping("/state")
    public ReturnVo switchState(HttpServletRequest request) throws AppException {
        String token = (String) request.getAttribute("token");
        if (StringUtils.isNotBlank(token)) {
            if (token.equals(GlobalCaches.token)) {
                GlobalCaches.isOpen = !GlobalCaches.isOpen;
                return ReturnVo.success();
            } else {
                throw AppException.of(HttpServletResponse.SC_FORBIDDEN);
            }
        } else {
            throw AppException.of(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

}
