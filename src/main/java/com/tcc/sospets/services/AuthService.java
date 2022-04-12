package com.tcc.sospets.services;

import com.tcc.sospets.Firebase.MyFirebaseServiceImpl;

import java.util.List;

public class AuthService implements IAuthService{

    MyFirebaseServiceImpl firebase = new MyFirebaseServiceImpl();
    @Override
    public boolean createUser(String email, String password) {
        return firebase.createUser(email, password);
    }

    @Override
    public boolean login(String email, String password, List<String> tokens) {
        return firebase.login(email, password, tokens);
    }

    @Override
    public void logout(String token, List<String> tokens) {
        tokens.remove(token);
    }
}
