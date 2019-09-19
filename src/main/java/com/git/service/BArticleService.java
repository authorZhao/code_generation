package com.git.service;

import com.git.model.dto.BArticleDto;
import com.git.model.entity.BArticle;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author authorZhao
 * @since 2019-09-19
 */
public interface BArticleService extends IService<BArticle> {

    List<BArticleDto> selectArticleList();
}
