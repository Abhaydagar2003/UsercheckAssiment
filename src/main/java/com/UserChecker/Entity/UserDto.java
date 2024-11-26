package com.UserChecker.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	  @Override
		public String toString() {
			return "User [id=" + id + ", gender=" + gender + ", name=" + name + ", location=" + location + ", email="
					+ email + ", login=" + login + ", dob=" + dob + ", registered=" + registered + ", phone=" + phone
					+ ", cell=" + cell + ", picture=" + picture + ", nat=" + nat + "]";
		}

	    private JsoId id;

	    private String gender;

	    private Name name;

	    private Location location;

	    private String email;

	    private Login login;

	    private DateOfBirth dob;

	    private Registration registered;

	    private String phone;
	    private String cell;

	    private Picture picture;

	    private String nat;
}
