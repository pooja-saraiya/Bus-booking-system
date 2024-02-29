package com.busbooking.booking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="passanger")
public class Passanger 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "passanger_id", nullable = false)
    private Long passangerId;
	
	@Column(name = "first_name", nullable = false, length= 15)
    private String firstName;
	
	@Column(name = "last_name", nullable = false, length= 15)
    private String lastName;
	
	@Column(name = "age", nullable = false)
    private Integer age;
	
	@Column(name = "gender", nullable = false, length= 15)
    private String gender;

	public Long getPassangerId() {
		return passangerId;
	}

	public void setPassangerId(Long passangerId) {
		this.passangerId = passangerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
