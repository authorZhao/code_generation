package com.git.model.dto;

import com.git.model.entity.BArticle;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 文章分页列表对象
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="BArticleDto对象", description="")
public class BArticleDto extends BArticle {
    private String userName;
}
