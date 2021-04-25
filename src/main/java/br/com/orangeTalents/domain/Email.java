package br.com.orangeTalents.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Email implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	public Email() {

	}

	public Email(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
