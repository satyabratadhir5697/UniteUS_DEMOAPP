
package com.uniteUs.Config;
import java.util.UUID;

public class ApiKeyGenerator {
    public String generateApiKey() {
        return UUID.randomUUID().toString();
    }
}

