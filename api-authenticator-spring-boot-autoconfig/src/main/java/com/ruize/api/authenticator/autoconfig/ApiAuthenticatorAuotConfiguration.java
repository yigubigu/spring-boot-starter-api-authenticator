package com.ruize.api.authenticator.autoconfig;

import com.ruize.api.authenticator.service.ApiAuthencator;
import com.ruize.api.authenticator.service.CredentialStorage;
import com.ruize.api.authenticator.service.impl.DefaultApiAuthencatorImpl;
import com.ruize.api.authenticator.service.impl.MemoryCredentialStorage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(ApiAuthencator.class)
public class ApiAuthenticatorAuotConfiguration {


    @Bean
    @ConditionalOnMissingBean
    public CredentialStorage getCredentialStorage() {
        return new MemoryCredentialStorage();
    }

    @Bean
    @ConditionalOnMissingBean
    public ApiAuthencator getAuthenticator(CredentialStorage credentialStorage) {
        return new DefaultApiAuthencatorImpl(credentialStorage);
    }
}
