package com.xie.work.login.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.xie.work.user.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xie.work.base.model.Page;
import com.xie.work.login.service.ILoginService;
import com.xie.work.user.model.User;
/**
 * Created by xiezhongzheng on 2017/8/9.
 */
@Component
public class LoginServiceImpl implements ILoginService  {

    @Autowired
    private IUserDao userDao;

    public Map<String, Object> login(String username, String password) throws Exception {
        Map<String,Object> returnMap = new HashMap<String,Object>();

        String hql = "from user u where u.username='"+username+"'";
        User user = new User();
        try {
            user = userDao.findOne(hql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(user != null){
            if(user.getPassword().equals(password)){
                returnMap.put("value", user);
                returnMap.put("message", "登录成功");
                returnMap.put("success", true);
            }else{
                returnMap.put("message", "密码错误");
                returnMap.put("success", false);
            }
        }else{
            returnMap.put("message", "该用户不存在!");
            returnMap.put("success", false);
        }
        return returnMap;
    }

    public Map<String, Object> register(String username, String password,String tel,String email) throws Exception {
        Map<String,Object> returnMap = new HashMap<String,Object>();

        String hql = "from user u where u.username='"+username+"'";
        User user = new User();
        if(userDao.findOne(hql) != null){
            returnMap.put("message", "该用户名已存在...");
            returnMap.put("success", false);
            return returnMap;
        }else{
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setCreateTime(new Date());
            userDao.save(user);
            returnMap.put("value", user);
            returnMap.put("message", "注册成功");
            returnMap.put("success", true);
            return returnMap;
        }
    }

}  