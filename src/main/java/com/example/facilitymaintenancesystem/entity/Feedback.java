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
@TableName("feedback")
@ApiModel(value = "Feedback对象", description = "")
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("number")
    @TableId(value = "number", type = IdType.INPUT)
    private String number;

    @ApiModelProperty("type")
    private String type;

    @ApiModelProperty("topic")
    private String topic;

    @ApiModelProperty("content")
    private String content;

    @ApiModelProperty("person")
    private String person;

    @ApiModelProperty("telephone")
    private String telephone;

    @ApiModelProperty("createTime")
    private LocalDate createTime;

    @ApiModelProperty("flag")
    private String flag;


}
