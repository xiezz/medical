package com.xie.work.service;

import java.sql.Timestamp;
import java.util.Map;

/**
 * Created by xiezhongzheng on 2017/8/9.
 */
public interface ICommentService {

    //创建讨论
    public Map<String,Object> createComment(String content, Long user_id ,Long article_id) throws Exception;

    //讨论列表
    public Map<String,Object> findComment(Long aid) throws Exception;

    //修改信息
    public Map<String,Object> update(String title, String content, Timestamp create_time, Long user_id, Integer type) throws Exception;

}