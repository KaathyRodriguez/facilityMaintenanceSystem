package com.example.facilitymaintenancesystem.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.facilitymaintenancesystem.entity.Building;
import com.example.facilitymaintenancesystem.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Kevin
 * @since 2023-07-02
 */
public interface StudentMapper extends BaseMapper<Student> {

    Page<Student> findPage(Page<Student> page, @Param("id") String id, @Param("name") String name, @Param("sex") String sex);

    void removeById(@Param("id") String id);

    void removeByIds(@Param("ids") List<String> ids);

}
