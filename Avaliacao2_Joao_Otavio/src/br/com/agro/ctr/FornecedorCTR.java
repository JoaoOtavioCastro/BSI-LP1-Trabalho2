/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agro.ctr;

import br.com.agro.dao.ConexaoDAO;
import br.com.agro.dao.FornecedorDAO;
import br.com.agro.dto.FornecedorDTO;
import java.sql.ResultSet;

/**
 *
 * @author jotav
 */
public class FornecedorCTR {
    public FornecedorCTR(){
        
    }
    FornecedorDAO fdao = new FornecedorDAO();
    public String inserirFornecedor(FornecedorDTO fdto){
        try{
            if(fdao.inserirFornecedor(fdto)){
                return "Fornecedor Cadastrado com Sucesso!";
            }else{
                return "Fornecedor não Cadastrado!";
            }
        }catch(Exception e){
            System.out.println("Erro inserir: "+e.getMessage());
            return "Fornecedor não Cadastrado!";
        }
    }
    public String alterarFornecedor(FornecedorDTO fdto){
        try{
            if(fdao.alterarFornecedor(fdto)){
                return "Fornecedor Alterado com Sucesso!";
            }else{
                return "Fornecedor não Alterado!";
            }
        }catch(Exception e){
            System.out.println("Erro alterar: "+e.getMessage());
            return "Fornecedor não Alterado!";
        }
    }
    public String excluirFornecedor(FornecedorDTO fdto){
        try{
            if(fdao.excluirFornecedor(fdto)){
                return "Fornecedor Excluido com Sucesso!";
            }else{
                return "Fornecedor não Excluido!";
            }
        }catch(Exception e){
            System.out.println("Erro excluir: "+e.getMessage());
            return "Fornecedor não Excluido!";
        }
    }
    public ResultSet consultarFornecedor(FornecedorDTO fdto, int opc){
        ResultSet rs = null;
        rs = fdao.consultarFornecedor(fdto, opc);
        return rs;
    }
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
}
