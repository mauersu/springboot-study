package com.demo.service;

import com.demo.dto.UserDTO;
import com.demo.entity.User;

public interface UserService {
    void save(User fromRequest);

    UserDTO getUserById(String userId);

    Integer deleteUserById(String userId);
}
