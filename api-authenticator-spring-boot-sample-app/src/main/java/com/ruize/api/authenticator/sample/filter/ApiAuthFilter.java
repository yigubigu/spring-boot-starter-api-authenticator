package com.ruize.api.authenticator.sample.filter;

import com.ruize.api.authenticator.ApiRequest;
import com.ruize.api.authenticator.service.ApiAuthencator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Slf4j
public class ApiAuthFilter implements Filter {
    @Autowired
    private ApiAuthencator apiAuthencator;
    private static final String APP_ID = "appId";
    private static final String REQUEST_UUID = "requestUuid";
    private static final String TIMESTAMP = "timestamp";
    private static final String TOKEN = "token";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        httpServletRequest.getRequestURL();

        try {
            long timestamp = Long.parseLong(httpServletRequest.getHeader(TIMESTAMP));
            String appId = httpServletRequest.getHeader(APP_ID);
            String requestId = httpServletRequest.getHeader(REQUEST_UUID);
            String token = httpServletRequest.getHeader(TOKEN);
            ApiRequest apiRequest = new ApiRequest(appId, token, timestamp, requestId, httpServletRequest.getParameterMap());

            apiAuthencator.auth(apiRequest);
        } catch (NumberFormatException nex) {
            log.error("missing timestap or timestamp is not a valid long, timestamp in request head is {}", httpServletRequest.getHeader(TIMESTAMP));
            throw nex;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
