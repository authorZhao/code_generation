package com.git.model.dto;

import com.git.model.entity.BArticle;
import com.git.model.entity.OUser;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 文章列表对象
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UserArticleDto对象", description="")
public class UserArticleDto extends OUser {

    private List<BArticle> articleList;
}
