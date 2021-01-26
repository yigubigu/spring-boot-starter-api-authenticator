package com.ruize.api.authenticator.service;

import com.ruize.api.authenticator.ApiRequest;

public interface ApiAuthencator {
    void auth(ApiRequest apiRequest);
}