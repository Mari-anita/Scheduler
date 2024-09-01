package com.sena.Ejercicio11.interfaceService;

import java.util.List;
import java.util.Optional;

import com.sena.Ejercicio11.models.usuario;

public interface IusuarioService {

    public String save (usuario usuario);

    public List<usuario> findAll();

    public Optional<usuario> findOne(String id);

    public int delete(String id_usuario);

    public List<usuario> filtroUsuario(String filtro);
    public List<usuario> actuacTipoDoc();
    public List<usuario> actuacContra(String actuacContra);
    public List<usuario> inicioSesiNoti(String inicioSesiNoti);
}
