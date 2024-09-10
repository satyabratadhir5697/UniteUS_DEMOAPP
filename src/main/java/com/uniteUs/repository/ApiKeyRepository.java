package com.uniteUs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uniteUs.Model.ApiKey;

public interface ApiKeyRepository extends JpaRepository<ApiKey, String> {
    ApiKey findByKey(String key);
}
