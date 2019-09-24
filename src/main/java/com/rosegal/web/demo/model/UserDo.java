package com.rosegal.web.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import javax.annotation.Resource;

import com.rosegal.web.demo.mapper.UserMapper;

@Getter
@Setter
public class UserDo {

    @Resource
    private UserMapper userMapper;

    private Long id;

    private String username;

    private String nickname;

    private String email;

    private Boolean isLock;

    private Long createdAt;

    private Long updatedAt;

    public List<UserDo> list() {
        return this.userMapper.findByQuery(null);
    }
}