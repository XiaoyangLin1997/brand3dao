package com.brand.brand3dao.auth.controller;

import com.brand.brand3dao.auth.model.dto.AuthTokenResponse;
import com.brand.brand3dao.auth.model.dto.LoginRequest;
import com.brand.brand3dao.auth.model.dto.PubUserResp;
import com.brand.brand3dao.auth.model.dto.SignUpRequest;
import com.brand.brand3dao.auth.service.AuthService;
import com.brand.brand3dao.auth.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
//@RequestMapping(value = "/public", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping(value = "/public")
public class PublicApi {

    @Resource
    private AuthService authService;

    @Resource
    private UserService userService;


    //todo wrap result

    // GET
    @GetMapping(value = "/user/{publicAddress}")
    public PubUserResp checkUserExists(@PathVariable("publicAddress") String publicAddress) {
        System.out.println("checkUserExists");
        return userService.getUserNonce(publicAddress);
    }

    // POST
    @PostMapping(value = "/signup")
    public PubUserResp signup(@RequestBody SignUpRequest signUpRequest) {
        System.out.println("signup");
        return authService.signup(signUpRequest);
    }

    @PostMapping(value = "/login")
    public AuthTokenResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
