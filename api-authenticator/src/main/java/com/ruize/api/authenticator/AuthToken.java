package com.ruize.api.authenticator;

import com.ruize.api.authenticator.util.SHAUtil;
import jdk.nashorn.internal.runtime.regexp.joni.SearchAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
public class AuthToken {
    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 20 * 60 * 1000;
    private String token;
    private long createTime;
    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;
    public static final String SPLIT="&";

    public AuthToken(String token, long createTime, long expiredTimeInterval) {
       this(token,createTime);
        this.expiredTimeInterval = expiredTimeInterval;
    }

    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    public static AuthToken generate( String appId, String password, long timestamp, String requestUuid,
            Map<String, String[]> parameters) throws NoSuchAlgorithmException {

        String token = genToken(appId,password,timestamp, requestUuid, parameters);
        return new AuthToken(token,timestamp);
    }

    public static String genToken(String appId, String password, long timestamp, String requestUuid,
                                  Map<String, String[]> parameters) throws NoSuchAlgorithmException {
        StringBuffer sb = new StringBuffer();
        sb.append(appId).append(SPLIT);
        sb.append(password).append(SPLIT);
        sb.append(requestUuid).append(SPLIT);
        sb.append(timestamp).append(SPLIT);
        appendParameters(sb, parameters);
        String tokenString =  sb.toString().substring(0,sb.toString().length()-1);

        String token  = SHAUtil.SHA(tokenString);
        return token;
    }

    private static void appendParameters(StringBuffer sb, Map<String, String[]> parameters) {

        Set<String> parameterKey = parameters.keySet();
        String[] parameterKeyArr = parameterKey.toArray(new String[0]);
        Arrays.sort(parameterKeyArr);
        Arrays.stream(parameterKeyArr).forEach(x -> {
            if(parameters.get(x) !=null && parameters.get(x).length >0 ) {
                sb.append(parameters.get(x)[0]).append(SPLIT);
            }
        });
    }


    public boolean isExpired() {
        return System.currentTimeMillis()>(createTime+DEFAULT_EXPIRED_TIME_INTERVAL);
    }

    public boolean match(AuthToken clientAuthToken) {
        if (token.equals(clientAuthToken.token)){
            return true;
        }else {
            return false;
        }
    }

    public String getToken() {
        return token;
    }
}
