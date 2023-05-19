package br.com.carro.dto;

public class DonoDTO {
String nome_don, cpf_don, email_don, tel_don;
int id_don;
    public String getNome_don() {
        return nome_don;
    }

    public void setNome_don(String nome_don) {
        this.nome_don = nome_don;
    }

    public String getCpf_don() {
        return cpf_don;
    }

    public void setCpf_don(String cpf_don) {
        this.cpf_don = cpf_don;
    }

    public String getEmail_don() {
        return email_don;
    }

    public void setEmail_don(String email_don) {
        this.email_don = email_don;
    }

    public String getTel_don() {
        return tel_don;
    }

    public void setTel_don(String tel_don) {
        this.tel_don = tel_don;
    }

    public int getId_don() {
        return id_don;
    }

    public void setId_don(int id_don) {
        this.id_don = id_don;
    }
}
