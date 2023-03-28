package iei.al.lab.university.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@EmbeddedId
	private StudentId id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "registration_date")
	private Date registration_date;
	
	@Column(name = "code")
	private String code;
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the registration_date
	 */
	public Date getRegistration_date() {
		return registration_date;
	}

	/**
	 * @param registration_date the registration_date to set
	 */
	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}

	public StudentId getId() {
		return id;
	}

	public void setId(StudentId id) {
		this.id = id;
	}

}
