package com.xie.work.controller;

import com.xie.work.domain.UserEntity;
import com.xie.work.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiezhongzheng on 2017/8/9.
 */

@Controller
@RequestMapping("/login")
public class LoginCtrl {
    @Autowired
    private ILoginService loginService;

    @RequestMapping(value="/login",method= RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> login(HttpServletRequest request, String username, String password){
        Map<String,Object> returnMap = new HashMap<String,Object>();

        try {
            Map<String,Object> map = loginService.login(username, password);
            //获取user实体
            Object object = map.get("value");
            if(object != null){
                UserEntity user = (UserEntity) object;
                HttpSession session = request.getSession();
                session.setAttribute("userId", user.getId());
            }
            returnMap.put("value", object);
            returnMap.put("message", map.get("message"));
            returnMap.put("success", map.get("success"));
        } catch (Exception e) {
            returnMap.put("message", "异常：登录失败!");
            returnMap.put("success", false);
            e.printStackTrace();
        }
        return returnMap;
    }

    @RequestMapping(value="/register",method=RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> register(HttpServletRequest request,String username,
                                       String password,String tel,String email){
        Map<String,Object> returnMap = new HashMap<String,Object>();

        try {
            Map<String,Object> map = loginService.register(username, password,tel,email);
            //获取user实体
            Object object = map.get("value");
            if(object != null){
                UserEntity user = (UserEntity) object;
                HttpSession session = request.getSession();
                session.setAttribute("userId", user.getId());
            }
            returnMap.put("value", object);
            returnMap.put("message", map.get("message"));
            returnMap.put("success", map.get("success"));
        } catch (Exception e) {
            returnMap.put("message", "异常：注册失败!");
            returnMap.put("success", false);
            e.printStackTrace();
        }
        return returnMap;
    }

}