package com.git.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.git.model.entity.OBlog;
import com.git.mapper.OBlogMapper;
import com.git.service.OBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客 服务实现类
 * </p>
 *
 * @author authorZhao
 * @since 2019-09-12
 */
@Service
public class OBlogServiceImpl extends ServiceImpl<OBlogMapper, OBlog> implements OBlogService {
    private final Logger logger = LoggerFactory.getLogger(OBlogService.class);

    @Autowired
    private OBlogMapper oBlogMapper;
}
