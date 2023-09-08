package com.example.facilitymaintenancesystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.facilitymaintenancesystem.entity.Building;
import com.example.facilitymaintenancesystem.entity.Notification;
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
public interface INotificationService extends IService<Notification> {

    Page<Notification> findPage(Page<Notification> page, String number, String topic, String createTime);

    void removeByNumber(String number);

    void removeByNumbers(List<String> number);

}
