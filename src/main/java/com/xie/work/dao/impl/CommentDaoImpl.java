package com.xie.work.dao.impl;

import com.xie.work.dao.ICommentDao;
import com.xie.work.domain.CommentEntity;
import org.springframework.stereotype.Component;

/**
 * Created by xiezhongzheng on 2017/8/9.
 */
@Component
public class CommentDaoImpl extends BaseDaoImpl<CommentEntity> implements ICommentDao {

    public CommentDaoImpl(){
        super(CommentEntity.class);
    }

}

