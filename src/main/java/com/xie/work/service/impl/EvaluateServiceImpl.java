package com.xie.work.service.impl;

import com.xie.work.dao.IEvaluateDao;
import com.xie.work.dao.IUserDao;
import com.xie.work.domain.EvaluateEntity;
import com.xie.work.domain.TeamEntity;
import com.xie.work.domain.UserEntity;
import com.xie.work.service.IEvaluateService;
import com.xie.work.service.ILoginService;
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
public class EvaluateServiceImpl implements IEvaluateService {

    @Autowired
    private IEvaluateDao evaluateDao;


    public Map<String, Object> createEvaluate(Long teamId, Long userId, Long mateId, Long score, String reason) throws Exception {

            Map<String,Object> returnMap = new HashMap<String,Object>();
            EvaluateEntity evaluateEntity= new EvaluateEntity();
            evaluateEntity.setTeamId(teamId);
            evaluateEntity.setUserId(userId);
            evaluateEntity.setMateId(mateId);
            evaluateEntity.setScore(score);
            evaluateEntity.setReason(reason);
            evaluateDao.save(evaluateEntity);
            returnMap.put("value", evaluateDao);
            returnMap.put("message", "评论成功");
            returnMap.put("success", true);
            return returnMap;
        }

    public Map<String, Object> findEvaluate(Long mateId) throws Exception {
        return null;
    }

    public Map<String, Object> findUserTeam(Long teamId) throws Exception {
        return null;
    }

    public Map<String, Object> update(String title, String content, Timestamp create_time, Long user_id, Integer type) throws Exception {
        return null;
    }
}