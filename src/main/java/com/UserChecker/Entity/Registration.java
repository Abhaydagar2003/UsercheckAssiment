package com.UserChecker.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public
class Registration {
    private String date;
    @Column(name = "registration_age")
    private int age;
}
