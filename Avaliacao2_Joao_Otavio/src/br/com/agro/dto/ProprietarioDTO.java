/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.agro.dto;

import java.util.Date;

/**
 *
 * @author jotavio
 */
public class ProprietarioDTO {
 String nome_ppt, tel_ppt, cnpj_ppt;
 Date  dtaNasc_ppt;
 int id_ppt;

    public String getNome_ppt() {
        return nome_ppt;
    }

    public void setNome_ppt(String nome_ppt) {
        this.nome_ppt = nome_ppt;
    }

    public String getTel_ppt() {
        return tel_ppt;
    }

    public void setTel_ppt(String tel_ppt) {
        this.tel_ppt = tel_ppt;
    }

    public String getCnpj_ppt() {
        return cnpj_ppt;
    }

    public void setCnpj_ppt(String cnpj_ppt) {
        this.cnpj_ppt = cnpj_ppt;
    }

    public Date getDtaNasc_ppt() {
        return dtaNasc_ppt;
    }

    public void setDtaNasc_ppt(Date dtaNasc_ppt) {
        this.dtaNasc_ppt = dtaNasc_ppt;
    }

    public int getId_ppt() {
        return id_ppt;
    }

    public void setId_ppt(int id_ppt) {
        this.id_ppt = id_ppt;
    }
}
