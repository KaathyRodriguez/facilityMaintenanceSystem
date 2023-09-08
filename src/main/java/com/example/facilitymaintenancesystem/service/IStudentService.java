package com.example.facilitymaintenancesystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.facilitymaintenancesystem.entity.Building;
import com.example.facilitymaintenancesystem.entity.Student;
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
public interface IStudentService extends IService<Student> {

    Page<Student> findPage(Page<Student> page, String id, String name, String sex);

    void removeById(String id);

    void removeByIds(List<String> ids);

}
