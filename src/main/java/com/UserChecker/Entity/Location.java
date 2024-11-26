package com.UserChecker.Entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public
class Location {
    @Embedded
    private Street street;
    private String city;
    private String state;
    private String country;
    private String postcode;

    @Embedded
    private Coordinates coordinates;
    @Embedded
    private Timezone timezone;
	@Override
	public String toString() {
		return "Location [street=" + street + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", postcode=" + postcode + ", coordinates=" + coordinates + ", timezone=" + timezone + "]";
	}
}
