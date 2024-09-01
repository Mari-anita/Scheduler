package com.sena.Ejercicio11.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "usuario")
public class usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "idUsuario", nullable = false, length = 36)
    private String idUsuario;

    @Column(name = "nombreCompl", nullable = false, length = 50)
    private String nombreCompl;

    @Column(name = "tipoDoc", nullable = false, length = 3)
    private String tipoDoc;

    @Column(name = "doc", nullable = false, length = 11)
    private String doc;

    @Column(name = "fechaNac", nullable = false, length = 36)
    private Date fechaNac;

    @Column(name = "contra", nullable = false, length = 25)
    private String contra;

    @Column(name = "fechaActContra", nullable = false, length = 36)
    private Date fechaActContra;

    @Column(name = "fechaUltmIniciSesio", nullable = false, length = 36)
    private Date fechaUltmIniciSesio;

    @Column(name = "correo", nullable = false, length = 100)
    private String correo;

    @Column(name = "campoNotifi", nullable = false, length = 2)
    private boolean campoNotifi;

    public usuario() {
    }

    public usuario(String idUsuario, String nombreCompl, String tipoDoc, String doc, Date fechaNac, String contra,
            Date fechaActContra, Date fechaUltmIniciSesio, String correo, boolean campoNotifi) {
        this.idUsuario = idUsuario;
        this.nombreCompl = nombreCompl;
        this.tipoDoc = tipoDoc;
        this.doc = doc;
        this.fechaNac = fechaNac;
        this.contra = contra;
        this.fechaActContra = fechaActContra;
        this.fechaUltmIniciSesio = fechaUltmIniciSesio;
        this.correo = correo;
        this.campoNotifi = campoNotifi;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreCompl() {
        return nombreCompl;
    }

    public void setNombreCompl(String nombreCompl) {
        this.nombreCompl = nombreCompl;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public Date getFechaActContra() {
        return fechaActContra;
    }

    public void setFechaActContra(Date fechaActContra) {
        this.fechaActContra = fechaActContra;
    }

    public Date getFechaUltmIniciSesio() {
        return fechaUltmIniciSesio;
    }

    public void setFechaUltmIniciSesio(Date fechaUltmIniciSesio) {
        this.fechaUltmIniciSesio = fechaUltmIniciSesio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isCampoNotifi() {
        return campoNotifi;
    }

    public void setCampoNotifi(boolean campoNotifi) {
        this.campoNotifi = campoNotifi;
    }
    
}
