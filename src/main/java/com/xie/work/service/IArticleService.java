package com.xie.work.service;

import java.sql.Timestamp;
import java.util.Map;

/**
 * Created by xiezhongzheng on 2017/8/9.
 */
public interface IArticleService {

    //创建讨论
    public Map<String,Object> createDiscuss(String title, String content,Long user_id) throws Exception;

    //讨论列表
    public Map<String,Object> findDiscuss() throws Exception;

    //讨论列表
    public Map<String,Object> findTeam() throws Exception;

    //单讨论
    public Map<String,Object> findOneDiscuss(Long aid) throws Exception;

    //修改信息
    public Map<String,Object> update(String title, String content, Timestamp create_time ,Long user_id,Integer type) throws Exception;

}