package com.UserChecker.Entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public
class Coordinates {
    private String latitude;
    private String longitude;
}

