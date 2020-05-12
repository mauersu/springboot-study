package com.demo.service.impl;

import com.demo.common.ErrorCodeEnum;
import com.demo.dao.UserMapper;
import com.demo.dto.UserDTO;
import com.demo.entity.User;
import com.demo.exception.BusinessException;
import com.demo.service.UserService;
import com.demo.utils.Inspections;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(User user) {
        int ret = userMapper.insertSelective(user);
        if (ret<1) {
            throw new BusinessException(ErrorCodeEnum.FAILED_INSERT_USER);
        }
    }

    @Override
    @Cacheable(value = "userDTO", key = "#userId", unless = "#result == null")
    public UserDTO getUserById(String userId) {
        User user = userMapper.selectByPrimaryKey(Long.parseLong(userId));
        UserDTO dto = new UserDTO();
        if (Inspections.isNotEmpty(user)) {
            BeanUtils.copyProperties(user, dto);
        }
        return dto;
    }

    @Override
    @Caching(evict = {@CacheEvict(value = "userDTO", key = "#userId", condition = "#result != 0")})
    public Integer deleteUserById(String userId) {
        int ret = userMapper.deleteByPrimaryKey(Long.parseLong(userId));
        return ret;
    }
}
