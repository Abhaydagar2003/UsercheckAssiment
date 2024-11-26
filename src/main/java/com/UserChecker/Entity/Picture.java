package com.UserChecker.Entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public
class Picture {
    private String large;
    private String medium;
    private String thumbnail;
}