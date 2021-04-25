package br.com.orangeTalents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.orangeTalents.domain.Usuario;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, String>{

}
