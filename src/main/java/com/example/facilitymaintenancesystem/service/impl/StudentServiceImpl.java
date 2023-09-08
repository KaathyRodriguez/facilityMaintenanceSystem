package com.example.facilitymaintenancesystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.facilitymaintenancesystem.entity.Building;
import com.example.facilitymaintenancesystem.entity.Student;
import com.example.facilitymaintenancesystem.mapper.BuildingMapper;
import com.example.facilitymaintenancesystem.mapper.StudentMapper;
import com.example.facilitymaintenancesystem.service.IStudentService;
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
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public Page<Student> findPage(Page<Student> page, String id, String name, String sex) {
        return studentMapper.findPage(page, id, name, sex);
    };
    @Override
    public void removeById(String id)
    {
        studentMapper.removeById(id);
    };

    @Override
    public void removeByIds(List<String> ids)
    {
        studentMapper.removeByIds(ids);
    };

}
