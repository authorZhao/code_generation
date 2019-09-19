package com.git.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="OUserRole对象", description="")
public class OUserRole implements Serializable {

    private static final long serialVersionUID=1L;

    /**
    * id
    */
    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
    * 用户ID
    */
    @ApiModelProperty(value = "用户ID")
    private Long userId;

    /**
    * 角色ID
    */
    @ApiModelProperty(value = "角色ID")
    private Long roleId;


}
