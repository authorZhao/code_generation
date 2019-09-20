package com.git.service;

import com.git.model.dto.UserArticleDto;
import com.git.model.entity.OUser;
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
public interface OUserService extends IService<OUser> {

    List<UserArticleDto> selectUserArticle();
}
