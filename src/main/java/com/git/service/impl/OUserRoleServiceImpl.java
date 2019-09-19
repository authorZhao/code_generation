package com.git.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.git.model.entity.OUserRole;
import com.git.mapper.OUserRoleMapper;
import com.git.service.OUserRoleService;
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
public class OUserRoleServiceImpl extends ServiceImpl<OUserRoleMapper, OUserRole> implements OUserRoleService {
    private final Logger logger = LoggerFactory.getLogger(OUserRoleService.class);

    @Autowired
    private OUserRoleMapper oUserRoleMapper;
}
