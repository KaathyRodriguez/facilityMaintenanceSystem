package com.example.facilitymaintenancesystem.service;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.facilitymaintenancesystem.entity.Building;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Kevin
 * @since 2023-07-02
 */
public interface IBuildingService extends IService<Building> {

    Page<Building> findPage(Page<Building> page, String name, String address, String createTime);

    void removeByBuildingName(String name);

    void removeByBuildingNames(List<String> names);

}
