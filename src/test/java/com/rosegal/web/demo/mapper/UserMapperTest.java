package com.rosegal.web.demo.mapper;

import com.rosegal.web.demo.model.UserDo;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserMapperTest {

    private Long id;

    @Resource
    private UserMapper userMapper;

    //@After
    public void after() {
        userMapper.truncate();
    }

    @Test
    public void insert() {
        UserDo user = new UserDo();
        user.setUsername("张三");
        user.setNickname("zhangsan");
        user.setEmail("zhangsan@example.com");
        user.setIsLock(false);
        user.setCreatedAt(System.currentTimeMillis());
        user.setUpdatedAt(user.getCreatedAt());
        this.id = userMapper.insert(user);
        assertThat(this.id).isGreaterThan(0);
        UserDo user2 = new UserDo();
        user2.setUsername("李四");
        user2.setNickname("lisi");
        user2.setEmail("lisi@example.com");
        user2.setIsLock(false);
        user2.setCreatedAt(System.currentTimeMillis());
        user2.setUpdatedAt(user2.getCreatedAt());
        this.id = userMapper.insert(user2);
        assertThat(this.id).isGreaterThan(0);
    }

    @Test
    public void findById() {
        this.insert();
        UserDo user = userMapper.findById(this.id);
        assertThat(user.getId()).isEqualTo(this.id);
    }

    @Test
    public void deleteByQuery() {
        this.insert();
        UserDo user = new UserDo();
        user.setId(this.id);
        user.setEmail("zhanshan@example.com");
        assertThat(userMapper.deleteByQuery(user)).isEqualTo(1);
        assertThat(userMapper.findById(this.id)).isNull();
    }

}