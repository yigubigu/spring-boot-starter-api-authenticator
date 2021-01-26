package com.ruize.api.authenticator.service;

public interface CredentialStorage {
    String getPasswordByAppId(String appId);
}
