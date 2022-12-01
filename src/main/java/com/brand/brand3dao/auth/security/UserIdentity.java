package com.brand.brand3dao.auth.security;

import com.brand.brand3dao.auth.exception.ServiceException;
import com.brand.brand3dao.dal.entity.UserEntity;
import com.brand.brand3dao.dal.mapper.UserDao;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Data
public class UserIdentity {

    private UserEntity userEntity;
    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = true)
    public void create(long userId) {
        UserEntity user = userDao.selectById(userId);
        if (user == null) {
            throw new ServiceException("Error");
        }
        this.userEntity = user;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
