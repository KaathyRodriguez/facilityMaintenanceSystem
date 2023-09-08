package com.example.facilitymaintenancesystem.controller;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.facilitymaintenancesystem.common.Result;

import com.example.facilitymaintenancesystem.service.IStudentService;
import com.example.facilitymaintenancesystem.entity.Student;

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
@RequestMapping("/student")
public class StudentController {

    @Resource
    private IStudentService studentService;

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody Student student) {
        studentService.saveOrUpdate(student);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        studentService.removeById(id);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        studentService.removeByIds(ids);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        return Result.success(studentService.list());
    }


    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String id,
                           @RequestParam(defaultValue = "") String name,
                           @RequestParam(defaultValue = "") String sex) {
        return Result.success(studentService.findPage(new Page<>(pageNum, pageSize), id,name,sex));
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
        List<Student> students = CollUtil.newArrayList();
        for (List<Object> row : list) {

            Student student = new Student();
            student.setId(row.get(0).toString());
            student.setName(row.get(1).toString());
            student.setSex(row.get(2).toString());
            student.setBuilding(row.get(3).toString());
            student.setUnit(row.get(4).toString());
            student.setNumber(row.get(5).toString());
            student.setCardID(row.get(6).toString());
            student.setTelephone(row.get(7).toString());
            student.setEmail(row.get(8).toString());


            students.add(student);
        }

        studentService.saveBatch(students);
        return Result.success(true);
    }

    /**
     * 导出接口
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<Student> list = studentService.list();
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //自定义标题别名
        writer.addHeaderAlias("id", "学号");
        writer.addHeaderAlias("name", "姓名");
        writer.addHeaderAlias("sex", "性别");
        writer.addHeaderAlias("building", "所属楼栋");
        writer.addHeaderAlias("unit", "单元");
        writer.addHeaderAlias("number", "宿舍编号");
        writer.addHeaderAlias("cardID", "身份证号");
        writer.addHeaderAlias("telephone", "电话");
        writer.addHeaderAlias("email", "邮箱");
        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("学生信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();

    }

}

