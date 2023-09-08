package com.example.facilitymaintenancesystem.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.facilitymaintenancesystem.entity.Building;
import com.example.facilitymaintenancesystem.entity.Feedback;
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
public interface FeedbackMapper extends BaseMapper<Feedback> {

    Page<Feedback> findPage(Page<Feedback> page, @Param("number") String number, @Param("type") String type, @Param("topic") String topic,@Param("flag") String flag);

    void removeByNumber(@Param("number") String number);

    void removeByNumbers(@Param("numbers") List<String> numbers);

}
