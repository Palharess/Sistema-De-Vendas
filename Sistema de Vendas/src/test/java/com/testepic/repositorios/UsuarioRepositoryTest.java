package com.testepic.repositorios;

import com.testepic.DTO.UsuarioDTO;
import com.testepic.Entity.Cargo;
import com.testepic.Entity.Usuario;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@ActiveProfiles("test")
class UsuarioRepositoryTest {
    @Autowired
    EntityManager entityManager;

    @Autowired
    UsuarioRepository usuarioRepository;


    @Test
    @DisplayName("Deve retornar verdadeiro quando existir um usuario na base com o cpf informado")
    void findUsuarioByCpfSucess() {
        String cpf = "12345678901";
        UsuarioDTO data = new UsuarioDTO("Gabriel", "Palhares", cpf, "gabriel@gmail.com", "123456", new BigDecimal(30), Cargo.USUARIO);
        this.criarUsuario(data);
        Optional<Usuario> usuarioEncontrado = this.usuarioRepository.findUsuarioByCpf(cpf);

        assertThat(usuarioEncontrado.isPresent()).isTrue();

    }
    @Test
    @DisplayName("Deve retornar falso quando nao existir um usuario na base com o cpf informado")
    void findUsuarioByCpfFailure() {
        String cpf = "12345678901";
        Optional<Usuario> usuarioEncontrado = this.usuarioRepository.findUsuarioByCpf(cpf);

        assertThat(usuarioEncontrado.isEmpty()).isTrue();

    }

    private Usuario criarUsuario(UsuarioDTO data) {
        Usuario usuario = new Usuario(data);
        this.entityManager.persist(usuario);
        return usuario;

    }

}