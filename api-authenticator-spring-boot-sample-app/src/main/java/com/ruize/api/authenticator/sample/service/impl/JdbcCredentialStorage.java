package com.ruize.api.authenticator.sample.service.impl;

import com.ruize.api.authenticator.sample.entity.UserApi;
import com.ruize.api.authenticator.sample.mapper.UserApiMapper;
import com.ruize.api.authenticator.service.CredentialStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JdbcCredentialStorage implements CredentialStorage {

    @Autowired
    private UserApiMapper userApiMapper;

    @Override
    public String getPasswordByAppId(String appId) {
        UserApi userApi = userApiMapper.selectById(appId);
        if(userApi == null) {
            log.error("the appId {} from client request does not exist." , appId);
            throw new RuntimeException("Wrong appId: {}"+ appId);
        }
        return userApi.getApikey();
    }
}
