package com.example.facilitymaintenancesystem.entity;

import java.io.Serializable;
import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Kevin
 * @since 2023-07-02
 */
@Getter
@Setter
@TableName("staff")
@ApiModel(value = "Staff对象", description = "")
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("number")
    @TableId(value = "number", type = IdType.INPUT)
    private String number;

    @ApiModelProperty("name")
    private String name;

    @ApiModelProperty("telephone")
    private String telephone;

    @ApiModelProperty("email")
    private String email;

    @ApiModelProperty("createTime")
    private LocalDate createTime;


}
