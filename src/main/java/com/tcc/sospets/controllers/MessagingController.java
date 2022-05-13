package com.tcc.sospets.controllers;

import com.tcc.sospets.business.models.dto.FcmRequest;
import com.tcc.sospets.business.models.entities.User;
import com.tcc.sospets.services.classes.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messaging")
public class MessagingController {

    @Autowired
    MessagingService messagingService;

    @PostMapping("/register")
    public void registraFcmToken(@RequestBody FcmRequest fcmRequest, Authentication authentication){
        User user = (User) authentication.getPrincipal();
        String fcmToken = fcmRequest.getToken();
        messagingService.registraFcmToken(user, fcmToken);
    }

}