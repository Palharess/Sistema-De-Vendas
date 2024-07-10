package com.testepic.repositorios;

import com.testepic.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findUsuarioByCpf(String cpf);
    Optional<Usuario> findUsuarioById(Long id);
}
