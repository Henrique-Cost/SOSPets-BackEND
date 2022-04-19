package com.tcc.sospets.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FBAuthRequest {

    private String email;
    private String password;
    private boolean returnSecureToken;


}
