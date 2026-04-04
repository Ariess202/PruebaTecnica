package com.balabarca.pruebatecnica.controller;

import com.balabarca.pruebatecnica.dto.LoginRequest;
import com.balabarca.pruebatecnica.model.Usuario;
import com.balabarca.pruebatecnica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")

public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @PostMapping("/registro")
    public Usuario registrarUsuario(@RequestBody Usuario usuario){
        String pass = encoder.encode(usuario.getPassword());
        usuario.setPassword(pass);
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable long id, @RequestBody Usuario usuario){
        return usuarioRepository.findById(id).
                map(usuarioExistente ->{
                    usuarioExistente.setNombres(usuario.getNombres());
                    usuarioExistente.setApellidos(usuario.getApellidos());
                    usuarioExistente.setCargo(usuario.getCargo());
                    usuarioExistente.setTelefono(usuario.getTelefono());
                    usuarioExistente.setFoto_url(usuario.getFoto_url());
                    Usuario usuarioActualizar = usuarioRepository.save(usuarioExistente);
                    return ResponseEntity.ok(usuarioActualizar);
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginData) {
        return usuarioRepository.findByEmail(loginData.email())
                .map(usuario -> {
                    if (encoder.matches(loginData.password(), usuario.getPassword())) {
                        return ResponseEntity.ok(usuario);
                    } else {
                        return ResponseEntity.status(401).body("Contraseña incorrecta");
                    }
                })
                .orElse(ResponseEntity.status(404).body("Usuario no encontrado"));
    }
}
