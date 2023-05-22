package br.com.agro.ctr;

import br.com.agro.dao.AplicacaoDAO;
import br.com.agro.dao.ConexaoDAO;
import br.com.agro.dto.AplicacaoDTO;
import br.com.agro.dto.PlantacaoDTO;
import javax.swing.JTable;

public class AplicacaoCTR {
    AplicacaoDAO aplicacaoDAO = new AplicacaoDAO();
    
    public AplicacaoCTR(){
        
    }
    
    public String inserirAplicacao(AplicacaoDTO aplicacaoDTO, PlantacaoDTO plantacaoDTO, JTable produtos){
        try {
            if (aplicacaoDAO.inserirAplicacao(aplicacaoDTO, plantacaoDTO, produtos)){
                return "Aplicacao cadastrada com SUCESSO! ";
            } else {
                return "Aplicacao NÃO cadastrada! ";
            }
        } catch (Exception e) {
            System.out.println("Aplicacao NÃO cadastrada" + e.getMessage());
            return "Aplicacao NÃO cadastrada! ";
        }
    }
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
}
