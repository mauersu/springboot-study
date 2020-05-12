package com.demo.factory;

import com.demo.entity.User;
import com.demo.request.UserRequest;
import org.springframework.beans.BeanUtils;

public class UserEntityFactory {

    public static User fromRequest(UserRequest request) {
        User entity = new User();
        BeanUtils.copyProperties(request, entity);
        return entity;
    }
}
