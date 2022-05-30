package com.tcc.sospets.business.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FBRequest {

    private String email;
    private String nome;
    private String password;
    private boolean returnSecureToken;

}
