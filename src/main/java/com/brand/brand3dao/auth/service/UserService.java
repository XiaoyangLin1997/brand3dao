package com.brand.brand3dao.auth.service;

import com.brand.brand3dao.auth.model.dto.PubUserResp;
import com.brand.brand3dao.dal.entity.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Xiaoyang Lin
 * @since 2022-11-28
 */
public interface UserService extends IService<UserEntity> {
    PubUserResp getUserNonce(String publicAddress);
}
