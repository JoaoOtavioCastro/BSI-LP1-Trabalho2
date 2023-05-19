package br.com.carro.dao;

import br.com.carro.dto.MotorDTO;
import br.com.carro.dto.MecanicoDTO;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JTable;

public class ConsertoDAO {
    public ConsertoDAO(){
        
    }
    private ResultSet rs = null;
    Statement stmt = null;
    Statement stmt1 = null;
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    
    public boolean inserirMotor(MotorDTO vendaDTO, MecanicoDTO clienteDTO, JTable produtos){
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            stmt1 = ConexaoDAO.con.createStatement();
            
            String comando1 = "Insert into Motor (dat_vend, val_vend, "
                    + "id_cli) values ( "
                    + "to_date('" + date.format(vendaDTO.getDat_vend()) + "', 'DD/MM/YYYY'), "
                    + vendaDTO.getVal_vend() + ", "
                    + clienteDTO.getId_cli() + ")";
            System.out.println(comando1);
            stmt.execute(comando1.toUpperCase(), Statement.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
            rs.next();
            
            for (int cont = 0; cont < produtos.getRowCount(); cont++){
                String comando2 = "Insert into produto_venda (id_vend, id_prod, "
                        + "val_prod, qtd_prod) values ( "
                        + rs.getInt("id_vend") + ", "
                        + produtos.getValueAt(cont, 0) + ", "
                        + produtos.getValueAt(cont, 2) + ", "
                        + produtos.getValueAt(cont, 3) + "); ";
                stmt1.execute(comando2.toUpperCase());
                        
            }
            
            ConexaoDAO.con.commit();
            
            stmt.close();
            stmt1.close();
            rs.close();
            
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao inserir VENDA! " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }
}
