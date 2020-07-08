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

//    @RequestMapping("/register")
//    public Msg addUser(@RequestBody Map<String, String> params) {
//        String username = params.get(Constant.USERNAME);
//        String password = params.get(Constant.PASSWORD);
//        String confirmPassword = params.get(Constant.CONFIRMPASSWORD);
//        String email = params.get(Constant.EMAIL);
//        String tel = params.get(Constant.TEL);
//        System.out.println(password);
//        System.out.println(confirmPassword);
//        if (!password.equals(confirmPassword)) {
//            return MsgUtil.makeMsg(MsgCode.CONFIRM_PASSWORD_ERROR);
//        }
//        System.out.println(password);
//        System.out.println(confirmPassword);
//
//        User newUser = new User();
//        newUser.setUserName(username);
//        newUser.setEmail(email);
//        newUser.setTel(tel);
//        newUser.setUserType(0);
//        newUser.setIsBanned(0);
//
//        UserAuth newUserAuth = new UserAuth();
//        newUserAuth.setUsername(username);
//        newUserAuth.setPassword(password);
//        newUserAuth.setUserType(0);
//        newUserAuth.setIsBanned(0);
//
//        UserAuth auth = userService.checkDuplicate(username);
//
//        if (auth == null) {
//            userService.addUser(newUser);
//            userService.addUserAuth(newUserAuth);
//
//            JSONObject obj = new JSONObject();
//            obj.put(Constant.USERNAME, newUserAuth.getUsername());
//            obj.put(Constant.USER_TYPE, newUserAuth.getUserType());
//            SessionUtil.setSession(obj);
//
//            JSONObject data = JSONObject.fromObject(newUserAuth);
//            data.remove(Constant.PASSWORD);
//
//            return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.REGISTER_SUCCESS_MSG, data);
//        }
//        else {
//            return MsgUtil.makeMsg(MsgCode.DUPLICATE_USER_ERROR);
//        }
//
//    }

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
