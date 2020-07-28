package com.freelancer.freelancer.securingweb;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freelancer.freelancer.constant.Constant;
import com.freelancer.freelancer.entity.User;
import com.freelancer.freelancer.service.UserService;
import com.freelancer.freelancer.utils.msgutils.Msg;
import com.freelancer.freelancer.utils.sessionutils.SessionUtil;
import net.sf.json.JSONObject;
import com.freelancer.freelancer.utils.msgutils.MsgCode;
import com.freelancer.freelancer.utils.msgutils.MsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private UserService userService;

    private User user;

    private <T> T getRedisUtil(Class<T> clazz, HttpServletRequest request) {
        WebApplicationContext applicationContext = WebApplicationContextUtils
                .getRequiredWebApplicationContext(request.getServletContext());
        return applicationContext.getBean(clazz);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            Authentication authentication) throws IOException, ServletException {
        JSONObject data = new JSONObject();
        String name = authentication.getName();
        if (userService == null) {
            userService = getRedisUtil(UserService.class, httpServletRequest);
        }

        user = userService.findByName(name);
        data.put(Constant.NAME, name);
        data.put(Constant.USER_TYPE, authentication.getAuthorities());
        data.put(Constant.USER_ID, user.getU_id());
        SessionUtil.setSession(data);

        Msg msg = MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.LOGIN_SUCCESS_MSG, data);
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        httpServletResponse.getWriter().write(mapper.writeValueAsString(msg));
    }
}
