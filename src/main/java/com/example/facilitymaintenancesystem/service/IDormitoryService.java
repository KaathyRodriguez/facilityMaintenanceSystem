package com.example.facilitymaintenancesystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.facilitymaintenancesystem.entity.Dormitory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Kevin
 * @since 2023-07-02
 */
public interface IDormitoryService extends IService<Dormitory> {

    Page<Dormitory> findPage(Page<Dormitory> page, String number, String building, String unit);

    void removeByNumber(String number);

    void removeByNumbers(List<String> numbers);

}
