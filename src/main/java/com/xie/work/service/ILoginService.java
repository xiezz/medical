package com.xie.work.service;

import java.util.Map;

/**
 * Created by xiezhongzheng on 2017/8/9.
 */
public interface ILoginService {

    //登录
    public Map<String,Object> login(String username, String password) throws Exception;

    //查询用户
    public Map<String,Object> findOneUser(Long id) throws Exception;

    //注册
    public Map<String,Object> register(String username, String password, String tel, String email) throws Exception;

    //修改信息
    public Map<String,Object> update(String username,String realname ,String password, String tel, String email,String role) throws Exception;

}