/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entitys;

/**
 *
 * @author intercitydev
 */
public class Detalles implements java.io.Serializable {

    private String idUsuaro;
    private String telefono;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String ciudad;
    private String codigoPostal;
    private String email;
    private String notifiEmail;
    private String notifiFlag;
    private String lenguaje;
    private String accountId;
    private String saldo;
    
    
    
    public Detalles() {
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    
    
    
    public String getIdUsuaro() {
        return idUsuaro;
    }

    public void setIdUsuaro(String idUsuaro) {
        this.idUsuaro = idUsuaro;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotifiEmail() {
        return notifiEmail;
    }

    public void setNotifiEmail(String notifiEmail) {
        this.notifiEmail = notifiEmail;
    }

    public String getNotifiFlag() {
        return notifiFlag;
    }

    public void setNotifiFlag(String notifiFlag) {
        this.notifiFlag = notifiFlag;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }
    
    

}
