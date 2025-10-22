package com.cvbuilder.auth.controller;


import com.cvbuilder.auth.dto.RegisterRequestDTO;
import com.cvbuilder.auth.dto.UserResponseDTO;
import com.cvbuilder.auth.entity.User;
import com.cvbuilder.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final RabbitTemplate rabbitTemplate;
    private final TopicExchange exchange1;

    @PostMapping("/register")
    UserResponseDTO addUser(@RequestBody RegisterRequestDTO registerRequestDTO){
        User user = new User();
        user.setUsername(registerRequestDTO.getUsername());
        user.setEmail(registerRequestDTO.getEmail());
        user.setPassword(registerRequestDTO.getPassword());
        User newUser = this.userService.saveUser(user);
        return new UserResponseDTO(
                newUser.getEmail(),newUser.getId(),newUser.getUsername()
        );
    }

    @PostMapping("/generate")
    void generate(@RequestBody String message){
        log.info("ok");
        log.error("not ok");
        this.rabbitTemplate.
                convertAndSend(exchange1.getName(),"pdf.okk",message);
    }



}
