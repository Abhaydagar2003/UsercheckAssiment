package com.UserChecker.Entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Embedded
    @Column(name = "id")
    private JsoId jsoId;

    private String gender;

    @Embedded
    private Name name;

    @Embedded
    private Location location;

    private String email;

    @Embedded
    private Login login;

    @Embedded
    private DateOfBirth dob;

    @Embedded
    private Registration registered;

    private String phone;
    private String cell;

    @Embedded
    private Picture picture;

    private String nat;
    
    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(gender, user.gender) &&
               Objects.equals(name, user.name) &&
               Objects.equals(location, user.location) &&
               Objects.equals(email, user.email) &&
               Objects.equals(phone, user.phone) &&
               Objects.equals(cell, user.cell) &&
               Objects.equals(nat, user.nat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, name, location, email, phone, cell, nat);
    }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", jsoId=" + jsoId + ", gender=" + gender + ", name=" + name + ", location="
				+ location + ", email=" + email + ", login=" + login + ", dob=" + dob + ", registered=" + registered
				+ ", phone=" + phone + ", cell=" + cell + ", picture=" + picture + ", nat=" + nat + "]";
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public JsoId getJsoId() {
		return jsoId;
	}

	public void setJsoId(JsoId jsoId) {
		this.jsoId = jsoId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public DateOfBirth getDob() {
		return dob;
	}

	public void setDob(DateOfBirth dob) {
		this.dob = dob;
	}

	public Registration getRegistered() {
		return registered;
	}

	public void setRegistered(Registration registered) {
		this.registered = registered;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public String getNat() {
		return nat;
	}

	public void setNat(String nat) {
		this.nat = nat;
	}

	public User(Long userId, JsoId jsoId, String gender, Name name, Location location, String email, Login login,
			DateOfBirth dob, Registration registered, String phone, String cell, Picture picture, String nat) {
		super();
		this.userId = userId;
		this.jsoId = jsoId;
		this.gender = gender;
		this.name = name;
		this.location = location;
		this.email = email;
		this.login = login;
		this.dob = dob;
		this.registered = registered;
		this.phone = phone;
		this.cell = cell;
		this.picture = picture;
		this.nat = nat;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
    
    
}

