/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agro.ctr;

import br.com.agro.dao.ConexaoDAO;
import br.com.agro.dao.FuncionarioDAO;
import br.com.agro.dto.FuncionarioDTO;
import java.sql.ResultSet;

/**
 *
 * @author jotav
 */
public class FuncionarioCTR {
    FuncionarioDAO fdao = new FuncionarioDAO();

    public FuncionarioCTR() {
    }
    public String inserirFuncionario(FuncionarioDTO fdto){
        try{
            if(fdao.inserirFuncionario(fdto)){
                return "Funcionário Cadastrado com Sucesso!!!";
            }else{
                return "Funcionário não Cadastrado!!!";
            }
        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
            return "Funcionário não cadastrado!";
        }
    }
    public String alterarFuncionario(FuncionarioDTO fdto){
        try{
            if(fdao.alterarFuncionario(fdto)){
                return "Funcionário Alterado com Sucesso!!!";
            }else{
                return "Funcionário não Alterado!!!";
            }
        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
            return "Funcionário não alterado!";
        }
    }
    public String excluirFuncionario(FuncionarioDTO fdto){
        try{
            if(fdao.excluirFuncionario(fdto)){
                return "Funcionário Exlcuido com Sucesso!!!";
            }else{
                return "Funcionário não Exlcuido!!!";
            }
        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
            return "Funcionário não excluido!";
        }
    }
    public ResultSet consultarFuncionario(FuncionarioDTO fdto, int opc){
        ResultSet rs = null;
        rs = fdao.consultarFuncionario(fdto, opc);
        return rs;
    }
    public int logarFuncionario(FuncionarioDTO fdto){
        return fdao.logarFuncionario(fdto);
    }
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
}