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
String cultivo_pla;
int id_pla, ph_pla, id_faz;
double  area_pla;
String  p_colheita_pla;



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



    public double getArea_pla() {
        return area_pla;
    }

    public void setArea_pla(double area_pla) {
        this.area_pla = area_pla;
    }

    public String getP_colheita_pla() {
        return p_colheita_pla;
    }

    public void setP_colheita_pla(String p_colheita_pla) {
        this.p_colheita_pla = p_colheita_pla;
    }
}
