package com.xie.work.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.xie.work.dao.IUserDao;
import com.xie.work.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xie.work.service.ILoginService;
/**
 * Created by xiezhongzheng on 2017/8/9.
 */
@Component
public class LoginServiceImpl implements ILoginService  {

    @Autowired
    private IUserDao userDao;

    public Map<String, Object> login(String username, String password) throws Exception {
        Map<String,Object> returnMap = new HashMap<String,Object>();

        String hql = "from UserEntity u where u.username='"+username+"'";
        UserEntity user = new UserEntity();
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

        String hql = "from UserEntity u where u.username='"+username+"'";
        UserEntity user = new UserEntity();
        if(userDao.findOne(hql) != null){
            returnMap.put("message", "该用户名已存在...");
            returnMap.put("success", false);
            return returnMap;
        }else{
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            userDao.save(user);
            returnMap.put("value", user);
            returnMap.put("message", "注册成功");
            returnMap.put("success", true);
            return returnMap;
        }
    }

}  