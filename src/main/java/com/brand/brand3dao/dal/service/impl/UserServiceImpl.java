package com.brand.brand3dao.dal.service.impl;

import com.brand.brand3dao.dal.entity.UserEntity;
import com.brand.brand3dao.dal.mapper.UserDao;
import com.brand.brand3dao.dal.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Xiaoyang Lin
 * @since 2022-11-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

}
