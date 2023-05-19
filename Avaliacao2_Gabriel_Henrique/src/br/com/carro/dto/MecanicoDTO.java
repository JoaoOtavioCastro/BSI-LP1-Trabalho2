package br.com.carro.dto;

public class MecanicoDTO {
    String nome_mec, cpf_mec, tel_mec;
    int id_mec;
    public String getNome_mec() {
        return nome_mec;
    }

    public void setNome_mec(String nome_mec) {
        this.nome_mec = nome_mec;
    }

    public String getCpf_mec() {
        return cpf_mec;
    }

    public void setCpf_mec(String cpf_mec) {
        this.cpf_mec = cpf_mec;
    }

    public String getTel_mec() {
        return tel_mec;
    }

    public void setTel_mec(String tel_mec) {
        this.tel_mec = tel_mec;
    }

    public int getId_mec() {
        return id_mec;
    }

    public void setId_mec(int id_mec) {
        this.id_mec = id_mec;
    }
}