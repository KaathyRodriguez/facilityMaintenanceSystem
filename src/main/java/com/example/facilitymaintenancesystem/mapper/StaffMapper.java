package com.example.facilitymaintenancesystem.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.facilitymaintenancesystem.entity.Building;
import com.example.facilitymaintenancesystem.entity.Staff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Kevin
 * @since 2023-07-02
 */
public interface StaffMapper extends BaseMapper<Staff> {

    Page<Staff> findPage(Page<Staff> page, @Param("number") String number, @Param("name") String name, @Param("createTime") String createTime);

    void removeByNumber(@Param("number") String number);

    void removeByNumbers(@Param("numbers") List<String> numbers);

}
