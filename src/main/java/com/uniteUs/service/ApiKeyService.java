package com.uniteUs.service;

import org.springframework.stereotype.Service;

import com.uniteUs.Config.ApiKeyGenerator;
import com.uniteUs.Model.ApiKey;
import com.uniteUs.repository.ApiKeyRepository;

@Service
public class ApiKeyService {
    private final ApiKeyRepository apiKeyRepository;

    public ApiKeyService(ApiKeyRepository apiKeyRepository) {
        this.apiKeyRepository = apiKeyRepository;
    }

    public String createApiKey(String clientName) {
        String apiKey = new ApiKeyGenerator().generateApiKey();
        apiKeyRepository.save(new ApiKey(apiKey, clientName));
        return apiKey;
    }

    public boolean validateApiKey(String apiKey) {
        return apiKeyRepository.findByKey(apiKey) != null;
    }
}

