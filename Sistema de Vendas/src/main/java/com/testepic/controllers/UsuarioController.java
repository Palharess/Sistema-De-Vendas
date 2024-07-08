package com.testepic.controllers;

import com.testepic.DTO.UsuarioDTO;
import com.testepic.Entity.Usuario;
import com.testepic.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("")
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> criaUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.criaUsuario(usuarioDTO);
        return new ResponseEntity<>(usuario,HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<Usuario>> pegaUsuarios() {
        List<Usuario> usuarios = (List<Usuario>) usuarioService.pegaUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);

    }
}
