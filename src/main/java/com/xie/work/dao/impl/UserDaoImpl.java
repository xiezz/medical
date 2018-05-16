package com.xie.work.dao.impl;

import com.xie.work.dao.IUserDao;
import com.xie.work.domain.UserEntity;
import org.springframework.stereotype.Component;

/**
 * Created by xiezhongzheng on 2017/8/9.
 */
@Component
public class UserDaoImpl extends BaseDaoImpl<UserEntity> implements IUserDao {

    public UserDaoImpl(){
        super(UserEntity.class);
    }

}
