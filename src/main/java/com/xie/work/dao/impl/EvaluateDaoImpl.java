package com.xie.work.dao.impl;

import com.xie.work.dao.IEvaluateDao;
import com.xie.work.dao.IRequestDao;
import com.xie.work.domain.EvaluateEntity;
import com.xie.work.domain.RequestEntity;
import org.springframework.stereotype.Component;

/**
 * Created by xiezhongzheng on 2017/8/9.
 */
@Component
public class EvaluateDaoImpl extends BaseDaoImpl<EvaluateEntity> implements IEvaluateDao {

    public EvaluateDaoImpl(){
        super(EvaluateEntity.class);
    }

}
