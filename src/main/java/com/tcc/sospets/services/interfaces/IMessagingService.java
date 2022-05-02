package com.tcc.sospets.services.interfaces;

import com.tcc.sospets.business.models.entities.User;

public interface IMessagingService {

    void registraFcmToken(User user, String fcmToken);
}
