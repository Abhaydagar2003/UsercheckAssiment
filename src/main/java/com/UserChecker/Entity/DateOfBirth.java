package com.UserChecker.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public
class DateOfBirth {
	
	@Column(name = "date_of_Birth")
    private String date;
    private int age;

}