package com.example.facilitymaintenancesystem.controller;


import cn.hutool.core.collection.CollUtil;
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
import java.time.format.DateTimeFormatter;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.facilitymaintenancesystem.common.Result;

import com.example.facilitymaintenancesystem.service.IStaffService;
import com.example.facilitymaintenancesystem.entity.Staff;

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
@RequestMapping("/staff")
public class StaffController {

    @Resource
    private IStaffService staffService;

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody Staff staff) {
        try {
            staffService.saveOrUpdate(staff);
            return Result.success();
        }catch (Exception e)
        {
            return Result.error();
        }
    }

    @DeleteMapping("/{number}")
    public Result delete(@PathVariable String number) {
        staffService.removeByNumber(number);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<String> numbers) {
        staffService.removeByNumbers(numbers);
        return Result.success();
    }


    @GetMapping
    public Result findAll() {
        return Result.success(staffService.list());
    }


    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String number,
                           @RequestParam(defaultValue = "") String name,
                           @RequestParam(defaultValue = "") String createTime) {
        return Result.success(staffService.findPage(new Page<>(pageNum, pageSize), number,name,createTime));

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
        List<Staff> staffs = CollUtil.newArrayList();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (List<Object> row : list) {

            Staff staff = new Staff();
            staff.setNumber(row.get(0).toString());
            staff.setName(row.get(1).toString());
            staff.setTelephone(row.get(2).toString());
            staff.setEmail(row.get(3).toString());
            LocalDate createTime = LocalDate.parse(row.get(4).toString(), formatter);
            staff.setCreateTime(createTime);


            staffs.add(staff);
        }

        staffService.saveBatch(staffs);
        return Result.success(true);
    }

    /**
     * 导出接口
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<Staff> list = staffService.list();
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //自定义标题别名
        writer.addHeaderAlias("number", "编号");
        writer.addHeaderAlias("name", "姓名");
        writer.addHeaderAlias("telephone", "电话");
        writer.addHeaderAlias("email", "邮箱");
        writer.addHeaderAlias("createTime", "入职时间");
        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("维修人员信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();

    }

}

