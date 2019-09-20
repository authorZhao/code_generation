package com.git.service.impl;

import com.git.model.dto.UserArticleDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.git.model.entity.OUser;
import com.git.mapper.OUserMapper;
import com.git.service.OUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author authorZhao
 * @since 2019-09-19
 */
@Service
public class OUserServiceImpl extends ServiceImpl<OUserMapper, OUser> implements OUserService {
    private final Logger logger = LoggerFactory.getLogger(OUserService.class);

    @Autowired
    private OUserMapper oUserMapper;

    @Override
    public List<UserArticleDto> selectUserArticle() {
        return oUserMapper.selectUserArticle();
    }
}
