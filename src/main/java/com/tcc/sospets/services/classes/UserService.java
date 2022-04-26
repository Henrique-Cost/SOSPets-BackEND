package com.tcc.sospets.services.classes;

import com.tcc.sospets.business.repositories.IUserRepositorio;
import com.tcc.sospets.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepositorio userRepositorio;
}