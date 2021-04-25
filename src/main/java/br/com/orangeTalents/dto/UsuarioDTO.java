package br.com.orangeTalents.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.orangeTalents.domain.Email;

public class UsuarioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cpf;
	private String nome;
	private EmailDTO email;
	private Date dataNascimento;
	private List<EnderecoDTO> endereco;

	public UsuarioDTO() {
	}

	public UsuarioDTO(String cpf, String nome, EmailDTO email, Date dataNascimento, List<EnderecoDTO> endereco) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.setEndereco(endereco);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public EmailDTO getEmail() {
		return email;
	}

	public void setEmail(EmailDTO email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<EnderecoDTO> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<EnderecoDTO> endereco) {
		this.endereco = endereco;
	}

}
