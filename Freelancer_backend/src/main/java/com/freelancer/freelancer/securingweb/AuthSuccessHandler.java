package com.freelancer.freelancer.securingweb;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freelancer.freelancer.service.UserService;
import com.freelancer.freelancer.utils.msgutils.Msg;
import net.sf.json.JSONObject;
import com.freelancer.freelancer.utils.msgutils.MsgCode;
import com.freelancer.freelancer.utils.msgutils.MsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AuthSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private UserService userService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        JSONObject data = new JSONObject();
        data.put("username", authentication.getName());
        Msg msg = MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.LOGIN_SUCCESS_MSG, data);
        System.out.println(msg.toString());
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        httpServletResponse.getWriter().write(mapper.writeValueAsString(msg));
    }
}
