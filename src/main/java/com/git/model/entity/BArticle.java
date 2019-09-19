package com.git.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author authorZhao
 * @since 2019-09-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BArticle对象", description="")
public class BArticle implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
    * 文章标题
    */
    @ApiModelProperty(value = "文章标题")
    private String title;

    /**
    * 用户ID，对应user表id
    */
    @ApiModelProperty(value = "用户ID，对应user表id")
    private Long userId;

    /**
    * 文章封面图片
    */
    @ApiModelProperty(value = "文章封面图片")
    private String coverImage;

    /**
    * 文章专属二维码地址
    */
    @ApiModelProperty(value = "文章专属二维码地址")
    private String qrcodePath;

    /**
    * 编辑器类型，0 markdown，1 html
    */
    @ApiModelProperty(value = "编辑器类型，0 markdown，1 html")
    private Integer editorType;

    /**
    * 文章内容
    */
    @ApiModelProperty(value = "文章内容")
    private String content;

    /**
    * 是否置顶，0不置顶，1置顶
    */
    @ApiModelProperty(value = "是否置顶，0不置顶，1置顶")
    private Integer top;

    /**
    * 文章标签名，用逗号分隔,
    */
    @ApiModelProperty(value = "文章标签名，用逗号分隔,")
    private String tagName;

    /**
    * 博文状态，1表示已经发表，2表示在草稿箱，3表示在垃圾箱
    */
    @ApiModelProperty(value = "博文状态，1表示已经发表，2表示在草稿箱，3表示在垃圾箱")
    private Integer status;

    /**
    * 是否推荐，0不推荐，1推荐
    */
    @ApiModelProperty(value = "是否推荐，0不推荐，1推荐")
    private Integer recommended;

    /**
    * 0原创，1转载，2翻译
    */
    @ApiModelProperty(value = "0原创，1转载，2翻译")
    private Integer articleNature;

    /**
    * 文章简介，最多200字
    */
    @ApiModelProperty(value = "文章简介，最多200字")
    private String description;

    /**
    * 文章关键字，优化搜索
    */
    @ApiModelProperty(value = "文章关键字，优化搜索")
    private String keywords;

    /**
    * 是否开启评论，0不开启，1开启
    */
    @ApiModelProperty(value = "是否开启评论，0不开启，1开启")
    private Integer comment;

    /**
    * 添加时间
    */
    @ApiModelProperty(value = "添加时间")
    private Date createTime;

    /**
    * 更新时间
    */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
    * 0公开，1私密
    */
    @ApiModelProperty(value = "0公开，1私密")
    private Integer isPublic;


}
