package com.testepic.services;

import com.testepic.DTO.UsuarioDTO;
import com.testepic.Entity.Cargo;
import com.testepic.Entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.testepic.repositorios.UsuarioRepository;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;


@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public void validarTransacao(Usuario sender, BigDecimal total) throws Exception  {
        if(sender.getCargo() == Cargo.VENDEDOR) {
            throw new Exception("Apenas usuarios podem realizar transações");
        }
        if(sender.getSaldo().compareTo(total) < 0) {
            throw new Exception("Saldo insuficiente");
        }
    }
    public Usuario findUsuarioById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }

    public Usuario criaUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO);
        this.saveUsuario(usuario);
        return usuario;
    }
    public Iterable<Usuario> pegaUsuarios() {
        return this.repository.findAll();
    }

    public void saveUsuario(Usuario usuario) {
        this.repository.save(usuario);
    }
}
