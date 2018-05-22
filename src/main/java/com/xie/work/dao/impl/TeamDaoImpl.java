package com.xie.work.dao.impl;

import com.xie.work.dao.ITeamDao;
import com.xie.work.dao.IUserDao;
import com.xie.work.domain.TeamEntity;
import com.xie.work.domain.UserEntity;
import org.springframework.stereotype.Component;

/**
 * Created by xiezhongzheng on 2017/8/9.
 */
@Component
public class TeamDaoImpl extends BaseDaoImpl<TeamEntity> implements ITeamDao {

    public TeamDaoImpl(){ super(TeamEntity.class);
    }

}
