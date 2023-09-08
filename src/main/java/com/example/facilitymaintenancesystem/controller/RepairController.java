package com.example.facilitymaintenancesystem.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.facilitymaintenancesystem.common.Result;

import com.example.facilitymaintenancesystem.service.IRepairService;
import com.example.facilitymaintenancesystem.entity.Repair;

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
@RequestMapping("/repair")
public class RepairController {

    @Resource
    private IRepairService repairService;

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody Repair repair) {
        try {
            repairService.saveOrUpdate(repair);
            return Result.success();
        }catch (Exception e)
        {
            return Result.error();
        }
    }

    @DeleteMapping("/{number}")
    public Result delete(@PathVariable String number) {
        repairService.removeByNumber(number);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<String> numbers) {
        repairService.removeByNumbers(numbers);
        return Result.success();
    }


    @GetMapping("/{number}")
    public Result accomplish(@PathVariable String number){
        repairService.accomplish(number);
        return Result.success();
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String person,
                           @RequestParam(defaultValue = "") String topic,
                           @RequestParam(defaultValue = "") String state,
                           @RequestParam(defaultValue = "") String staffNo,
                           @RequestParam(defaultValue = "") String flag){
        return Result.success(repairService.findPage(new Page<>(pageNum, pageSize), person,topic,state,staffNo,flag));
    }


}

