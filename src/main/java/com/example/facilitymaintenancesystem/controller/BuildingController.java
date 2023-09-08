package com.example.facilitymaintenancesystem.controller;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.facilitymaintenancesystem.entity.Student;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.facilitymaintenancesystem.common.Result;

import com.example.facilitymaintenancesystem.service.IBuildingService;
import com.example.facilitymaintenancesystem.entity.Building;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Kevin
 * @since 2023-07-02
 */
@RestController
@RequestMapping("/building")
public class BuildingController {

    @Resource
    private IBuildingService buildingService;

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody Building building) {
        try {
            buildingService.saveOrUpdate(building);
            return Result.success();
        }catch (Exception e)
        {
            return Result.error();
        }
    }

    @DeleteMapping("/{name}")
    public Result delete(@PathVariable String name) {
        buildingService.removeByBuildingName(name);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<String> names) {
        buildingService.removeByBuildingNames(names);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        return Result.success(buildingService.list());
    }


    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String name,
                           @RequestParam(defaultValue = "") String address,
                           @RequestParam(defaultValue = "") String createTime) {
        return Result.success(buildingService.findPage(new Page<>(pageNum, pageSize), name,address,createTime));
    }
    /**
     * excel 导入
     * @param file
     * @throws Exception
     */
    @PostMapping("/import")
    public Result imp(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        // 方式：忽略表头的中文，直接读取表的内容
        List<List<Object>> list = reader.read(1);
        List<Building> buildings = CollUtil.newArrayList();
        for (List<Object> row : list) {

            Building building = new Building();
            building.setName(row.get(0).toString());
            building.setAddress(row.get(1).toString());
            building.setCreateTime(LocalDate.parse(row.get(2).toString()));
            buildings.add(building);
        }

        buildingService.saveBatch(buildings);
        return Result.success(true);
    }

    /**
     * 导出接口
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<Building> list = buildingService.list();
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //自定义标题别名
        writer.addHeaderAlias("name", "楼栋名称");
        writer.addHeaderAlias("address", "楼栋地址");
        writer.addHeaderAlias("createTime", "楼栋投入使用日期");
        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("楼栋信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();

    }


}

