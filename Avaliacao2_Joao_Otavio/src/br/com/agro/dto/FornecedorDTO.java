/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.agro.dto;

/**
 *
 * @author jotavio
 */
public class FornecedorDTO {
 String nome_for, tel_for, cnpj_for;
 int id_for;

    public String getNome_for() {
        return nome_for;
    }

    public void setNome_for(String nome_for) {
        this.nome_for = nome_for;
    }

    public String getTel_for() {
        return tel_for;
    }

    public void setTel_for(String tel_for) {
        this.tel_for = tel_for;
    }

    public String getCnpj_for() {
        return cnpj_for;
    }

    public void setCnpj_for(String cnpj_for) {
        this.cnpj_for = cnpj_for;
    }

    public int getId_for() {
        return id_for;
    }

    public void setId_for(int id_for) {
        this.id_for = id_for;
    }
}