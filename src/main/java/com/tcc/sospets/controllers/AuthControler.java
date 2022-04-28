package com.tcc.sospets.controllers;


import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.tcc.sospets.business.models.dto.FBRequest;
import com.tcc.sospets.business.models.dto.GoogleAuthRequest;
import com.tcc.sospets.business.models.dto.TokenResponse;
import com.tcc.sospets.business.models.entities.User;
import com.tcc.sospets.business.repositories.IUserRepositorio;
import com.tcc.sospets.services.classes.JwtUserDetailsService;
import com.tcc.sospets.services.interfaces.IFirebaseService;
import com.tcc.sospets.utils.JwtTokenUtil;
import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthControler {
    @Autowired
    IFirebaseService firebaseService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    IUserRepositorio userRepositorio;

    @PostMapping("/register")
    public void registraUsuarioFirebase(@RequestBody FBRequest fbRequest) throws Exception {

        firebaseService.register(fbRequest);
        String email = fbRequest.getEmail();
        User user = new User();
        user.setEmail(email);
        userRepositorio.save(user);
    }
        @PostMapping("/login")
        public TokenResponse autenticaUsuarioFirebase(@RequestBody FBRequest fbRequest) throws Exception {
            firebaseService.login(fbRequest);
            UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(fbRequest.getEmail());
            String token = jwtTokenUtil.generateToken(userDetails);
            return new TokenResponse(token);

        }

        @PostMapping("/loginWithGoogle")
        public TokenResponse autenticaUsuariocomGoogle(@RequestBody GoogleAuthRequest googleAuthRequest) throws Exception {
            HttpTransport httpTransport = new NetHttpTransport();
            JsonFactory jsonFactory = new GsonFactory();
            String clientId = "182449133691-9jihapbpjtec5tqfkirakua2vqs3r1vb.apps.googleusercontent.com";

            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(httpTransport, jsonFactory)
                    .setAudience(Collections.singletonList(clientId))
                    .build();
            GoogleIdToken idToken = verifier.verify(googleAuthRequest.getGoogleToken());
            if (idToken != null) {
                GoogleIdToken.Payload payload = idToken.getPayload();

                String userId = payload.getSubject();
                System.out.println("User ID: " + userId);

                String email = payload.getEmail();
                String name = (String) payload.get("name");
                String pictureUrl = (String) payload.get("picture");

                UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(email);
                String token = jwtTokenUtil.generateToken(userDetails);
                return new TokenResponse(token);
            }

            throw new HttpException();
        }

            @PostMapping("/logout")
            public void logout (String token, List < String > tokens){
                tokens.remove(token);
            }
        }



