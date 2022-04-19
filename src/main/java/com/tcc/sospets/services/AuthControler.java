package com.tcc.sospets.services;

import com.tcc.sospets.business.dto.FBAuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthControler {

    @Autowired
    IFirebaseService firebaseService;

    @PostMapping("/register")
    public void registraUsuarioFirebase(@RequestBody FBAuthRequest firebaseAuthRequest) throws Exception {
        firebaseService.createUser(firebaseAuthRequest);
    }

    @PostMapping("/login")
    public void autenticaUsuarioFirebase(@RequestBody FBAuthRequest firebaseAuthRequest) throws Exception {
        firebaseService.login(firebaseAuthRequest);
    }


    @PostMapping("/logout")
    public void logout(String token, List<String> tokens) {
        tokens.remove(token);
    }
}
