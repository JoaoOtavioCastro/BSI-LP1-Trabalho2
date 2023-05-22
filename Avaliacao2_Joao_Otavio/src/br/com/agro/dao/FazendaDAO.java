package br.com.agro.dao;

import java.sql.*;
import br.com.agro.dto.FazendaDTO;
import br.com.agro.dto.ProprietarioDTO;

public class FazendaDAO {

    public FazendaDAO() {
    }

    private ResultSet rs = null;
    private Statement stmt = null;

    public boolean inserirFazenda(FazendaDTO fazendaDTO, ProprietarioDTO proprietarioDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Insert into fazenda (nome_faz, end_faz,tamanho_faz, tiposolo_faz, "
                    + " id_ppt) values ( "
                    + "'" + fazendaDTO.getNome_faz() + "', "
                    + "'" + fazendaDTO.getEnd_faz()+ "', "
                    + fazendaDTO.getTamanho_faz() + ", "
                    + fazendaDTO.getTipoSolo_faz()+ ", "
                    + proprietarioDTO.getId_ppt() + ") ";
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
    public boolean alterarFazenda(FazendaDTO fazendaDTO, ProprietarioDTO proprietarioDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Update fazenda set "
                    + "nome_faz = '" + fazendaDTO.getNome_faz() + "', "
                    + "end_faz = '" + fazendaDTO.getEnd_faz() + "', "
                    + "tamanho_faz = " + fazendaDTO.getTamanho_faz() + ", "
                    + "tiposolo_faz = " + fazendaDTO.getTipoSolo_faz()+ ", "
                    + "id_ppt = " + proprietarioDTO.getId_ppt() + " "
                    + "where id_faz = " + fazendaDTO.getId_faz();

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

    public boolean excluirFazenda(FazendaDTO fazendaDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Delete from fazenda where id_faz = "
                    + fazendaDTO.getId_faz();

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

    public ResultSet consultarFazenda(FazendaDTO fazendaDTO, int opcao) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            switch (opcao) {
                case 1:
                    comando = "Select p.* "
                            + "from fazenda p "
                            + "where p.nome_faz ilike '%" + fazendaDTO.getNome_faz() + "%' "
                            + "order by p.nome_faz";
                    break;
                case 2:
                    comando = "Select p.*, f.nome_ppt, f.id_ppt "
                            + "from fazenda p, proprietario f "
                            + "where p.id_ppt = f.id_ppt and "
                            + "p.id_faz = " + fazendaDTO.getId_faz();
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
