package com.xie.work.service.impl;

import com.xie.work.dao.ICommentDao;
import com.xie.work.dao.ITeamDao;
import com.xie.work.domain.CommentEntity;

import com.xie.work.domain.TeamEntity;
import com.xie.work.service.ITeamService;
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
public class TeamServiceImpl implements ITeamService {

    @Autowired
    private ITeamDao teamDao;

    public Map<String,Object> createTeam(Long team_id,String teamName,Integer num, String slogan) throws Exception{
        //获取当前时间
        Timestamp time= new Timestamp(System.currentTimeMillis());//获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = df.format(time);

        Map<String,Object> returnMap = new HashMap<String,Object>();
        TeamEntity teamEntity= new TeamEntity();
        teamEntity.setUuid(team_id);
        teamEntity.setTeamName(teamName);
        teamEntity.setCreateTime(timeStr);
        teamEntity.setNum(num);
        teamEntity.setNowNum(1);
        teamEntity.setSlogan(slogan);
        teamDao.save(teamEntity);
        returnMap.put("value", teamEntity);
        returnMap.put("message", "创建队伍成功");
        returnMap.put("success", true);
        return returnMap;
    }

    public Map<String, Object> findTeam(Long tid) throws Exception {
        return null;
    }

    public Map<String, Object> findOneTeam(Long teamId) throws Exception {
        Map<String,Object> returnMap = new HashMap<String,Object>();

        String hql = "from TeamEntity  where uuid="+teamId+"";
        TeamEntity teamEntity = new TeamEntity();
        try {
            teamEntity = teamDao.findOne(hql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(teamEntity!=null){
            returnMap.put("value", teamEntity);
            returnMap.put("message", "查找成功");
            returnMap.put("success", true);

        }else{
            returnMap.put("message", "该队伍不存在!");
            returnMap.put("success", false);
        }
        return returnMap;
    }


    public Map<String,Object> update(String title, String content, Timestamp create_time ,Long user_id,Integer type) throws Exception{
        Map<String,Object> returnMap = new HashMap<String,Object>();

        return returnMap;
    }
}