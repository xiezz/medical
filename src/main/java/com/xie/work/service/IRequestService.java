package com.xie.work.service;

import java.sql.Timestamp;
import java.util.Map;

/**
 * Created by xiezhongzheng on 2017/8/9.
 */
public interface IRequestService {

    //创建关系
    public Map<String,Object> createRequest(Long teamId, Long userId,String content) throws Exception;

    //讨论列表
    public Map<String,Object> findRequest(Long teamId) throws Exception;

    //讨论列表
    public Map<String,Object> findUserTeam(Long teamId) throws Exception;

    //修改信息
    public Map<String,Object> update(String title, String content, Timestamp create_time, Long user_id, Integer type) throws Exception;

}