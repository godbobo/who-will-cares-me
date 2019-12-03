package com.aqzscn.lonely.handler;

import com.aqzscn.lonely.utils.JacksonUtil;
import com.aqzscn.lonely.vo.GlobalCaches;
import com.aqzscn.lonely.vo.ReturnVo;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@Configuration
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        // 解析请求头中的token信息
        Enumeration<String> headers = req.getHeaders("Authorization");
        String token = "";
        if (headers != null && headers.hasMoreElements()) {
            token = headers.nextElement();
            req.setAttribute("token", token);
        }
        // 对特殊路径的和有管理员权限的请求放行，而其他的则进行拦截
        if (GlobalCaches.isOpen
                || GlobalCaches.token.equals(token)
                // 展示状态关闭时允许获取基本信息及用户登录请求
                || (req.getRequestURI().equals("/dhb/state") && req.getMethod().equals(RequestMethod.GET.name()))
                || (req.getRequestURI().equals("/dhb/user-state") && req.getMethod().equals(RequestMethod.GET.name()))
                // 放行websocket请求
                || req.getRequestURI().contains("/wbskt/")) {
            chain.doFilter(request, response);
        } else {
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.setContentType("application/json;charset=utf-8");
            PrintWriter out = res.getWriter();
            out.write(JacksonUtil.me().toJson(ReturnVo.error("用户未授权")));
            out.flush();
            out.close();
        }
    }

}
