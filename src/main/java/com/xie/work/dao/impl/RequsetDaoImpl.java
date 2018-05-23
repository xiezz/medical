package com.xie.work.dao.impl;

import com.xie.work.dao.IRequestDao;
import com.xie.work.dao.IUserDao;
import com.xie.work.domain.RequestEntity;
import com.xie.work.domain.UserEntity;
import org.springframework.stereotype.Component;

/**
 * Created by xiezhongzheng on 2017/8/9.
 */
@Component
public class RequsetDaoImpl extends BaseDaoImpl<RequestEntity> implements IRequestDao {

    public RequsetDaoImpl(){
        super(RequestEntity.class);
    }

}
