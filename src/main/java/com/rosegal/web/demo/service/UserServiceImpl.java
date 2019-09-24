package com.rosegal.web.demo.service;

import com.rosegal.web.demo.mapper.UserMapper;
import com.rosegal.web.demo.model.RespVo;
import com.rosegal.web.demo.model.UserDo;
import com.rosegal.web.demo.model.UserVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public RespVo<UserVo> getUserById(Long id) {
        UserDo userDo = userMapper.findById(id);
        if (null == userDo) {
            return new RespVo<>(10000, "没有找到用户");
        }

        UserVo userVo = new UserVo();
        userVo.setId(String.valueOf(userDo.getId()));
        userVo.setName(userDo.getNickname());
        return new RespVo<>(userVo);
    }
}
