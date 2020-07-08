package com.freelancer.freelancer.controller;

import com.freelancer.freelancer.constant.Constant;
import com.freelancer.freelancer.entity.User;
import com.freelancer.freelancer.service.UserService;
import com.freelancer.freelancer.utils.msgutils.Msg;
import com.freelancer.freelancer.utils.msgutils.MsgCode;
import com.freelancer.freelancer.utils.msgutils.MsgUtil;
import com.freelancer.freelancer.utils.sessionutils.SessionUtil;
import net.sf.json.JSONObject;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Map;


@RestController
public class LoginController {


    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    //public Msg login(@RequestParam(Constant.USERNAME) String username, @RequestParam(Constant.PASSWORD) String password, @RequestParam(Constant.REMEMBER_ME) Boolean remember){
    public Msg login(@RequestBody Map<String, String> params){
        String name = params.get(Constant.NAME);
        String password = params.get(Constant.PASSWORD);
        if (name == null || password == null) {
            return MsgUtil.makeMsg(MsgCode.NOT_ENTERING_ANYTHING);
        }
        User user = userService.checkUser(name, password);
        if(user != null){
            JSONObject obj = new JSONObject();
            obj.put(Constant.NAME, user.getName());
            obj.put(Constant.USER_TYPE, user.getType());
            SessionUtil.setSession(obj);

            JSONObject data = JSONObject.fromObject(user);
            data.remove(Constant.PASSWORD);

            return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.LOGIN_SUCCESS_MSG, data);
        }
        else{
            return MsgUtil.makeMsg(MsgCode.LOGIN_USER_ERROR);
        }
    }

    @RequestMapping("/logout")
    public Msg logout(){
        Boolean status = SessionUtil.removeSession();

        if(status){
            return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.LOGOUT_SUCCESS_MSG);
        }
        return MsgUtil.makeMsg(MsgCode.ERROR, MsgUtil.LOGOUT_ERR_MSG);
    }

    @RequestMapping("/register")
    public Msg addUser(@RequestBody Map<String, String> params) {
        String name = params.get(Constant.NAME);
        String password = params.get(Constant.PASSWORD);
        String phone = params.get(Constant.PHONE);
        String email = params.get(Constant.EMAIL);
        String true_name = params.get(Constant.TRUE_NAME);
        String credit_card = params.get(Constant.CREDIT_CARD);
        String type_s = params.get(Constant.TYPE);

        User newUser = new User();
        newUser.setName(name);
        newUser.setPassword(password);
        newUser.setPhone(phone);
        newUser.setEMail(email);
        newUser.setTrueName(true_name);
        newUser.setCreditCard(credit_card);
        newUser.setType(Integer.parseInt(type_s));

        User duplicate = userService.checkDuplicate(name);

        if (duplicate == null) {
            userService.addUser(newUser);

            JSONObject obj = new JSONObject();
            obj.put(Constant.NAME, newUser.getName());
            obj.put(Constant.USER_TYPE, newUser.getType());
            SessionUtil.setSession(obj);

            JSONObject data = JSONObject.fromObject(newUser);
            data.remove(Constant.PASSWORD);

            return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.REGISTER_SUCCESS_MSG, data);
        }
        else {
            return MsgUtil.makeMsg(MsgCode.DUPLICATE_USER_ERROR);
        }

    }

    @RequestMapping("/checkSession")
    public Msg checkSession(){
        JSONObject auth = SessionUtil.getAuth();

        if(auth == null){
            return MsgUtil.makeMsg(MsgCode.NOT_LOGGED_IN_ERROR);
        }
        else{
            return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.LOGIN_SUCCESS_MSG, auth);
        }
    }
}
