package com.tcc.sospets.controllers;


import com.tcc.sospets.business.models.dto.FBRequest;
import com.tcc.sospets.business.models.dto.TokenResponse;
import com.tcc.sospets.business.models.entities.User;
import com.tcc.sospets.business.models.entities.Usuario;
import com.tcc.sospets.business.repositories.IUserRepositorio;
import com.tcc.sospets.business.repositories.IUsuarioRepositorio;
import com.tcc.sospets.services.classes.JwtUserDetailsService;
import com.tcc.sospets.services.interfaces.IFirebaseService;
import com.tcc.sospets.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    IUsuarioRepositorio usuarioRepositorio;

    @PostMapping("/register")
    public void registraUsuarioFirebase(@RequestBody FBRequest fbRequest) throws Exception {
        firebaseService.register(fbRequest);
        String email = fbRequest.getEmail();
        String nome = fbRequest.getNome();
        User user = new User();
        user.setEmail(email);
        user.setNome(nome);
        Usuario usuario = new Usuario();
        usuario.setUser(userRepositorio.save(user));
        usuarioRepositorio.save(usuario);
    }
        @PostMapping("/login")
        public TokenResponse autenticaUsuarioFirebase(@RequestBody FBRequest fbRequest) throws Exception {
            firebaseService.login(fbRequest);
            UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(fbRequest.getEmail());
            String token = jwtTokenUtil.generateToken(userDetails);
            return new TokenResponse(token);
        }
}



