package com.example.facilitymaintenancesystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.facilitymaintenancesystem.controller.dto.UserDTO;
import com.example.facilitymaintenancesystem.controller.dto.UserPasswordDTO;
import com.example.facilitymaintenancesystem.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Kevin
 * @since 2023-05-30
 */
public interface IUserService extends IService<User> {

    UserDTO login(UserDTO userDTO);

    User getById(String id);

    Page<User> findPage(Page<User> page, String id, String username, String role);

    void removeById(String id);

    void removeByIds(List<String> ids);

    void updatePassword(UserPasswordDTO userPasswordDTO);

    User register(UserDTO userDTO);

}
