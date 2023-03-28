package iei.al.lab.university.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher {
	
	@EmbeddedId
	private TeacherId id;

	public Date getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}

	public TeacherId getId() {
		return id;
	}

	public void setId(TeacherId id) {
		this.id = id;
	}

	@Column(name = "code")
	private String code;
	
	@Column(name = "registration_date")
	private Date registration_date;

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
	 * @return the registartion_date
	 */
	public Date getRegistartion_date() {
		return registration_date;
	}

	/**
	 * @param registartion_date the registartion_date to set
	 */
	public void setRegistartion_date(Date registartion_date) {
		this.registration_date = registartion_date;
	}

	

}
