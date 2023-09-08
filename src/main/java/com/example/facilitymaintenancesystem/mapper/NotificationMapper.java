package com.example.facilitymaintenancesystem.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.facilitymaintenancesystem.entity.Building;
import com.example.facilitymaintenancesystem.entity.Notification;
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
public interface NotificationMapper extends BaseMapper<Notification> {

    Page<Notification> findPage(Page<Notification> page, @Param("number") String number, @Param("topic") String topic, @Param("createTime") String createTime);

    void removeByNumber(@Param("number") String number);

    void removeByNumbers(@Param("numbers") List<String> numbers);

}
