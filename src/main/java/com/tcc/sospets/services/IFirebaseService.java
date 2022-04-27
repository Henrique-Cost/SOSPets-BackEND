package com.tcc.sospets.services;

import com.tcc.sospets.business.dto.FBAuthRequest;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public interface IFirebaseService {

    void createUser(FBAuthRequest firebaseAuthRequest) throws Exception;
    void  login(FBAuthRequest firebaseAuthRequest) throws Exception;

}