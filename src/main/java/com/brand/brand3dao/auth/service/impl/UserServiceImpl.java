package com.brand.brand3dao.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brand.brand3dao.auth.exception.ServiceException;
import com.brand.brand3dao.auth.model.dto.PubUserResp;
import com.brand.brand3dao.auth.service.UserService;
import com.brand.brand3dao.dal.entity.UserEntity;
import com.brand.brand3dao.dal.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Resource
    private UserDao userDao;

    @Transactional(readOnly = true)
    @Override
    public PubUserResp getUserNonce(String publicAddress) {

        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(UserEntity.PUBLIC_ADDRESS, publicAddress);
        UserEntity userEntity = userDao.selectOne(wrapper);
        if (userEntity == null) {
            throw new ServiceException("Address doesnt exist");
        }

        PubUserResp resp = new PubUserResp();
        resp.setNonce(userEntity.getNonce());
        resp.setPublicAddress(userEntity.getPublicAddress());

        return resp;
    }
}
