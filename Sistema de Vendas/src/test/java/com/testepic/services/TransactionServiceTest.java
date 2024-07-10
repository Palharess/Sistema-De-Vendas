package com.testepic.services;

import com.testepic.Entity.Cargo;
import com.testepic.Entity.Usuario;
import com.testepic.repositorios.TransactionRepository;
import org.h2.engine.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@DataJpaTest
@ActiveProfiles("test")
class TransactionServiceTest {

    @Mock
    private TransactionRepository repository;

    @Mock
    private UsuarioService usuarioService;

    @Autowired
    @InjectMocks
    private TransactionService transactionService;

    @BeforeEach
    void configuraMock() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Deve retornar true se a transação for criada com sucesso")
    void criaTransacaoSucess() throws Exception{
        Usuario sender = new Usuario(1L, "Carlos", "Silva", "12345678901", "joao@gmail.com", "senha", new BigDecimal(30), Cargo.USUARIO);
        Usuario receiver = new Usuario(2L, "Rebeca", "Silva", "12345678902", "rebeca@gmail.com", "senha", new BigDecimal(30), Cargo.USUARIO);
        when(usuarioService.findUsuarioById(1L)).thenReturn(sender);
        when(usuarioService.findUsuarioById(2L)).thenReturn(receiver);
        when(usuarioService.validarTransacao(any(), any())).thenReturn(true);
    }

    @Test
    @DisplayName("Deve lançar uma excessão se a transação não for criada com sucesso")
    void criaTransacaoFailure() {
    }
}