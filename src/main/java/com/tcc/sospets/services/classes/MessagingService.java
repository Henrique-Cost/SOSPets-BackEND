package com.tcc.sospets.services.classes;

import com.tcc.sospets.business.models.entities.User;
import com.tcc.sospets.business.repositories.IUserRepositorio;
import com.tcc.sospets.services.interfaces.IMessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagingService implements IMessagingService {

    @Autowired
    IUserRepositorio userRepositorio;

    @Override
    public void registraFcmToken(User user, String fcmToken) {
        user.setFcmToken(fcmToken);
        userRepositorio.save(user);

    }
}
