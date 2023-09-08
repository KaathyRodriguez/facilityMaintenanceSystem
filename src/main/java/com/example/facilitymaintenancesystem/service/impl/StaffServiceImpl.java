package com.example.facilitymaintenancesystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.facilitymaintenancesystem.entity.Building;
import com.example.facilitymaintenancesystem.entity.Staff;
import com.example.facilitymaintenancesystem.mapper.BuildingMapper;
import com.example.facilitymaintenancesystem.mapper.StaffMapper;
import com.example.facilitymaintenancesystem.service.IStaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements IStaffService {

    @Resource
    private StaffMapper staffMapper;

    @Override
    public Page<Staff> findPage(Page<Staff> page, String number, String name, String createTime) {
        return staffMapper.findPage(page, number, name, createTime);
    };
    @Override
    public void removeByNumber(String number)
    {
        staffMapper.removeByNumber(number);
    };

    @Override
    public void removeByNumbers(List<String> numbers)
    {
        staffMapper.removeByNumbers(numbers);
    };

}
