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
public class AplicacaoDTO {
    int id_pla, id_apl;
    Date dta_apl;
    double valor_apl;

    public int getId_pla() {
        return id_pla;
    }

    public void setId_pla(int id_pla) {
        this.id_pla = id_pla;
    }

    public int getId_apl() {
        return id_apl;
    }

    public void setId_apl(int id_apl) {
        this.id_apl = id_apl;
    }

    public Date getDta_apl() {
        return dta_apl;
    }

    public void setDta_apl(Date dta_apl) {
        this.dta_apl = dta_apl;
    }

    public double getValor_apl() {
        return valor_apl;
    }

    public void setValor_apl(double valor_apl) {
        this.valor_apl = valor_apl;
    }
}
