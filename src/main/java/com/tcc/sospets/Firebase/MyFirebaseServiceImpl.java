package com.tcc.sospets.Firebase;

import java.util.List;

public class MyFirebaseServiceImpl extends MyFirebaseService{

    @Override
    public boolean createUser(String email, String password) {
        FBRequest fbRequest = new FBRequest(email, password, true);
        try{
            this.restTemplate.postForEntity(this.singUpUrl, fbRequest, FBResponse.class);
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean login(String email, String password, List<String> tokens) {
        FBRequest fbRequest = new FBRequest(email, password, true);
        try {
            FBResponse fbResponse = this.restTemplate.postForEntity(this.singInUrl, fbRequest, FBResponse.class).getBody();
            tokens.add(fbResponse.getIdToken());
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
}
