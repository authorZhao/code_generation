package com.git.service.impl;

import com.git.model.dto.BArticleDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.git.model.entity.BArticle;
import com.git.mapper.BArticleMapper;
import com.git.service.BArticleService;
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
public class BArticleServiceImpl extends ServiceImpl<BArticleMapper, BArticle> implements BArticleService {
    private final Logger logger = LoggerFactory.getLogger(BArticleService.class);

    @Autowired
    private BArticleMapper bArticleMapper;

    @Override
    public List<BArticleDto> selectArticleList() {
        return bArticleMapper.selectArticleList();
    }
}
