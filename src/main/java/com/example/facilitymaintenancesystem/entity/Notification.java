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
@TableName("notification")
@ApiModel(value = "Notification对象", description = "")
public class Notification implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("number")
    @TableId(value = "number", type = IdType.INPUT)
    private String number;

    @ApiModelProperty("topic")
    private String topic;

    @ApiModelProperty("publisher")
    private String publisher;

    @ApiModelProperty("createTime")
    private LocalDate createTime;


}
