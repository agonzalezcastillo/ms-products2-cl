package com.bct.msproducts2cl.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtUser {

    private String userName;
    private Long userId;
    private String role;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(Long userId) {
        this.userId = userId;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
