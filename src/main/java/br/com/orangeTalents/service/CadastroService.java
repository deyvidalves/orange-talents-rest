package br.com.orangeTalents.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.orangeTalents.domain.Email;
import br.com.orangeTalents.domain.Endereco;
import br.com.orangeTalents.domain.Usuario;
import br.com.orangeTalents.dto.EmailDTO;
import br.com.orangeTalents.dto.EnderecoDTO;
import br.com.orangeTalents.dto.UsuarioDTO;
import br.com.orangeTalents.repositories.EmailRepository;
import br.com.orangeTalents.repositories.EnderecoRepository;
import br.com.orangeTalents.repositories.UsuarioRepository;
import br.com.orangeTalents.util.Constantes;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CadastroService {

	private UsuarioRepository usuarioRepo;
	private EmailRepository emailRepo;
	private EnderecoRepository enderecoRepo; 

	public void inserirUsuario(UsuarioDTO dto) throws Exception {
		
		validarDadosUsuario(dto);

		Email email = new Email(dto.getEmail().getEmail());
		Usuario usuario = new Usuario(dto.getCpf(),dto.getNome(), email, dto.getDataNascimento(), null);
		
		emailRepo.save(email);
		usuarioRepo.save(usuario);
		

	}


	public void inserirEndereco(EnderecoDTO dto) throws Exception {
		
		validarDadosEndereco(dto);
		
		Usuario usuario = usuarioRepo.findById(dto.getUsuario().getCpf()).get();
		
		Endereco endereco = new Endereco(dto.getLogradouro(), dto.getNumero(), dto.getComplemento(), dto.getBairro(), dto.getCidade(), dto.getEstado(), dto.getCep(), usuario);
				
		enderecoRepo.save(endereco);	
		
		
	}
	
	public UsuarioDTO obterUsusario(String cpf) {
		
		Optional<Usuario> usuario = usuarioRepo.findById(cpf);
		
		if(usuario.isEmpty()) {
			throw new RuntimeException(Constantes.USUARIO_NAO_ENCONTRADO);
		}
		
		
		UsuarioDTO usuDto = converterUsuario(usuario.get());
		
		return usuDto;
	}


	private void validarDadosUsuario(UsuarioDTO dto) {
		if(dto.getCpf() ==null) {
			throw new RuntimeException(Constantes.CPF_NAO_INFORMADO);
		}
		
		if(dto.getNome() ==null) {
			throw new RuntimeException(Constantes.NOME_NAO_INFORMADO);
		}
		
		if(dto.getEmail().getEmail() ==null) {
			throw new RuntimeException(Constantes.EMAIL_NAO_INFORMADO);
		}
		
		if(dto.getDataNascimento() ==null) {
			throw new RuntimeException(Constantes.DATA_NASCIMENTO_NAO_INFORMADO);
		}
	}

	private void validarDadosEndereco(EnderecoDTO dto) {
		if(dto.getUsuario().getCpf() ==null) {
			throw new RuntimeException(Constantes.USUARIO_NAO_INFORMADO);
		}
		
		if(dto.getLogradouro() ==null) {
			throw new RuntimeException(Constantes.LOGRADOURO_NAO_INFORMADO);
		}
		if(dto.getNumero() ==null) {
			throw new RuntimeException(Constantes.NUMERO_NAO_INFORMADO);
		}
		if(dto.getComplemento() ==null) {
			throw new RuntimeException(Constantes.COMPLEMENTO_NAO_INFORMADO);
		}
		if(dto.getBairro() ==null) {
			throw new RuntimeException(Constantes.BAIRRO_NAO_INFORMADO);
		}
		if(dto.getCidade() ==null) {
			throw new RuntimeException(Constantes.CIDADE_NAO_INFORMADO);
		}
		if(dto.getEstado() ==null) {
			throw new RuntimeException(Constantes.ESTADO_NAO_INFORMADO);
		}
		if(dto.getCep() ==null) {
			throw new RuntimeException(Constantes.CEP_NAO_INFORMADO);
		}
	}
	
	private UsuarioDTO converterUsuario(Usuario usuario) {
		List<EnderecoDTO> endereco = new ArrayList<EnderecoDTO>();
		EmailDTO email = new EmailDTO(usuario.getEmail().getEmail());
		for (Endereco end : usuario.getEndereco()) {
			EnderecoDTO enderecoDTO = new EnderecoDTO(end.getLogradouro(), end.getNumero(), end.getComplemento(), end.getBairro(), end.getCidade(), end.getEstado(), end.getCep(), null);
			EmailDTO emailDTO = new EmailDTO(email.getEmail());
			UsuarioDTO usuarioDTO = new UsuarioDTO(end.getUsuario().getCpf(), end.getUsuario().getCpf(), emailDTO , end.getUsuario().getDataNascimento(), null);
			enderecoDTO.setUsuario(usuarioDTO);
			endereco.add(enderecoDTO);
		}
		return new UsuarioDTO(usuario.getCpf(),usuario.getNome(), email ,usuario.getDataNascimento(), endereco);
	}


	
}
