/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.agro.dto;

/**
 *
 * @author jotavio
 */
public class FazendaDTO {
    String nome_faz, end_faz;
    int id_faz, tipoSolo_faz, id_ppt;
    double tamanho_faz;

    public String getNome_faz() {
        return nome_faz;
    }

    public void setNome_faz(String nome_faz) {
        this.nome_faz = nome_faz;
    }

    public String getEnd_faz() {
        return end_faz;
    }

    public void setEnd_faz(String end_faz) {
        this.end_faz = end_faz;
    }

    public int getId_faz() {
        return id_faz;
    }

    public void setId_faz(int id_faz) {
        this.id_faz = id_faz;
    }

    public int getTipoSolo_faz() {
        return tipoSolo_faz;
    }

    public void setTipoSolo_faz(int tipoSolo_faz) {
        this.tipoSolo_faz = tipoSolo_faz;
    }

    public int getId_ppt() {
        return id_ppt;
    }

    public void setId_ppt(int id_ppt) {
        this.id_ppt = id_ppt;
    }

    public double getTamanho_faz() {
        return tamanho_faz;
    }

    public void setTamanho_faz(double tamanho_faz) {
        this.tamanho_faz = tamanho_faz;
    }
}
