package com.example.facilitymaintenancesystem.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import cn.hutool.core.date.DateTime;
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
@TableName("building")
@ApiModel(value = "Building对象", description = "")
public class Building implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("name")
    @TableId(value = "name", type = IdType.INPUT)
    private String name;

    @ApiModelProperty("address")
    private String address;

    @ApiModelProperty("createTime")
    private LocalDate createTime;


}
