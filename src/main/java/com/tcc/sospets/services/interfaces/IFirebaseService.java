package com.tcc.sospets.services.interfaces;


import com.tcc.sospets.business.models.dto.FBRequest;
import org.springframework.security.core.Authentication;


public interface IFirebaseService {

    void register(FBRequest fbRequest) throws Exception;
    void login(FBRequest fbRequest) throws Exception;
    void logout(Authentication authentication) throws Exception;


}