package com.example.facilitymaintenancesystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.facilitymaintenancesystem.entity.Building;
import com.example.facilitymaintenancesystem.entity.Dormitory;
import com.example.facilitymaintenancesystem.mapper.DormitoryMapper;
import com.example.facilitymaintenancesystem.service.IDormitoryService;
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
public class DormitoryServiceImpl extends ServiceImpl<DormitoryMapper, Dormitory> implements IDormitoryService {
    @Resource
    private DormitoryMapper dormitoryMapper;

    @Override
    public Page<Dormitory> findPage(Page<Dormitory> page, String number, String building, String unit) {
        return dormitoryMapper.findPage(page, number, building, unit);
    };
    @Override
    public void removeByNumber(String number)
    {
        dormitoryMapper.removeByNumber(number);
    };

    @Override
    public void removeByNumbers(List<String> numbers)
    {
        dormitoryMapper.removeByNumbers(numbers);
    };

}
