package com.uniteUs.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.uniteUs.service.ApiKeyService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class ApiKeyInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(HandlerInterceptor.class);

    private final ApiKeyService apiKeyService;

    public ApiKeyInterceptor(ApiKeyService apiKeyService) {
        this.apiKeyService = apiKeyService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String apiKey = request.getHeader("API-Key");
        

        if (apiKey == null || !apiKeyService.validateApiKey(apiKey)) {
        	
        	logger.info("Api key is not correct called from TLRD "+apiKey);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        logger.info("Api key is same with DB:"+apiKey);
        return true;
    }
}
