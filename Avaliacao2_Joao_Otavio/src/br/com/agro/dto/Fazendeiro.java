/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agro.dto;

import java.util.Date;

/**
 *
 * @author jotav
 */
public class Fazendeiro {
    private int id_fazendeiro, telefone_fazendeiro;
    private Date dtaNasc_fazendeiro;
    private String nome_fazendeiro, cnpj_fazendeiro;

    public int getId_fazendeiro() {
        return id_fazendeiro;
    }

    public void setId_fazendeiro(int id_fazendeiro) {
        this.id_fazendeiro = id_fazendeiro;
    }

    public int getTelefone_fazendeiro() {
        return telefone_fazendeiro;
    }

    public void setTelefone_fazendeiro(int telefone_fazendeiro) {
        this.telefone_fazendeiro = telefone_fazendeiro;
    }

    public Date getDtaNasc_fazendeiro() {
        return dtaNasc_fazendeiro;
    }

    public void setDtaNasc_fazendeiro(Date dtaNasc_fazendeiro) {
        this.dtaNasc_fazendeiro = dtaNasc_fazendeiro;
    }

    public String getNome_fazendeiro() {
        return nome_fazendeiro;
    }

    public void setNome_fazendeiro(String nome_fazendeiro) {
        this.nome_fazendeiro = nome_fazendeiro;
    }

    public String getCnpj_fazendeiro() {
        return cnpj_fazendeiro;
    }

    public void setCnpj_fazendeiro(String cnpj_fazendeiro) {
        this.cnpj_fazendeiro = cnpj_fazendeiro;
    }
    
}
