/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsonEntitys;

/**
 *
 * @author jorge
 */
public class Llamadas {

    public Llamadas() {
    }

    private int no;
    private String inicioLLamada;
    private String Numero;
    private String pais_operador;
    private String duracionSegundos;
    private long duracionMinutos;
    private String costoTotal;
    private String costoMinuto;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getInicioLLamada() {
        return inicioLLamada;
    }

    public void setInicioLLamada(String inicioLLamada) {
        this.inicioLLamada = inicioLLamada;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getPais_operador() {
        return pais_operador;
    }

    public void setPais_operador(String pais_operador) {
        this.pais_operador = pais_operador;
    }

    public String getDuracionSegundos() {
        return duracionSegundos;
    }

    public void setDuracionSegundos(String duracionSegundos) {
        this.duracionSegundos = duracionSegundos;
    }

    public long getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(long duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public String getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(String costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getCostoMinuto() {
        return costoMinuto;
    }

    public void setCostoMinuto(String costoMinuto) {
        this.costoMinuto = costoMinuto;
    }

   

}
