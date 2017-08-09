package com.xie.work.user.dao.impl;

import com.xie.work.base.dao.impl.BaseDaoImpl;
import com.xie.work.user.dao.IUserDao;
import com.xie.work.user.model.User;
import org.springframework.stereotype.Component;

/**
 * Created by xiezhongzheng on 2017/8/9.
 */
@Component
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

    public UserDaoImpl(){
        super(User.class);
    }

}
