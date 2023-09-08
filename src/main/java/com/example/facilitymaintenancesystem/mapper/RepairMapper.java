package com.example.facilitymaintenancesystem.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.facilitymaintenancesystem.entity.Building;
import com.example.facilitymaintenancesystem.entity.Repair;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.facilitymaintenancesystem.entity.Staff;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Kevin
 * @since 2023-07-02
 */
public interface RepairMapper extends BaseMapper<Repair> {

    Page<Repair> findPage(Page<Repair> page, @Param("person") String person, @Param("topic") String topic, @Param("state") String state,@Param("staffNo") String staffNo, @Param("flag") String flag);
    void removeByNumber(@Param("number") String number);

    void removeByNumbers(@Param("numbers") List<String> numbers);

    @Update("update Repair set state = '已完成' where number = #{number} and state = '维修中'")
    int accomplish(@Param("number") String number);

}
