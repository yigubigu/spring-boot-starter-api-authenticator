package com.ruize.api.authenticator.service.impl;


import com.ruize.api.authenticator.ApiRequest;
import com.ruize.api.authenticator.AuthToken;
import com.ruize.api.authenticator.service.ApiAuthencator;
import com.ruize.api.authenticator.service.CredentialStorage;

import lombok.extern.slf4j.Slf4j;

import java.security.NoSuchAlgorithmException;

@Slf4j
public class DefaultApiAuthencatorImpl implements ApiAuthencator {

  private CredentialStorage credentialStorage;
  
  public DefaultApiAuthencatorImpl() {
    this.credentialStorage = new MemoryCredentialStorage();
  }
  
  public DefaultApiAuthencatorImpl(CredentialStorage credentialStorage) {

    this.credentialStorage = credentialStorage;
  }


  public void auth(ApiRequest apiRequest) {
    String appId = apiRequest.getAppId();
    String token = apiRequest.getToken();
    long timestamp = apiRequest.getTimestamp();
    String requestUuid = apiRequest.getRequestUuid();


    AuthToken clientAuthToken = new AuthToken(token, timestamp);
    if (clientAuthToken.isExpired()) {
      throw new RuntimeException("Token is expired.");
    }

    String password = credentialStorage.getPasswordByAppId(appId);
    AuthToken serverAuthToken = null;

    try {
      serverAuthToken = AuthToken.generate( appId, password, timestamp, requestUuid, apiRequest.getParameters());
      log.debug("server token {} :", serverAuthToken.getToken());

    } catch (NoSuchAlgorithmException e) {
      throw  new RuntimeException("SHA-256 does not exist", e);
    }
    if (!serverAuthToken.match(clientAuthToken)) {
      throw new RuntimeException("Token verfication failed.");
    }
  }
}