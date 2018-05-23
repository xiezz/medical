package com.xie.work.service.impl;

import com.xie.work.dao.ICommentDao;
import com.xie.work.dao.IRequestDao;
import com.xie.work.domain.CommentEntity;
import com.xie.work.domain.RequestEntity;
import com.xie.work.service.ICommentService;
import com.xie.work.service.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiezhongzheng on 2017/8/9.
 */
@Component
public class RequestServiceImpl implements IRequestService {

    @Autowired
    private ICommentDao commentDao;
    @Autowired
    private IRequestDao requestDao;

    public Map<String,Object> createComment( String content,Long user_id,Long article_id) throws Exception{
        //获取当前时间
        Timestamp time= new Timestamp(System.currentTimeMillis());//获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = df.format(time);
        time = Timestamp.valueOf(timeStr);

        Map<String,Object> returnMap = new HashMap<String,Object>();
        CommentEntity commentEntity= new CommentEntity();
        commentEntity.setContent(content);
        commentEntity.setCreateTime(timeStr);
        commentEntity.setUserId(user_id);
        commentEntity.setArticleId(article_id);
        commentDao.save(commentEntity);
        returnMap.put("value", commentEntity);
        returnMap.put("message", "发布评论成功");
        returnMap.put("success", true);
        return returnMap;
    }

    public Map<String,Object> findComment(Long aid) throws Exception{

        Map<String,Object> returnMap = new HashMap<String,Object>();

        String hql = "from CommentEntity where  articleId ="+aid+"";
        List<CommentEntity> commentList = new ArrayList();
        try {
            commentList = commentDao.findList(hql);
            for(CommentEntity comment:commentList ){
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                comment.setCreateTime(df.format(comment.getCreateTime()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(commentList.size()>0) {
            returnMap.put("value", commentList);
            returnMap.put("message", "获取列表成功");
            returnMap.put("success", true);
        }else{
            returnMap.put("message", "获取列表失败!");
            returnMap.put("success", false);
        }
        return returnMap;
    }


    public Map<String, Object> createRequest(Long teamId, Long userId, String content) throws Exception {
        Timestamp time= new Timestamp(System.currentTimeMillis());//获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = df.format(time);

        Map<String,Object> returnMap = new HashMap<String,Object>();
        RequestEntity requestEntity = new RequestEntity();
        requestEntity.setContent(content);
        requestEntity.setCreateTime(timeStr);
        requestEntity.setReqUser(userId);
        requestEntity.setTeamId(teamId);
        requestEntity.setState("请求已发送");
        requestDao.save(requestEntity);
        returnMap.put("value", requestEntity);
        returnMap.put("message", "发送请求成功");
        returnMap.put("success", true);
        return returnMap;
    }

    public Map<String, Object> findRequest(Long teamId) throws Exception {
        Map<String,Object> returnMap = new HashMap<String,Object>();

        String hql = "from RequestEntity where  teamId ="+teamId+"";
        List<RequestEntity> requestEntityList = new ArrayList();
        try {
            requestEntityList = requestDao.findList(hql);
            for(RequestEntity comment:requestEntityList ){
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                comment.setCreateTime( df.format(DateFormat.getDateInstance().parse(comment.getCreateTime())));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(requestEntityList.size()>0) {
            returnMap.put("value", requestEntityList);
            returnMap.put("message", "获取列表成功");
            returnMap.put("success", true);
        }else{
            returnMap.put("message", "获取列表失败!");
            returnMap.put("success", false);
        }
        return returnMap;
    }

    public Map<String, Object> findTeamUser(Long userId) throws Exception {
        return null;
    }

    public Map<String, Object> findUserTeam(Long teamId) throws Exception {
        return null;
    }

    public Map<String,Object> update(String title, String content, Timestamp create_time , Long user_id, Integer type) throws Exception{
        Map<String,Object> returnMap = new HashMap<String,Object>();

        return returnMap;
    }
}