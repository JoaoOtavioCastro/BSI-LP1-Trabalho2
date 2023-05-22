package br.com.agro.ctr;

import java.sql.ResultSet;
import br.com.agro.dto.FazendaDTO;
import br.com.agro.dto.PlantacaoDTO;
import br.com.agro.dao.PlantacaoDAO;
import br.com.agro.dao.ConexaoDAO;

public class PlantacaoCTR {

    PlantacaoDAO plantacaoDAO = new PlantacaoDAO();

    public PlantacaoCTR() {
    }

    public String inserirPlantacao(PlantacaoDTO plantacaoDTO, FazendaDTO fazendaDTO) {
        try {
            if (plantacaoDAO.inserirPlantacao(plantacaoDTO, fazendaDTO)) {
                return "Plantacao Cadastrado com Sucesso!!!";
            } else {
                return "Plantacao NÃO Cadastrado!!!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Plantacao NÃO Cadastrado";
        }
    }

    public String alterarPlantacao(PlantacaoDTO plantacaoDTO, FazendaDTO fazendaDTO) {
        try {
            if (plantacaoDAO.alterarPlantacao(plantacaoDTO, fazendaDTO)) {
                return "Plantacao Alterado com Sucesso!!!";
            } else {
                return "Plantacao NÃO Alterado!!!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Plantacao NÃO Alterado!!!";
        }
    }

    public String excluirPlantacao(PlantacaoDTO plantacaoDTO) {
        try {
            if (plantacaoDAO.excluirPlantacao(plantacaoDTO)) {
                return "Plantacao Excluído com Sucesso!!!";
            } else {
                return "Plantacao NÃO Excluído!!!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Plantacao NÃO Excluído!!!";
        }
    }

    public ResultSet consultarPlantacao(PlantacaoDTO plantacaoDTO, int opcao) {
        ResultSet rs = null;
        rs = plantacaoDAO.consultarPlantacao(plantacaoDTO, opcao);
        return rs;
    }

    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }

}
