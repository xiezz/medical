package com.xie.work.service.impl;


import com.xie.work.dao.ITeamUserDao;
import com.xie.work.domain.TeamUserEntity;
import com.xie.work.service.ITeamUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiezhongzheng on 2017/8/9.
 */
@Component
public class TeamUserServiceImpl implements ITeamUserService {

    @Autowired
    private ITeamUserDao teamUserDao;

    public Map<String,Object>  createTeamUser( Long teamId,Long userId,Integer leader,String role,String teamName) throws Exception{
        Map<String,Object> returnMap = new HashMap<String,Object>();
        TeamUserEntity teamUserEntity= new TeamUserEntity();
        teamUserEntity.setTeamId(teamId);
        teamUserEntity.setRole(role);
        teamUserEntity.setTeamName(teamName);
        teamUserEntity.setUserId(userId);
        teamUserEntity.setLeader(leader);
        teamUserDao.save(teamUserEntity);
        returnMap.put("value", teamUserEntity);
        returnMap.put("message", "创建团队成功");
        returnMap.put("success", true);
        return returnMap;
    }

    public Map<String, Object> findTeamUser(Long userId) throws Exception {

        Map<String,Object> returnMap = new HashMap<String,Object>();

        String hql = "from TeamUserEntity where  userId ="+userId+"";
        List<TeamUserEntity> teamUserList = new ArrayList();
        teamUserList = teamUserDao.findList(hql);
        if(teamUserList.size()>0) {
            returnMap.put("value", teamUserList);
            returnMap.put("message", "获取列表成功");
            returnMap.put("success", true);
        }else{
            returnMap.put("message", "获取列表失败!");
            returnMap.put("success", false);
        }
        return returnMap;
    }
    public Map<String, Object> findUserTeam(Long teamId)throws Exception {

        Map<String,Object> returnMap = new HashMap<String,Object>();

        String hql = "from TeamUserEntity where  teamId ="+teamId+"";
        List<TeamUserEntity> teamUserList = new ArrayList();
        teamUserList = teamUserDao.findList(hql);
        if(teamUserList.size()>0) {
            returnMap.put("value", teamUserList);
            returnMap.put("message", "获取列表成功");
            returnMap.put("success", true);
        }else{
            returnMap.put("message", "获取列表失败!");
            returnMap.put("success", false);
        }
        return returnMap;
    }

    public Map<String,Object> update(String title, String content, Timestamp create_time ,Long user_id,Integer type) throws Exception{
        Map<String,Object> returnMap = new HashMap<String,Object>();

        return returnMap;
    }
}