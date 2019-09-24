package com.rosegal.web.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVo {

    private String id;

    private String name;

    public UserVo() {

    }

    public UserVo(String id) {
        this.id = id;
    }

}
