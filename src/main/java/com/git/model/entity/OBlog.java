package com.git.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 博客
 * </p>
 *
 * @author authorZhao
 * @since 2019-09-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OBlog对象", description="博客")
public class OBlog implements Serializable {

    private static final long serialVersionUID=1L;

    /**
    * 博客id
    */
    @ApiModelProperty(value = "博客id")
    @TableId(value = "blog_id", type = IdType.AUTO)
    private Integer blogId;

    /**
    * 归类id
    */
    @ApiModelProperty(value = "归类id")
    private Integer categoryId;

    /**
    * 博文标题
    */
    @ApiModelProperty(value = "博文标题")
    private String title;

    /**
    * 博文摘要
    */
    @ApiModelProperty(value = "博文摘要")
    private String summary;

    /**
    * 博文状态，1表示已经发表，2表示在草稿箱，3表示在垃圾箱
    */
    @ApiModelProperty(value = "博文状态，1表示已经发表，2表示在草稿箱，3表示在垃圾箱")
    private Boolean status;

    /**
    * 权重
    */
    @ApiModelProperty(value = "权重")
    private Integer weight;

    /**
    * 是否推荐，1表示推荐，0表示不推荐
    */
    @ApiModelProperty(value = "是否推荐，1表示推荐，0表示不推荐")
    private Boolean support;

    /**
    * 点击次数
    */
    @ApiModelProperty(value = "点击次数")
    private Integer click;

    /**
    * 标图展示地址
    */
    @ApiModelProperty(value = "标图展示地址")
    private String headerImg;

    /**
    * 博文类型，1表示markdown，2表示富文本
    */
    @ApiModelProperty(value = "博文类型，1表示markdown，2表示富文本")
    private String type;

    /**
    * 博文正文内容
    */
    @ApiModelProperty(value = "博文正文内容")
    private String content;

    /**
    * 作者名称
    */
    @ApiModelProperty(value = "作者名称")
    private String userName;

    private LocalDateTime createTime;

    private String updateBy;

    private LocalDateTime updateTime;


}
