package com.scaler.firstspringapi.configs.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.scaler.firstspringapi.dtos.UserDto;

@Component
public class AuthCommon {
    private RestTemplate restTemplate;

    @Autowired
    AuthCommon(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDto validateToken(String token) {
        String url="http://localhost:8080/users/validate/{token}";
        ResponseEntity<UserDto> response = restTemplate.postForEntity(url, null, UserDto.class, token);
        if (response.getBody() == null) {
            return null;
        }
        return response.getBody();
        
    }


}
