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
public class PlantacaoDTO {
String loc_pla, cultivo_pla;
int id_pla, ph_pla, id_faz;
double p_venda_pla, area_pla;
Date dta_pla, p_colheita_pla;

    public String getLoc_pla() {
        return loc_pla;
    }

    public void setLoc_pla(String loc_pla) {
        this.loc_pla = loc_pla;
    }

    public String getCultivo_pla() {
        return cultivo_pla;
    }

    public void setCultivo_pla(String cultivo_pla) {
        this.cultivo_pla = cultivo_pla;
    }

    public int getId_pla() {
        return id_pla;
    }

    public void setId_pla(int id_pla) {
        this.id_pla = id_pla;
    }

    public int getPh_pla() {
        return ph_pla;
    }

    public void setPh_pla(int ph_pla) {
        this.ph_pla = ph_pla;
    }

    public int getId_faz() {
        return id_faz;
    }

    public void setId_faz(int id_faz) {
        this.id_faz = id_faz;
    }

    public double getP_venda_pla() {
        return p_venda_pla;
    }

    public void setP_venda_pla(double p_venda_pla) {
        this.p_venda_pla = p_venda_pla;
    }

    public double getArea_pla() {
        return area_pla;
    }

    public void setArea_pla(double area_pla) {
        this.area_pla = area_pla;
    }

    public Date getDta_pla() {
        return dta_pla;
    }

    public void setDta_pla(Date dta_pla) {
        this.dta_pla = dta_pla;
    }

    public Date getP_colheita_pla() {
        return p_colheita_pla;
    }

    public void setP_colheita_pla(Date p_colheita_pla) {
        this.p_colheita_pla = p_colheita_pla;
    }
}
