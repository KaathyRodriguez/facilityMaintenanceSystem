package com.example.facilitymaintenancesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.facilitymaintenancesystem.controller.dto.UserPasswordDTO;
import com.example.facilitymaintenancesystem.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Kevin
 * @since 2023-05-30
 */
public interface UserMapper extends BaseMapper<User> {

    Page<User> findPage(Page<User> page, @Param("id") String id, @Param("username") String username, @Param("role") String role);
    void removeById(@Param("id") String id);

    void removeByIds(@Param("ids") List<String> ids);

    @Select("SELECT * FROM User WHERE id = #{id}")
    User getById(String id);

    @Update("update User set password = #{newPassword} where username = #{username} and password = #{password}")
    int updatePassword(UserPasswordDTO userPasswordDTO);
}
