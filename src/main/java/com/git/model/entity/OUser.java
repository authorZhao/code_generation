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
 * 
 * </p>
 *
 * @author authorZhao
 * @since 2019-09-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OUser对象", description="")
public class OUser implements Serializable {

    private static final long serialVersionUID=1L;

    /**
    * 用户ID
    */
    @ApiModelProperty(value = "用户ID")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
    * 用户名
    */
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
    * 密码
    */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
    * 盐值
    */
    @ApiModelProperty(value = "盐值")
    private String salt;

    /**
    * 部门ID
    */
    @ApiModelProperty(value = "部门ID")
    private Long deptId;

    /**
    * 邮箱
    */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
    * 联系电话
    */
    @ApiModelProperty(value = "联系电话")
    private String mobile;

    /**
    * 状态 0锁定 1有效
    */
    @ApiModelProperty(value = "状态 0锁定 1有效")
    private Integer status;

    /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
    * 修改时间
    */
    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    /**
    * 最近访问时间
    */
    @ApiModelProperty(value = "最近访问时间")
    private LocalDateTime lastLoginTime;

    /**
    * 性别 0男 1女
    */
    @ApiModelProperty(value = "性别 0男 1女")
    private Integer sex;

    /**
    * 主题
    */
    @ApiModelProperty(value = "主题")
    private String theme;

    /**
    * 头像
    */
    @ApiModelProperty(value = "头像")
    private String headImg;

    /**
    * 描述
    */
    @ApiModelProperty(value = "描述")
    private String description;


}
