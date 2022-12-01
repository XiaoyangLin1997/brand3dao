package com.brand.brand3dao.auth.model.dto;

import lombok.Data;

@Data
public class LoginRequest {

    private String publicAddress;

    private String signiture;
}
