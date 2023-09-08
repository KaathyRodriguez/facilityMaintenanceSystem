package com.example.facilitymaintenancesystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.facilitymaintenancesystem.entity.Feedback;
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
public interface IFeedbackService extends IService<Feedback> {

    Page<Feedback> findPage(Page<Feedback> page, String number, String type, String topic, String flag);

    void removeByNumber(String number);

    void removeByNumbers(List<String> numbers);
}
