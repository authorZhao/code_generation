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
@ApiModel(value="ORole对象", description="")
public class ORole implements Serializable {

    private static final long serialVersionUID=1L;

    /**
    * 角色ID
    */
    @ApiModelProperty(value = "角色ID")
    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

    /**
    * 角色名称
    */
    @ApiModelProperty(value = "角色名称")
    private String roleName;

    /**
    * 角色描述
    */
    @ApiModelProperty(value = "角色描述")
    private String remark;

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


}
