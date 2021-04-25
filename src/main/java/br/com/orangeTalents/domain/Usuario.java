package br.com.orangeTalents.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String cpf;
	private String nome;
	@OneToOne
	private Email email;
	private Date dataNascimento;
	@OneToMany(mappedBy = "usuario")
	private List<Endereco> endereco;

	public Usuario() {

	}

	public Usuario(String cpf, String nome, Email email, Date dataNascimento, List<Endereco> endereco) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

}
