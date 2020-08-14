package com.common.service;


import com.common.entity.User;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {

    public User findByUsername(@Param("username") String username, @Param("password") String password);
    public User findById(int id);
    public List<User> findAll();

    /*
     * 新增用戶
     * @param user
     * @return
     * @throws Exception
     */
    public int insertUser(User user) throws Exception;


}

