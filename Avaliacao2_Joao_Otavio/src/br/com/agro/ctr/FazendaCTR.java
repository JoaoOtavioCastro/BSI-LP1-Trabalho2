package br.com.agro.ctr;

import java.sql.ResultSet;
import br.com.agro.dto.ProprietarioDTO;
import br.com.agro.dto.FazendaDTO;
import br.com.agro.dao.FazendaDAO;
import br.com.agro.dao.ConexaoDAO;

public class FazendaCTR {

    FazendaDAO fazendaDAO = new FazendaDAO();

    public FazendaCTR() {
    }

    public String inserirFazenda(FazendaDTO fazendaDTO, ProprietarioDTO proprietarioDTO) {
        try {
            if (fazendaDAO.inserirFazenda(fazendaDTO, proprietarioDTO)) {
                return "Fazenda Cadastrado com Sucesso!!!";
            } else {
                return "Fazenda NÃO Cadastrado!!!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fazenda NÃO Cadastrado";
        }
    }

    public String alterarFazenda(FazendaDTO fazendaDTO, ProprietarioDTO proprietarioDTO) {
        try {
            if (fazendaDAO.alterarFazenda(fazendaDTO, proprietarioDTO)) {
                return "Fazenda Alterado com Sucesso!!!";
            } else {
                return "Fazenda NÃO Alterado!!!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fazenda NÃO Alterado!!!";
        }
    }

    public String excluirFazenda(FazendaDTO fazendaDTO) {
        try {
            if (fazendaDAO.excluirFazenda(fazendaDTO)) {
                return "Fazenda Excluído com Sucesso!!!";
            } else {
                return "Fazenda NÃO Excluído!!!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fazenda NÃO Excluído!!!";
        }
    }

    public ResultSet consultarFazenda(FazendaDTO fazendaDTO, int opcao) {
        ResultSet rs = null;
        rs = fazendaDAO.consultarFazenda(fazendaDTO, opcao);
        return rs;
    }

    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }

}
