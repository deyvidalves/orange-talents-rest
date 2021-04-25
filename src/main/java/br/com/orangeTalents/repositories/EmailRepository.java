package br.com.orangeTalents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.orangeTalents.domain.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, String>{

}
