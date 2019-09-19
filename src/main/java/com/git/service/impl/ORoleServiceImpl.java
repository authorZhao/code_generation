package com.git.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.git.model.entity.ORole;
import com.git.mapper.ORoleMapper;
import com.git.service.ORoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author authorZhao
 * @since 2019-09-19
 */
@Service
public class ORoleServiceImpl extends ServiceImpl<ORoleMapper, ORole> implements ORoleService {
    private final Logger logger = LoggerFactory.getLogger(ORoleService.class);

    @Autowired
    private ORoleMapper oRoleMapper;
}
