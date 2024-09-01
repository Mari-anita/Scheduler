package com.sena.Ejercicio11.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sena.Ejercicio11.models.usuario;
import com.sena.Ejercicio11.service.emailService;
import com.sena.Ejercicio11.service.usuarioService;

@Component
public class task {

    @Autowired
    private usuarioService data;

    @Autowired
    private emailService email;

    @Scheduled(fixedRate = 1000)
    public void sendNotificacioncron() {
        var listaUsuario=data.actuacTipoDoc();
        for (usuario usuario : listaUsuario) {
            System.out.println("El usuario que requiere actualizar el tipo de documento es: "+
            usuario.getNombreCompl());
            email.actuacTipoDoc(usuario);
        }
    }
    
}
