package com.brand.brand3dao.auth.model.dto;

import lombok.Data;

@Data
public class PubUserResp {

    private Long nonce;
    private String publicAddress;
}
