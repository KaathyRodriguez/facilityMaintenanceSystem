package com.example.facilitymaintenancesystem.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.facilitymaintenancesystem.entity.Building;
import com.example.facilitymaintenancesystem.mapper.BuildingMapper;
import com.example.facilitymaintenancesystem.service.IBuildingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Kevin
 * @since 2023-07-02
 */
@Service
public class BuildingServiceImpl extends ServiceImpl<BuildingMapper, Building> implements IBuildingService {

    @Resource
    private BuildingMapper buildingMapper;

    @Override
    public Page<Building> findPage(Page<Building> page, String name, String address, String createTime) {
        return buildingMapper.findPage(page, name, address, createTime);
    };
    @Override
    public void removeByBuildingName(String name)
    {
        buildingMapper.removeByBuildingName(name);
    };

    @Override
    public void removeByBuildingNames(List<String> names)
    {
        buildingMapper.removeByBuildingNames(names);
    };

}
