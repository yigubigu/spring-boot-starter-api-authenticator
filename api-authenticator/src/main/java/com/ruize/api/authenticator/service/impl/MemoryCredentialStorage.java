package com.ruize.api.authenticator.service.impl;

import com.ruize.api.authenticator.service.CredentialStorage;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 简化，内存存储id 和 password关系
 */
public class MemoryCredentialStorage implements CredentialStorage {
    Map<String,String> IdPasswordMap = new LinkedHashMap<String, String>();
    public MemoryCredentialStorage() {
        IdPasswordMap.put("id1","p1");
        IdPasswordMap.put("id2","p2");
        IdPasswordMap.put("id3","p3");
        IdPasswordMap.put("id4","p4");
    }


    public String getPasswordByAppId(String appId) {
        return IdPasswordMap.get(appId);
    }
}
