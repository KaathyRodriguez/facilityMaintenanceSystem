package com.example.facilitymaintenancesystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.facilitymaintenancesystem.entity.Building;
import com.example.facilitymaintenancesystem.entity.Notification;
import com.example.facilitymaintenancesystem.mapper.BuildingMapper;
import com.example.facilitymaintenancesystem.mapper.NotificationMapper;
import com.example.facilitymaintenancesystem.service.INotificationService;
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
public class NotificationServiceImpl extends ServiceImpl<NotificationMapper, Notification> implements INotificationService {

    @Resource
    private NotificationMapper notificationMapper;

    @Override
    public Page<Notification> findPage(Page<Notification> page, String number, String topic, String createTime) {
        return notificationMapper.findPage(page, number, topic, createTime);
    };
    @Override
    public void removeByNumber(String number)
    {
        notificationMapper.removeByNumber(number);
    };

    @Override
    public void removeByNumbers(List<String> numbers)
    {
        notificationMapper.removeByNumbers(numbers);
    };
}
