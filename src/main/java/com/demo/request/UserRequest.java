package com.demo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserRequest {

    @NotBlank(message="用户名不可为空")
    private String name;
    @NotBlank(message="年龄不可为空")
    private String age;

}
