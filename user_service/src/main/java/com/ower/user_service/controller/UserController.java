package com.ower.user_service.controller;

import com.ower.user_service.VO.ResponseTempleteVO;
import com.ower.user_service.entity.User;
import com.ower.user_service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveuser method of User controler");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTempleteVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Inside getUserWithDepartment method of UserController");
        return userService.getUserWithDepartment(userId);
    }
}
