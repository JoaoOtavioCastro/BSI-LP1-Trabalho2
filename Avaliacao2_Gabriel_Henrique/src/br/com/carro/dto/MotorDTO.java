package br.com.carro.dto;

public class MotorDTO {
    int id_mot, qtdBloco_mot, potencia_mot, id_car;

    public int getId_mot() {
        return id_mot;
    }

    public void setId_mot(int id_mot) {
        this.id_mot = id_mot;
    }

    public int getQtdBloco_mot() {
        return qtdBloco_mot;
    }

    public void setQtdBloco_mot(int qtdBloco_mot) {
        this.qtdBloco_mot = qtdBloco_mot;
    }

    public int getPotencia_mot() {
        return potencia_mot;
    }

    public void setPotencia_mot(int potencia_mot) {
        this.potencia_mot = potencia_mot;
    }

    public int getId_car() {
        return id_car;
    }

    public void setId_car(int id_car) {
        this.id_car = id_car;
    }
}
