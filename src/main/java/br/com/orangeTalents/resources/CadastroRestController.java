package br.com.orangeTalents.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangeTalents.dto.EnderecoDTO;
import br.com.orangeTalents.dto.UsuarioDTO;
import br.com.orangeTalents.service.CadastroService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(value = "/cadastro")
public class CadastroRestController {

	@Autowired
	private CadastroService service;

	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public ResponseEntity<?> cadastroUsuario(@RequestBody UsuarioDTO usuario) {

		try {
			service.inserirUsuario(usuario);

			return ResponseEntity.status(HttpStatus.CREATED).build();

		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/endereco", method = RequestMethod.POST)
	public ResponseEntity<?> cadastroEndereco(@RequestBody EnderecoDTO endereco) {

		try {
			service.inserirEndereco(endereco);

			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/usuario/{cpf}", method = RequestMethod.GET)
	public ResponseEntity<?> obterUsusario(@PathVariable String cpf) {

		try {
			UsuarioDTO usuario = service.obterUsusario(cpf);

			return ResponseEntity.ok().body(usuario);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}
	}

}