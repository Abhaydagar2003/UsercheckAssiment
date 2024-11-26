package com.UserChecker.Entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public
class Name {
    private String title;
    private String first;
    private String last;
}
