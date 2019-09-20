package com.git.mapper;

import com.git.config.MyLocalDateTimeTypeHandler;
import com.git.model.dto.BArticleDto;
import com.git.model.entity.BArticle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author authorZhao
 * @since 2019-09-19
 */
public interface BArticleMapper extends BaseMapper<BArticle> {
    @Results(id="selectArticleList",value={
            @Result(column="user_id", property="userId"),
            @Result(column="cover_image", property="coverImage"),
            @Result(column="qrcode_path", property="qrcodePath"),
            @Result(column="editor_type", property="editorType"),
            @Result(column="content", property="content"),
            @Result(column="top", property="top"),
            @Result(column="tag_name", property="tagName"),
            @Result(column="status", property="status"), @Result(column="recommended", property="recommended"),
            @Result(column="article_nature", property="articleNature"),
            @Result(column="description", property="description"),
            @Result(column="keywords", property="keywords"), @Result(column="comment", property="comment"),
            @Result(column="create_time", property="createTime"),
            @Result(column="update_time", property="updateTime"),
            @Result(column="is_public", property="isPublic"),
            @Result(column="username", property="userName")
    })
    @Select("SELECT a.*,b.username FROM b_article a LEFT JOIN o_user b ON a.user_id=b.user_id WHERE a.user_id=167")
    List<BArticleDto> selectArticleList();
}
