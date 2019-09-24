package com.rosegal.web.demo.service;

import com.rosegal.web.demo.model.RespVo;
import com.rosegal.web.demo.model.UserVo;

public interface UserService {

    public RespVo<UserVo> getUserById(Long id);

}
