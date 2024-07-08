package com.testepic.Entity;

import com.testepic.DTO.UsuarioDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "usuarios")
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobreNome;
    @Column(unique = true)
    private String cpf;
    @Column(unique = true)
    private String email;
    private String senha;
    private BigDecimal saldo;
    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String sobreNome, String cpf, String email, String senha, BigDecimal saldo, Cargo cargo) {
        this.id = id;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.saldo = saldo;
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Usuario(UsuarioDTO data){
        this.nome = data.nome();
        this.sobreNome = data.sobreNome();
        this.cpf = data.cpf();
        this.email = data.email();
        this.senha = data.senha();
        this.saldo = data.saldo();
        this.cargo = data.cargo();
    }
}
