package com.example.facilitymaintenancesystem.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.facilitymaintenancesystem.entity.Building;
import com.example.facilitymaintenancesystem.entity.Dormitory;
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
public interface DormitoryMapper extends BaseMapper<Dormitory> {

    Page<Dormitory> findPage(Page<Dormitory> page, @Param("number") String number, @Param("building") String building, @Param("unit") String unit);
    void removeByNumber(@Param("number") String number);

    void removeByNumbers(@Param("numbers") List<String> numbers);
}
