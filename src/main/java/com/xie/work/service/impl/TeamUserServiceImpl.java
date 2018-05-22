package com.xie.work.service.impl;

import com.xie.work.dao.ITeamDao;
import com.xie.work.dao.ITeamUserDao;
import com.xie.work.domain.TeamEntity;
import com.xie.work.domain.TeamUserEntity;
import com.xie.work.service.ITeamService;
import com.xie.work.service.ITeamUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiezhongzheng on 2017/8/9.
 */
@Component
public class TeamUserServiceImpl implements ITeamUserService {

    @Autowired
    private ITeamUserDao teamUserDao;

    public Map<String,Object>  createTeamUser( Long teamId,Long userId,Integer leader,String role) throws Exception{

        Map<String,Object> returnMap = new HashMap<String,Object>();
        TeamUserEntity teamUserEntity= new TeamUserEntity();
        teamUserEntity.setTeamId(teamId);
        teamUserEntity.setRole(role);
        teamUserEntity.setUserId(userId);
        teamUserEntity.setLeader(leader);
        teamUserDao.save(teamUserEntity);
        returnMap.put("value", teamUserEntity);
        returnMap.put("message", "创建团队成功");
        returnMap.put("success", true);
        return returnMap;
    }

    public Map<String, Object> findComment(Long aid) throws Exception {
        return null;
    }


    public Map<String,Object> update(String title, String content, Timestamp create_time ,Long user_id,Integer type) throws Exception{
        Map<String,Object> returnMap = new HashMap<String,Object>();

        return returnMap;
    }
}