package com.tcc.sospets.services;

import com.tcc.sospets.business.dto.FBAuthRequest;
import com.tcc.sospets.business.dto.FBAuthResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FirebaseService implements IFirebaseService {

    private String WEBKEY = "AIzaSyARgY_59EJG7sTVG1FbcheASa_8N3l8x2s";
    private String loginUrl = "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword" +
            "?key=" + WEBKEY;
    private String registerUrl = "https://identitytoolkit.googleapis.com/v1/accounts:signUp" +
            "?key=" + WEBKEY;

    @Override
    public void createUser(FBAuthRequest firebaseAuthRequest) throws Exception {

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<FBAuthRequest> httpEntity = new HttpEntity<>(firebaseAuthRequest);
        System.out.println(registerUrl);
        ResponseEntity<FBAuthRequest> response =
                restTemplate.exchange(registerUrl, HttpMethod.POST, httpEntity, FBAuthRequest.class);

        if (response.getStatusCodeValue() != 200) {
            throw new Exception("Nao pode registrar");
        }
        System.out.println(response.getBody());
    }

    @Override
    public void login(FBAuthRequest firebaseAuthRequest) throws Exception {

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<FBAuthRequest> httpEntity = new HttpEntity<>(firebaseAuthRequest);
        ResponseEntity<FBAuthResponse> response =
                restTemplate.exchange(loginUrl, HttpMethod.POST, httpEntity, FBAuthResponse.class);
        if (response.getStatusCodeValue() != 200) {
            throw new Exception("Nao pode logar");
        }
        System.out.println(response.getBody());
        UsernamePasswordAuthenticationToken t = new UsernamePasswordAuthenticationToken(response.getBody().getEmail(), response.getBody().getIdToken());
        SecurityContextHolder.getContext().setAuthentication(t);
    }
}