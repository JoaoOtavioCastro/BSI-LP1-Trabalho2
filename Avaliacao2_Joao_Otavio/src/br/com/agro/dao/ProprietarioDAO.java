/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agro.dao;

import br.com.agro.dto.ProprietarioDTO;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
 *
 * @author jotav
 */
public class ProprietarioDAO {

    public ProprietarioDAO() {
    }
    SimpleDateFormat data_format= new SimpleDateFormat("dd/mm/yyyy");
    private ResultSet rs = null;
    private Statement stmt = null;

    public boolean inserirProprietario(ProprietarioDTO fdto) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "INSERT INTO proprietario (nome_ppt, tel_ppt, cnpj_ppt, dtanasc_ppt) "
                    + "VALUES ('" + fdto.getNome_ppt() + "', '" + fdto.getTel_ppt() 
                    + "', '" + fdto.getCnpj_ppt() + "', to_date('"+data_format.format(fdto.getDtaNasc_ppt())+"','dd/mm/yyyy'))";
            stmt.execute(comando);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro Inserir Proprietario: " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    public boolean alterarProprietario(ProprietarioDTO fdto) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "UPDATE proprietario set nome_ppt = '"
                    + fdto.getNome_ppt() + "', tel_ppt='" + fdto.getTel_ppt()
                    + "', cnpj_ppt='" + fdto.getCnpj_ppt() + "', "+
                    "dtanasc_ppt=to_date('"+data_format.format(fdto.getDtaNasc_ppt())+"','dd/mm/yyyy')"
                    + " where id_ppt="
                    + fdto.getId_ppt();
            System.out.println(comando);
            stmt.execute(comando);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro Alterar Proprietario: " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    public boolean excluirProprietario(ProprietarioDTO fdto) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "DELETE FROM proprietario WHERE id_ppt = " + fdto.getId_ppt();
            stmt.execute(comando);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao Excluir Proprietario: " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    public ResultSet consultarProprietario(ProprietarioDTO fdto, int opc) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            switch (opc) {
                case 1:
                    comando = "SELECT f.id_ppt, f.nome_ppt FROM proprietario f where f.nome_ppt ilike '%"
                            + fdto.getNome_ppt() + "%' " + "order by f.nome_ppt";
                    break;
                case 2:
                    comando = "SELECT f.* FROM proprietario f where f.id_ppt = " + fdto.getId_ppt();
                    break;
            }
            rs = stmt.executeQuery(comando);
            return rs;
        } catch (Exception e) {
            System.out.println("Erro Consultar: " + e.getMessage());
            return rs;
        }
    }
}
