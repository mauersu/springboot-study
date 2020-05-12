package com.demo.controller;

import com.demo.common.WebResponse;
import com.demo.dto.UserDTO;
import com.demo.factory.UserEntityFactory;
import com.demo.request.UserRequest;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserContorller {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public WebResponse<UserDTO> userInfo(String userId) {
        return WebResponse.success(userService.getUserById(userId));
    }

    @PostMapping("/user")
    public WebResponse userInfo(@Valid UserRequest request) {
        userService.save(UserEntityFactory.fromRequest(request));
        return WebResponse.success();
    }
}
