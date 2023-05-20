package br.com.agro.dao;

import java.sql.*;
import br.com.agro.dto.ProdutoDTO;
import br.com.agro.dto.FornecedorDTO;

public class ProdutoDAO {

    public ProdutoDAO() {
    }

    private ResultSet rs = null;
    private Statement stmt = null;

    public boolean inserirProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Insert into produto (nome_pro, desc_pro, preco_pro, "
                    + "tipo_pro, id_for) values ( "
                    + "'" + produtoDTO.getNome_pro() + "', "
                    + "'" + produtoDTO.getDesc_pro() + "', "
                    + produtoDTO.getPreco_pro() + ", "
                    + produtoDTO.getTipo_pro() + ", "
                    + fornecedorDTO.getId_for() + ") ";

            stmt.execute(comando);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    public boolean alterarProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Update produto set "
                    + "nome_pro = '" + produtoDTO.getNome_pro() + "', "
                    + "desc_pro = '" + produtoDTO.getDesc_pro() + "', "
                    + "preco_pro = " + produtoDTO.getPreco_pro() + ", "
                    + "tipo_pro = " + produtoDTO.getTipo_pro() + ", "
                    + "id_for = " + fornecedorDTO.getId_for() + " "
                    + "where id_pro = " + produtoDTO.getId_pro();

            stmt.execute(comando);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    public boolean excluirProduto(ProdutoDTO produtoDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Delete from produto where id_pro = "
                    + produtoDTO.getId_pro();

            stmt.execute(comando);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    public ResultSet consultarProduto(ProdutoDTO produtoDTO, int opcao) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            switch (opcao) {
                case 1:
                    comando = "Select p.* "
                            + "from produto p "
                            + "where p.nome_pro ilike '%" + produtoDTO.getNome_pro() + "%' "
                            + "order by p.nome_pro";
                    break;
                case 2:
                    comando = "Select p.*, f.nome_for, f.id_for "
                            + "from produto p, fornecedor f "
                            + "where p.id_for = f.id_for and "
                            + "p.id_pro = " + produtoDTO.getId_pro();
                    break;

            }
            rs = stmt.executeQuery(comando);
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }
}
