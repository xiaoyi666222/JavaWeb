package com.common.service.impl;


import com.common.entity.User;
import com.common.mapper.UserMapper;
import com.common.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    public User findByUsername(@Param("username") String username, @Param("password") String password){
        return userMapper.findByUsername(username,password);
    }

    public User findById(int id){
        return userMapper.findById(id);
    }


    /*
     * 新增用戶
     * @param user
     * @return
     * @throws Exception
     */
    public int insertUser(User user) throws Exception {
        return userMapper.insertUser(user);
    }



    /*
     * 查询所有的用户信息
     * @return
     * @throws Exception
     */
    public List<User> findAll() {

        List<User> userList = userMapper.findAll();
        return userList;
    }
}

