package com.example.facilitymaintenancesystem.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.facilitymaintenancesystem.common.Constants;
import com.example.facilitymaintenancesystem.controller.dto.UserDTO;
import com.example.facilitymaintenancesystem.controller.dto.UserPasswordDTO;
import com.example.facilitymaintenancesystem.entity.User;
import com.example.facilitymaintenancesystem.exception.ServiceException;
import com.example.facilitymaintenancesystem.mapper.UserMapper;
import com.example.facilitymaintenancesystem.service.IUserService;
import com.example.facilitymaintenancesystem.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Kevin
 * @since 2023-05-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private static final Log LOG = Log.get();
    @Resource
    private UserMapper userMapper;

    @Override
    public UserDTO login(UserDTO userDTO) {

        User one = getUserInfo(userDTO);
        if (one != null) {
            BeanUtil.copyProperties(one, userDTO, true);
            //设置token
            String token = TokenUtils.getToken(one.getId().toString(), one.getPassword());
            userDTO.setPassword(SecureUtil.md5(userDTO.getPassword()));
            userDTO.setToken(token);
            return userDTO;

        } else {
            throw new ServiceException(Constants.CODE_600, "用户名或密码错误");
        }
    }

    private User getUserInfo(UserDTO userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userDTO.getUsername());
        queryWrapper.eq("password", userDTO.getPassword());
        User one;
        try {
            one = getOne(queryWrapper); // 从数据库查询用户信息
        } catch (Exception e) {
            LOG.error(e);
            throw new ServiceException(Constants.CODE_500, "系统错误");
        }
        return one;
    }

    @Override
    public  User getById(String id)
    {
        return userMapper.getById(id);
    };


    @Override
    public Page<User> findPage(Page<User> page, String id, String username, String role) {
        return userMapper.findPage(page, id, username, role);
    };
    @Override
    public void removeById(String id)
    {
        userMapper.removeById(id);
    };

    @Override
    public void removeByIds(List<String> ids)
    {
        userMapper.removeByIds(ids);
    };

    @Override
    public void updatePassword(UserPasswordDTO userPasswordDTO) {
        int update = userMapper.updatePassword(userPasswordDTO);
        if (update < 1) {
            throw new ServiceException(Constants.CODE_600, "密码错误");
        }
    }

    @Override
    public User register(UserDTO userDTO) {
        // 用户密码 md5加密
//        userDTO.setPassword(SecureUtil.md5(userDTO.getPassword()));
        User one = getUserInfo(userDTO);
        if (one == null) {
            one = new User();
            BeanUtil.copyProperties(userDTO, one, true);
//            one.setRole(userDTO.getRole());
//            String randomId = UUID.randomUUID().toString();
//            one.setId(randomId.substring(0, 8));
            if (one.getNickname() == null) {
                one.setNickname(one.getUsername());
            }
            save(one);  // 把 copy完之后的用户对象存储到数据库
        } else {
            throw new ServiceException(Constants.CODE_600, "用户已存在");
        }
        return one;
    }

}
