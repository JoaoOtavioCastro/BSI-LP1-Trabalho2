/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.agro.dto;

/**
 *
 * @author jotavio
 */
public class ProdutoDTO {
String nome_pro, desc_pro;
int id_pro, id_for, tipo_pro;
double preco_pro;

    public String getNome_pro() {
        return nome_pro;
    }

    public void setNome_pro(String nome_pro) {
        this.nome_pro = nome_pro;
    }

    public String getDesc_pro() {
        return desc_pro;
    }

    public void setDesc_pro(String desc_pro) {
        this.desc_pro = desc_pro;
    }

    public int getId_pro() {
        return id_pro;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    public int getId_for() {
        return id_for;
    }

    public void setId_for(int id_for) {
        this.id_for = id_for;
    }

    public int getTipo_pro() {
        return tipo_pro;
    }

    public void setTipo_pro(int tipo_pro) {
        this.tipo_pro = tipo_pro;
    }

    public double getPreco_pro() {
        return preco_pro;
    }

    public void setPreco_pro(double preco_pro) {
        this.preco_pro = preco_pro;
    }
}
