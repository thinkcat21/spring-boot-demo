package com.rosegal.web.demo.controller;

import com.rosegal.web.demo.model.RespVo;
import com.rosegal.web.demo.model.UserVo;
import com.rosegal.web.demo.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@RestController
@RequestMapping(UserController.BASE_PATH)
public class UserController {

    @Resource
    private UserService userService;

    static final String BASE_PATH = "users";

    /*
    @GetMapping("{id}")
    public RespVo<UserVo> getUserById(@PathVariable(value = "id") String id) {
        return new RespVo<>(new UserVo(id));
    }
     */

    @GetMapping("{id}")
    public RespVo<UserVo> getUserById(@PathVariable(value = "id") String id) {
        log.info("hello id: " + id);
        Long realId = Long.valueOf(id);
        if (realId <= 0) {
            return new RespVo<>(-1, "hello");
        }
        return userService.getUserById(realId);
    }

    @GetMapping("list")
    public RespVo<List<UserVo>> findUsers() {
        List<UserVo> users = new ArrayList<>();
        UserVo user1 = new UserVo();
        user1.setId("123");
        user1.setName("zhangsan张三");
        users.add(user1);
        users.add(new UserVo());
        return new RespVo<>(users);
    }

    @DeleteMapping("{id}")
    public RespVo<Map<String, Object>> deleteById(@PathVariable("id") String id) {
        Map<String, Object> ret = new HashMap<>(2, 1);
        ret.put("userId", id);
        ret.put("isDeleted", true);
        return new RespVo<>(ret);
    }

}
