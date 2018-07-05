package com.jiangzhuolin.userservice.controller;

import com.jiangzhuolin.userservice.bean.User;
import com.jiangzhuolin.userservice.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserRepository userRepository;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public User save(User user) {
        User savedUser = userRepository.save(user);
        savedUser.setPassword("");
        return savedUser;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getOne(@PathVariable("id") long id) {
        User user = userRepository.findUserById(id);
        user.setPassword("");
        return user;
    }

    @RequestMapping(value = "/all")
    @ResponseBody
    public List<User> findAll() {
        List<User> userList = userRepository.findAll();
        for (User user : userList) {
            user.setPassword("");
        }
        return userList;
    }
}
