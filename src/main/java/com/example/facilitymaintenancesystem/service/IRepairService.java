package com.example.facilitymaintenancesystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.facilitymaintenancesystem.entity.Repair;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.facilitymaintenancesystem.entity.Staff;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Kevin
 * @since 2023-07-02
 */
public interface IRepairService extends IService<Repair> {

    Page<Repair> findPage(Page<Repair> page, String person, String topic, String state, String staffNo, String id);

    void removeByNumber(String number);

    void removeByNumbers(List<String> numbers);

    void accomplish(String number);

}
