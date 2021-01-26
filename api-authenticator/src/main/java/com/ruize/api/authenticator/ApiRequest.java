package com.ruize.api.authenticator;

import java.util.Map;

public class ApiRequest {

    private String appId;
    private String token;
    private String requestUuid;
    private long timestamp;
    private Map<String, String[]> parameters;

    public ApiRequest(String appId, String token, long timestamp, String requestUuid, Map<String, String[]> parameters) {
        this.appId = appId;
        this.token = token;
        this.timestamp = timestamp;
        this.requestUuid = requestUuid;
        this.parameters = parameters;
    }


    public String getAppId() {
        return appId;
    }

    public String getRequestUuid() {
        return requestUuid;
    }

    public String getToken() {
        return token;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public Map<String, String[]> getParameters() {
        return parameters;
    }

}
