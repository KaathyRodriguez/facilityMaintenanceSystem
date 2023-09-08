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
@TableName("repair")
@ApiModel(value = "Repair对象", description = "")
public class Repair implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("number")
    @TableId(value = "number", type = IdType.INPUT)
    private String number;

    @ApiModelProperty("topic")
    private String topic;

    @ApiModelProperty("person")
    private String person;

    @ApiModelProperty("contactNumber")
    private String contactNumber;

    @ApiModelProperty("content")
    private String content;

    @ApiModelProperty("state")
    private String state;

    @ApiModelProperty("staffNo")
    private String staffNo;

    @ApiModelProperty("staffNumber")
    private String staffNumber;

    @ApiModelProperty("createTime")
    private LocalDate createTime;

    @ApiModelProperty("flag")
    private String flag;


}
