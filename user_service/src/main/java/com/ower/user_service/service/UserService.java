package com.ower.user_service.service;

import com.ower.user_service.VO.Department;
import com.ower.user_service.VO.ResponseTempleteVO;
import com.ower.user_service.entity.User;
import com.ower.user_service.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public User saveUser(User user) {
        log.info("Inside saveUser method of UserService");
        return userRepository.save(user);
    }

    public ResponseTempleteVO getUserWithDepartment(Long userId) {
        ResponseTempleteVO vo = new ResponseTempleteVO();
        User user = userRepository.findById(userId).get();
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);

        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
