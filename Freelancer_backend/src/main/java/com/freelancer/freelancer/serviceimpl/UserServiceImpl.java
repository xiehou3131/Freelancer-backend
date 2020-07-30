package com.freelancer.freelancer.serviceimpl;

import com.freelancer.freelancer.constant.Constant;
import com.freelancer.freelancer.dao.AdministratorDao;
import com.freelancer.freelancer.dao.UserDao;
import com.freelancer.freelancer.entity.Administrator;
import com.freelancer.freelancer.entity.User;
import com.freelancer.freelancer.service.UserService;
import com.freelancer.freelancer.utils.msgutils.Msg;
import com.freelancer.freelancer.utils.msgutils.MsgCode;
import com.freelancer.freelancer.utils.msgutils.MsgUtil;
import com.freelancer.freelancer.utils.sessionutils.SessionUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private AdministratorDao administratorDao;

    @Override
    public User checkUser(String name, String password) {
        return userDao.checkUser(name, password);
    }

    @Override
    public User checkDuplicate(String name) { return userDao.checkDuplicate(name); }

    @Override
    public void addUser(User newUser) { userDao.addUser(newUser); }

    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public User findById(Integer uId) {
        User user =  userDao.findById(uId);
        user.setPassword(null);
        return user;
    }

    @Override
    public Msg login(String name, String password) {
        if (name == null || password == null) {
            return MsgUtil.makeMsg(MsgCode.NOT_ENTERING_ANYTHING);
        }
        User user = userDao.checkUser(name, password);
        if(user != null){
            JSONObject data = new JSONObject();
            data.put(Constant.NAME, user.getName());
            data.put(Constant.USER_TYPE, user.getType());
            SessionUtil.setSession(data);

            return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.LOGIN_SUCCESS_MSG, data);
        }
        Administrator administrator = administratorDao.checkAdmin(name, password);
        if(administrator != null) {
            JSONObject data = new JSONObject();
            data.put(Constant.NAME, administrator.getName());
            data.put(Constant.USER_TYPE, 1);
            SessionUtil.setSession(data);

            return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.LOGIN_SUCCESS_MSG, data);
        }
        else{
            return MsgUtil.makeMsg(MsgCode.LOGIN_USER_ERROR);
        }
    }

    @Override
    public boolean changeUserStatus(Integer u_id, Integer status) {
        User user = userDao.findById(u_id);
        user.setIs_banned(status);
        userDao.save(user);
        return true;
    }
}
