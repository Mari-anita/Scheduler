package com.sena.Ejercicio11.interfaces;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sena.Ejercicio11.models.usuario;

@Repository
public interface Iusuario extends CrudRepository<usuario, String>{
    
    @Query ("SELECT u FROM usuario u WHERE u.nombreCompl LIKE %?1% OR u.correo LIKE %?1% OR u.doc LIKE %?1%")
    List<usuario> filtroUsuario(String filtro);

    @Query ("SELECT u FROM usuario u WHERE TIMESTAMPDIFF(YEAR, u.fechaNac, NOW())>=18 AND tipoDoc = 'TI'")
    List<usuario> actuacTipoDoc();

    @Query("SELECT u FROM usuario u WHERE  DATEDIFF(NOW(), u.fechaActContra) >= 90")
    List<usuario> actuacContra(String actuacContra);

    @Query("SELECT u FROM usuario u WHERE  DATEDIFF(NOW(), u.fechaUltmIniciSesio) >= 30")
    List<usuario> inicioSesiNoti(String inicioSesiNoti);
}
