package com.sena.Ejercicio11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.Ejercicio11.interfaceService.IusuarioService;
import com.sena.Ejercicio11.models.usuario;
import com.sena.Ejercicio11.service.emailService;

@RequestMapping("api/v1/usuario")
@RestController
public class usuarioController {

    @Autowired
    private IusuarioService usuarioService;

    // @Autowired
    // private JavaMailSender javaMailSender;

    @Autowired
    private emailService emailService;

    @PostMapping("/")
    public ResponseEntity<Object> save(@ModelAttribute("usuario") usuario usuario){
        usuarioService.save(usuario);
        emailService.enviarCorreoBienvenida(usuario.getCorreo());
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> findAll() {
        var listausuario = usuarioService.findAll();
        return new ResponseEntity<>(listausuario, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable String id) {
        var usuario = usuarioService.findOne(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @DeleteMapping("/{id_usuario}")
    public ResponseEntity<Object> delete(@PathVariable String id_usuario) {
        usuarioService.delete(id_usuario);
        return new ResponseEntity<>("Registro eliminado permanentemente", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @ModelAttribute("usuario") usuario usuarioUpdate) {
        var usuario = usuarioService.findOne(id).get();
        if (usuario != null) {
            usuario.setNombreCompl(usuarioUpdate.getNombreCompl());
            usuario.setTipoDoc(usuarioUpdate.getTipoDoc());
            usuario.setDoc(usuarioUpdate.getDoc());
            usuario.setFechaNac(usuarioUpdate.getFechaNac());
            usuario.setContra(usuarioUpdate.getContra());
            usuario.setFechaActContra(usuarioUpdate.getFechaActContra());
            usuario.setFechaUltmIniciSesio(usuarioUpdate.getFechaUltmIniciSesio());
            usuario.setCorreo(usuarioUpdate.getCorreo());
            usuario.setCampoNotifi(usuarioUpdate.isCampoNotifi());

            usuarioService.save(usuario);
            return new ResponseEntity<>(usuario, HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Error usuario NO Encontrado", HttpStatus.BAD_REQUEST);
        }
    }
}
