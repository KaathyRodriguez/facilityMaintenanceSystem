package com.example.facilitymaintenancesystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.facilitymaintenancesystem.entity.Feedback;
import com.example.facilitymaintenancesystem.mapper.FeedbackMapper;
import com.example.facilitymaintenancesystem.service.IFeedbackService;
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
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements IFeedbackService {

    @Resource
    private FeedbackMapper feedbackMapper;

    @Override
    public Page<Feedback> findPage(Page<Feedback> page, String number, String type, String topic, String flag) {
        return feedbackMapper.findPage(page, number, type, topic,flag);
    };
    @Override
    public void removeByNumber(String number)
    {
        feedbackMapper.removeByNumber(number);
    };

    @Override
    public void removeByNumbers(List<String> numbers)
    {
        feedbackMapper.removeByNumbers(numbers);
    };

}
