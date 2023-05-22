package br.com.agro.dao;

import br.com.agro.dto.AplicacaoDTO;
import br.com.agro.dto.PlantacaoDTO;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JTable;

public class AplicacaoDAO {
    public AplicacaoDAO(){
        
    }
    private ResultSet rs = null;
    Statement stmt = null;
    Statement stmt1 = null;
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    
    public boolean inserirAplicacao(AplicacaoDTO aplicacaoDTO, PlantacaoDTO plantacaoDTO, JTable produtos){
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            stmt1 = ConexaoDAO.con.createStatement();
            
            String comando1 = "Insert into Aplicacao (dta_apl, val_apli, "
                    + "id_pla) values ( "
                    + "to_date('" + date.format(aplicacaoDTO.getDta_apl()) + "', 'DD/MM/YYYY'), "
                    + aplicacaoDTO.getValor_apl() + ", "
                    + plantacaoDTO.getId_pla() + ")";
            System.out.println(comando1);
            stmt.execute(comando1, Statement.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
            rs.next();
            
            for (int cont = 0; cont < produtos.getRowCount(); cont++){
                String comando2 = "Insert into produto_aplicacao (id_apl, id_pro, "
                        + "val_pro, qtd_pro) values ( "
                        + rs.getInt("id_apl") + ", "
                        + produtos.getValueAt(cont, 0) + ", "
                        + produtos.getValueAt(cont, 2) + ", "
                        + produtos.getValueAt(cont, 3) + "); ";
                stmt1.execute(comando2);
                        
            }
            
            ConexaoDAO.con.commit();
            
            stmt.close();
            stmt1.close();
            rs.close();
            
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao inserir Aplicação! " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }
}
