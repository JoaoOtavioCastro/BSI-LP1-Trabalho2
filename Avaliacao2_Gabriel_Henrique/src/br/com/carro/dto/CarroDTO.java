package br.com.carro.dto;

public class CarroDTO {
    String modelo_car, ano_car, marca_car;
    int id_car, id_don;

    public String getModelo_car() {
        return modelo_car;
    }

    public void setModelo_car(String modelo_car) {
        this.modelo_car = modelo_car;
    }

    public String getAno_car() {
        return ano_car;
    }

    public void setAno_car(String ano_car) {
        this.ano_car = ano_car;
    }

    public String getMarca_car() {
        return marca_car;
    }

    public void setMarca_car(String marca_car) {
        this.marca_car = marca_car;
    }

    public int getId_car() {
        return id_car;
    }

    public void setId_car(int id_car) {
        this.id_car = id_car;
    }

    public int getId_don() {
        return id_don;
    }

    public void setId_don(int id_don) {
        this.id_don = id_don;
    }
}
