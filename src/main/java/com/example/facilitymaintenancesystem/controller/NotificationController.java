package com.example.facilitymaintenancesystem.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.facilitymaintenancesystem.common.Result;

import com.example.facilitymaintenancesystem.service.INotificationService;
import com.example.facilitymaintenancesystem.entity.Notification;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Kevin
 * @since 2023-07-02
 */
@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Resource
    private INotificationService notificationService;

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody Notification notification) {

        try {
            notificationService.saveOrUpdate(notification);
            return Result.success();
        }catch (Exception e)
        {
            return Result.error();
        }
    }

    @DeleteMapping("/{number}")
    public Result delete(@PathVariable String number) {
        notificationService.removeByNumber(number);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<String> numbers) {
        notificationService.removeByNumbers(numbers);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        return Result.success(notificationService.list());
    }


    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String number,
                           @RequestParam(defaultValue = "") String topic,
                           @RequestParam(defaultValue = "") String createTime) {
        return Result.success(notificationService.findPage(new Page<>(pageNum, pageSize), number,topic,createTime));
    }

}

