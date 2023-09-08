package com.example.facilitymaintenancesystem.entity;

import java.io.Serializable;

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
@TableName("student")
@ApiModel(value = "Student对象", description = "")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty("name")
    private String name;

    @ApiModelProperty("sex")
    private String sex;

    @ApiModelProperty("building")
    private String building;

    @ApiModelProperty("unit")
    private String unit;

    @ApiModelProperty("number")
    private String number;

    @ApiModelProperty("cardID")
    private String cardID;

    @ApiModelProperty("telephone")
    private String telephone;

    @ApiModelProperty("email")
    private String email;


}
