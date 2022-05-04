package com.tcc.sospets.services.classes;


import com.tcc.sospets.business.models.dto.FBRequest;
import com.tcc.sospets.business.models.dto.FBResponse;
import com.tcc.sospets.services.interfaces.IFirebaseService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FirebaseService implements IFirebaseService {

    private String WEBKEY = "AIzaSyB5Km3RdN-pIIID72SEr3xOC7E_3CeuhJg";
    private String loginUrl = "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword" +
            "?key=" + WEBKEY;
    private String registerUrl = "https://identitytoolkit.googleapis.com/v1/accounts:signUp" +
            "?key=" + WEBKEY;

    @Override
    public void register(FBRequest firebaseAuthRequest) throws Exception {

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<FBRequest> httpEntity = new HttpEntity<>(firebaseAuthRequest);
        System.out.println(registerUrl);
        ResponseEntity<FBRequest> response =
                restTemplate.exchange(registerUrl, HttpMethod.POST, httpEntity, FBRequest.class);

        if (response.getStatusCodeValue() != 200) {
            throw new Exception("Nao pode registrar");
        }
        System.out.println(response.getBody());
    }

    @Override
    public void login(FBRequest firebaseAuthRequest) throws Exception {

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<FBRequest> httpEntity = new HttpEntity<>(firebaseAuthRequest);
        ResponseEntity<FBResponse> response =
                restTemplate.exchange(loginUrl, HttpMethod.POST, httpEntity, FBResponse.class);
        if (response.getStatusCodeValue() != 200) {
            throw new Exception("Nao pode logar");
        }

        System.out.println(response.getBody());
        UsernamePasswordAuthenticationToken t = new UsernamePasswordAuthenticationToken(response.getBody().getEmail(), response.getBody().getIdToken());
        SecurityContextHolder.getContext().setAuthentication(t);
    }
}