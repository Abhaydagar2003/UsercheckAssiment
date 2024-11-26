package com.UserChecker.Entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public
class Login {
	
    private String uuid;
    private String username;
    private String password;
    private String salt;
    private String md5;
    private String sha1;
    private String sha256;
}