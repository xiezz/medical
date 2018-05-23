package com.xie.work.service;

import java.sql.Timestamp;
import java.util.Map;

/**
 * Created by xiezhongzheng on 2017/8/9.
 */
public interface ITeamService {

    //创建讨论
    public Map<String,Object> createTeam(Long team_id,String teamName,Integer num, String slogan) throws Exception;

    //讨论列表
    public Map<String,Object> findTeam(Long tid) throws Exception;


    //讨论列表
    public Map<String,Object> findOneTeam(Long teamId) throws Exception;

    //修改信息
    public Map<String,Object> update(String title, String content, Timestamp create_time, Long user_id, Integer type) throws Exception;

}