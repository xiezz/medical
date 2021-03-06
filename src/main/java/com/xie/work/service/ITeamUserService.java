package com.xie.work.service;

import java.sql.Timestamp;
import java.util.Map;

/**
 * Created by xiezhongzheng on 2017/8/9.
 */
public interface ITeamUserService {

    //创建关系
    public Map<String,Object> createTeamUser( Long teamId,Long userId,Integer leader,String role,String teamName) throws Exception;

    //讨论列表
    public Map<String,Object> findTeamUser(Long userId) throws Exception;

    //讨论列表
    public Map<String,Object> findUserTeam(Long teamId) throws Exception;

    //修改信息
    public Map<String,Object> update(String title, String content, Timestamp create_time, Long user_id, Integer type) throws Exception;

}