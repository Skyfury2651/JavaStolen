package com.example.hellospring.controller;

import com.example.hellospring.model.dto.UserDTO;
import com.example.hellospring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Level;
import java.util.logging.Logger;


@Controller
@RequestMapping("/admin/users")
public class UserController {
    @Autowired
    private UserService userService;
    private final Logger logger = Logger.getLogger(UserController.class.getName());

    @RequestMapping(method = RequestMethod.GET)
    public String create(){
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("skyfury2651@gmail.com");
        userDTO.setUsername("skyfury2651@gmail.com");
        userDTO.setPhoneNumber("0583788236");
        userDTO.setPasswordHash("Handsome123!@#");

        logger.log(Level.SEVERE,userDTO.toString());

        userService.store(userDTO);

        return "blank";
    }
}
