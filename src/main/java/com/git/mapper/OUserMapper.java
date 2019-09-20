package com.git.mapper;

import com.git.model.dto.UserArticleDto;
import com.git.model.entity.OUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author authorZhao
 * @since 2019-09-19
 */
public interface OUserMapper extends BaseMapper<OUser> {

    @ResultMap("selectUserArticle")
    @Select("select a.user_id,a.username,a.email,a.mobile,a.sex,a.theme,a.head_img,b.title from o_user a inner join b_article b on a.user_id=b.user_id")
    List<UserArticleDto> selectUserArticle();
}
