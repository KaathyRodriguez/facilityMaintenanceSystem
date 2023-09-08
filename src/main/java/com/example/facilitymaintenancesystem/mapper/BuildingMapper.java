package com.example.facilitymaintenancesystem.mapper;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.facilitymaintenancesystem.entity.Building;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Kevin
 * @since 2023-07-02
 */
public interface BuildingMapper extends BaseMapper<Building> {

    Page<Building> findPage(Page<Building> page, @Param("name") String name, @Param("address") String address, @Param("createTime") String createTime);
    void removeByBuildingName(@Param("name") String name);

    void removeByBuildingNames(@Param("names") List<String> names);


}
