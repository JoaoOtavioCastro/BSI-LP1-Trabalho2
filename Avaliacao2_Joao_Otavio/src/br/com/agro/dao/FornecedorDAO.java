/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agro.dao;

import br.com.agro.dto.FornecedorDTO;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author jotav
 */
public class FornecedorDAO {

    public FornecedorDAO() {
    }

    private ResultSet rs = null;
    private Statement stmt = null;

    public boolean inserirFornecedor(FornecedorDTO fdto) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "INSERT INTO fornecedor (nome_for, tel_for, cnpj_for) "
                    + "VALUES ('" + fdto.getNome_for() + "', '" + fdto.getTel_for() + "', '" + fdto.getCnpj_for() + "')";
            stmt.execute(comando);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro Inserir Fornecedor: " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    public boolean alterarFornecedor(FornecedorDTO fdto) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "UPDATE fornecedor set nome_for = '"
                    + fdto.getNome_for() + "', tel_for='" + fdto.getTel_for()
                    + "', cnpj_for='" + fdto.getCnpj_for() + "' where id_for="
                    + fdto.getId_for();
            System.out.println(comando);
            stmt.execute(comando);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro Alterar Fornecedor: " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    public boolean excluirFornecedor(FornecedorDTO fdto) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "DELETE FROM fornecedor WHERE id_for = " + fdto.getId_for();
            stmt.execute(comando);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao Excluir Fornecedor: " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    public ResultSet consultarFornecedor(FornecedorDTO fdto, int opc) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            switch (opc) {
                case 1:
                    comando = "SELECT f.id_for, f.nome_for FROM fornecedor f where f.nome_for ilike '%"
                            + fdto.getNome_for() + "%' " + "order by f.nome_for";
                    break;
                case 2:
                    comando = "SELECT f.nome_for, f.tel_for, f.cnpj_for FROM fornecedor f where f.id_for = " + fdto.getId_for();
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
