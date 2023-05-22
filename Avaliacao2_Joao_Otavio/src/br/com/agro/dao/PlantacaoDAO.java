package br.com.agro.dao;

import java.sql.*;
import br.com.agro.dto.PlantacaoDTO;
import br.com.agro.dto.FazendaDTO;

public class PlantacaoDAO {

    public PlantacaoDAO() {
    }

    private ResultSet rs = null;
    private Statement stmt = null;

    public boolean inserirPlantacao(PlantacaoDTO plantacaoDTO, FazendaDTO fazendaDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Insert into plantacao (cultivo_pla, colheita_pla, area_pla, "
                    + "ph_pla, id_faz) values ( "
                    + "'" + plantacaoDTO.getCultivo_pla() + "', "
                    + "'" + plantacaoDTO.getP_colheita_pla() + "', "
                    + plantacaoDTO.getArea_pla()+ ", "
                    + plantacaoDTO.getPh_pla() + ", "
                    + fazendaDTO.getId_faz() + ") ";

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

    public boolean alterarPlantacao(PlantacaoDTO plantacaoDTO, FazendaDTO fazendaDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Update plantacao set "
                    + "cultivo_pla = '" + plantacaoDTO.getCultivo_pla() + "', "
                    + "colheita_pla = '" + plantacaoDTO.getP_colheita_pla() + "', "
                    + "area_pla = " + plantacaoDTO.getArea_pla() + ", "
                    + "ph_pla = " + plantacaoDTO.getPh_pla() + ", "
                    + "id_faz = " + fazendaDTO.getId_faz() + " "
                    + "where id_pla = " + plantacaoDTO.getId_pla();

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

    public boolean excluirPlantacao(PlantacaoDTO plantacaoDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Delete from plantacao where id_pla = "
                    + plantacaoDTO.getId_pla();

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

    public ResultSet consultarPlantacao(PlantacaoDTO plantacaoDTO, int opcao) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            switch (opcao) {
                case 1:
                    comando = "Select p.* "
                            + "from plantacao p "
                            + "where p.cultivo_pla ilike '%" + plantacaoDTO.getCultivo_pla() + "%' "
                            + "order by p.cultivo_pla";
                    break;
                case 2:
                    comando = "Select p.*, f.nome_faz, f.id_faz "
                            + "from plantacao p, fazenda f "
                            + "where p.id_faz = f.id_faz and "
                            + "p.id_pla = " + plantacaoDTO.getId_pla();
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
