package com.brand.brand3dao.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brand.brand3dao.auth.exception.ServiceException;
import com.brand.brand3dao.auth.model.dto.LoginRequest;
import com.brand.brand3dao.auth.model.dto.PubUserResp;
import com.brand.brand3dao.auth.model.dto.SignUpRequest;
import com.brand.brand3dao.auth.model.dto.AuthTokenResponse;
import com.brand.brand3dao.auth.security.JwtTokenProvider;
import com.brand.brand3dao.auth.service.AuthService;
import com.brand.brand3dao.dal.entity.UserEntity;
import com.brand.brand3dao.dal.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

@Service
public class AuthServiceImpl extends ServiceImpl<UserDao, UserEntity> implements AuthService {

    private static Random random;
    private static final String MESSAGE = "I am signing my one time nonce ";

    static {
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Resource
    private UserDao userDao;

    @Resource
    private JwtTokenProvider jwtTokenProvider;

    @Transactional
    @Override
    public PubUserResp signup(SignUpRequest signUpRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setPublicAddress(signUpRequest.getPublicAddress());
        userEntity.setNonce(random.nextLong());
        userDao.insert(userEntity);
        System.out.println("test" + userEntity);

        PubUserResp resp = new PubUserResp();
        resp.setPublicAddress(userEntity.getPublicAddress());
        resp.setNonce(userEntity.getNonce());
        return resp;
    }

    @Transactional
    @Override
    public AuthTokenResponse login(LoginRequest request) {
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(UserEntity.PUBLIC_ADDRESS, request.getPublicAddress());
        UserEntity userEntity = userDao.selectOne(wrapper);

        if (userEntity == null) {
            throw new ServiceException("Error");
        }

       // byte[] signByte = Numeric.hexStringToByteArray(request.getSigniture());
        try {
//            boolean isValid = verifyPrefixedMessage(
//                    Hash.sha3((MESSAGE + endUser.getNonce()).getBytes()), signByte,
//                    Numeric.cleanHexPrefix(request.getPublicAddress().toLowerCase())
//            );
           // if (isValid) {
                String token = jwtTokenProvider.createToken(userEntity.getId());
                AuthTokenResponse response = new AuthTokenResponse();
                response.setToken(token);
                userEntity.setNonce(random.nextLong());
                userDao.insert(userEntity);
                return response;
          //  } else {
          //      throw new ServiceException("");
         //   }
        } catch (Exception e) {
            throw new ServiceException("Auth Error");
        }
    }


//    private static boolean verifyPrefixedMessage(byte[] data, byte[] sig, String pubKeyAddress) throws SignatureException {
//        byte[] r = Arrays.copyOfRange(sig, 0, 32);
//        byte[] s = Arrays.copyOfRange(sig, 32, 64);
//        byte[] v = Arrays.copyOfRange(sig, 64, sig.length);
//        Sign.SignatureData signatureData = new Sign.SignatureData(v, r, s);
//        BigInteger recoveredPubKey = Sign.signedPrefixedMessageToKey(data, signatureData);
//        System.out.println(Keys.getAddress(recoveredPubKey));
//        System.out.println(pubKeyAddress);
//        return pubKeyAddress.equals(Keys.getAddress(recoveredPubKey));
//    }

}
