package com.testepic.DTO;

import com.testepic.Entity.Cargo;

import java.math.BigDecimal;

public record UsuarioDTO(String nome, String sobreNome, String cpf, String email, String senha, BigDecimal saldo, Cargo cargo) {
}
