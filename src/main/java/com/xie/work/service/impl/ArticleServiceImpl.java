package com.xie.work.service.impl;

import com.xie.work.dao.IArticleDao;
import com.xie.work.domain.ArticleEntity;
import com.xie.work.service.IArticleService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by xiezhongzheng on 2017/8/9.
 */
@Component
public class ArticleServiceImpl implements IArticleService{

    @Autowired
    private IArticleDao articleDao;


    public Map<String,Object> createDiscuss(String title, String content,Long user_id) throws Exception{
        //获取当前时间
        Timestamp time= new Timestamp(System.currentTimeMillis());//获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = df.format(time);
        time = Timestamp.valueOf(timeStr);

        Map<String,Object> returnMap = new HashMap<String,Object>();
        ArticleEntity articleEntity= new ArticleEntity();
        articleEntity.setContent(content);
        articleEntity.setTitle(title);
        articleEntity.setCreateTime(timeStr);
        articleEntity.setType(1);
        articleEntity.setUserId(user_id);
        articleDao.save(articleEntity);
        returnMap.put("value", articleEntity);
        returnMap.put("message", "发布文章成功");
        returnMap.put("success", true);
        return returnMap;
    }

    public Map<String,Object> findDiscuss() throws Exception{

        Map<String,Object> returnMap = new HashMap<String,Object>();

        String hql = "from ArticleEntity where type = 1";
        List<ArticleEntity> articleList = new ArrayList();
        try {
            articleList = articleDao.findList(hql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(articleList.size() > 0) {
            returnMap.put("value", articleList);
            returnMap.put("message", "获取列表成功");
            returnMap.put("success", true);
        }else{
            returnMap.put("message", "获取列表失败!");
            returnMap.put("success", false);
        }
        return returnMap;
    }
    public Map<String,Object> findOneDiscuss(Long aid) throws Exception{

        Map<String,Object> returnMap = new HashMap<String,Object>();
        String hql = "from ArticleEntity where type = 1 and aid="+aid+"";
        ArticleEntity articleEntity= new ArticleEntity();
        try {
            articleEntity= articleDao.findOne(hql);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            articleEntity.setCreateTime(df.format(articleEntity.getCreateTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(articleEntity != null) {
            returnMap.put("value", articleEntity);
            returnMap.put("message", "获取列表成功");
            returnMap.put("success", true);
        }else{
            returnMap.put("message", "获取列表失败!");
            returnMap.put("success", false);
        }
        return returnMap;
    }
    public Map<String,Object> findTeam() throws Exception{

        Map<String,Object> returnMap = new HashMap<String,Object>();

        String hql = "from ArticleEntity where type = 2";
        List<ArticleEntity> articleList = new ArrayList();
        try {
            articleList = articleDao.findList(hql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(articleList.size() > 0) {
            returnMap.put("value", articleList);
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