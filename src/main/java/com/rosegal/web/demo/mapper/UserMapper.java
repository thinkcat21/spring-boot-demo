package com.rosegal.web.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.rosegal.web.demo.model.UserDo;

import java.util.List;

@Mapper
public interface UserMapper {

    public Long insert(UserDo user);

    public UserDo findById(Long id);

    public List<UserDo> findByQuery(UserDo user);

    public Integer deleteByQuery(UserDo user);

    @Select("TRUNCATE `user`;")
    public void truncate();
}