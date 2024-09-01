package com.sena.Ejercicio11.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.Ejercicio11.interfaceService.IusuarioService;
import com.sena.Ejercicio11.interfaces.Iusuario;
import com.sena.Ejercicio11.models.usuario;

@Service
public class usuarioService implements IusuarioService{
    
    @Autowired
    private Iusuario data;

    @Override
    public String save(usuario usuario) {
        data.save(usuario);
        return usuario.getIdUsuario();
    }

    @Override
    public List<usuario> findAll() {
        List<usuario> listausuario = (List<usuario>) data.findAll();
        return listausuario;
    }

    @Override
    public Optional<usuario> findOne(String id) {
        Optional<usuario> usuario = data.findById(id);
        return usuario;
    }

    @Override
    public int delete(String id_usuario) {
        try{
            data.deleteById(id_usuario);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    //Filtros

    @Override
    public List<usuario> filtroUsuario(String filtro) {
        List<usuario> listaUsuario = data.filtroUsuario(filtro);
        return listaUsuario;
    }

    @Override
    public List<usuario> actuacTipoDoc() {
        List<usuario> listaUsuario = data. actuacTipoDoc();
        return listaUsuario;
    }

    @Override
    public List<usuario> actuacContra(String actuacContra) {
        List<usuario> listaUsuario = data.actuacContra(actuacContra);
        return listaUsuario;
    }

    @Override
    public List<usuario> inicioSesiNoti(String inicioSesiNoti) {
        List<usuario> listaUsuario = data.inicioSesiNoti(inicioSesiNoti);
        return listaUsuario;
    }
}
