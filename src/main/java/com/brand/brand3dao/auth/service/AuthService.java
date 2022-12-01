package com.brand.brand3dao.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.brand.brand3dao.auth.model.dto.AuthTokenResponse;
import com.brand.brand3dao.auth.model.dto.LoginRequest;
import com.brand.brand3dao.auth.model.dto.PubUserResp;
import com.brand.brand3dao.auth.model.dto.SignUpRequest;
import com.brand.brand3dao.dal.entity.UserEntity;

public interface AuthService extends IService<UserEntity> {
    PubUserResp signup(SignUpRequest signUpRequest);

    AuthTokenResponse login(LoginRequest request);
}
