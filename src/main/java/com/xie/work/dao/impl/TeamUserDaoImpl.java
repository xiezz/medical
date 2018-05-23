package com.xie.work.dao.impl;

import com.xie.work.dao.ITeamUserDao;
import com.xie.work.domain.TeamUserEntity;
import org.springframework.stereotype.Component;

/**
 * Created by xiezhongzheng on 2017/8/9.
 */
@Component
public class TeamUserDaoImpl extends BaseDaoImpl<TeamUserEntity> implements ITeamUserDao {

    public TeamUserDaoImpl(){ super(TeamUserEntity.class);
    }

}
