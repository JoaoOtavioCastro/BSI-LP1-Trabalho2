/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agro.ctr;

import br.com.agro.dao.ConexaoDAO;
import br.com.agro.dao.ProprietarioDAO;
import br.com.agro.dto.ProprietarioDTO;
import java.sql.ResultSet;

/**
 *
 * @author jotav
 */
public class ProprietarioCTR {
    public ProprietarioCTR(){
        
    }
    ProprietarioDAO fdao = new ProprietarioDAO();
    public String inserirProprietario(ProprietarioDTO fdto){
        try{
            if(fdao.inserirProprietario(fdto)){
                return "Proprietario Cadastrado com Sucesso!";
            }else{
                return "Proprietario não Cadastrado!";
            }
        }catch(Exception e){
            System.out.println("Erro inserir: "+e.getMessage());
            return "Proprietario não Cadastrado!";
        }
    }
    public String alterarProprietario(ProprietarioDTO fdto){
        try{
            if(fdao.alterarProprietario(fdto)){
                return "Proprietario Alterado com Sucesso!";
            }else{
                return "Proprietario não Alterado!";
            }
        }catch(Exception e){
            System.out.println("Erro alterar: "+e.getMessage());
            return "Proprietario não Alterado!";
        }
    }
    public String excluirProprietario(ProprietarioDTO fdto){
        try{
            if(fdao.excluirProprietario(fdto)){
                return "Proprietario Excluido com Sucesso!";
            }else{
                return "Proprietario não Excluido!";
            }
        }catch(Exception e){
            System.out.println("Erro excluir: "+e.getMessage());
            return "Proprietario não Excluido!";
        }
    }
    public ResultSet consultarProprietario(ProprietarioDTO fdto, int opc){
        ResultSet rs = null;
        rs = fdao.consultarProprietario(fdto, opc);
        return rs;
    }
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
}
