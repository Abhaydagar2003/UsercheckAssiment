package com.UserChecker.Entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public
class Timezone {
    private String offset;
    private String description;
}
