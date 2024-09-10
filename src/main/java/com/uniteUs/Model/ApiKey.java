package com.uniteUs.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiKey {
    @Id
    private String key;
    private String clientName;

    
    public ApiKey() {
    }
    
    public ApiKey(String key, String clientName) {
        this.key = key;
        this.clientName = clientName;
    }

	

    // getters and setters
}
