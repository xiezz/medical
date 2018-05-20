package com.xie.work.dao.impl;

import com.xie.work.dao.IArticleDao;
import com.xie.work.domain.ArticleEntity;
import org.springframework.stereotype.Component;

/**
 * Created by xiezhongzheng on 2017/8/9.
 */
@Component
public class ArticleDaoImpl extends BaseDaoImpl<ArticleEntity> implements IArticleDao {

    public ArticleDaoImpl(){
        super(ArticleEntity.class);
    }

}

