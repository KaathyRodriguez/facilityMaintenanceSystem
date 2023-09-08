package com.example.facilitymaintenancesystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.facilitymaintenancesystem.common.Constants;
import com.example.facilitymaintenancesystem.entity.Repair;
import com.example.facilitymaintenancesystem.entity.Staff;
import com.example.facilitymaintenancesystem.exception.ServiceException;
import com.example.facilitymaintenancesystem.mapper.RepairMapper;
import com.example.facilitymaintenancesystem.service.IRepairService;
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
public class RepairServiceImpl extends ServiceImpl<RepairMapper, Repair> implements IRepairService {

    @Resource
    private RepairMapper repairMapper;

    @Override
    public Page<Repair> findPage(Page<Repair> page, String person, String topic, String state, String staffNo, String flag) {
        return repairMapper.findPage(page, person, topic, state,staffNo,flag);
    };
    @Override
    public void removeByNumber(String number)
    {
        repairMapper.removeByNumber(number);
    };

    @Override
    public void removeByNumbers(List<String> numbers)
    {
        repairMapper.removeByNumbers(numbers);
    };

    @Override
    public void accomplish(String number) {
        int update = repairMapper.accomplish(number);
        if (update < 1) {
            throw new ServiceException(Constants.CODE_600, "操作错误");
        }
    };

}
