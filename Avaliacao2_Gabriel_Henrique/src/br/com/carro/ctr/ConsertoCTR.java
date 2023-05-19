package br.com.carro.ctr;

import br.com.carro.dao.ConsertoDAO;
import br.com.carro.dao.ConexaoDAO;
import br.com.carro.dto.MotorDTO;
import br.com.carro.dto.MecanicoDTO;
import javax.swing.JTable;

public class ConsertoCTR {
    ConsertoDAO motorDAO = new ConsertoDAO();
    
    public ConsertoCTR(){
        
    }
    
    public String inserirConserto(MotorDTO motorDTO, MecanicoDTO mecanicoDTO, JTable produtos){
        try {
            if (consertoDAO.inserirMotor(motorDTO, mecanicoDTO, produtos)){
                return "Motor cadastrada com SUCESSO! ";
            } else {
                return "Motor NÃO cadastrada! ";
            }
        } catch (Exception e) {
            System.out.println("Motor NÃO cadastrada" + e.getMessage());
            return "Motor NÃO cadastrada! ";
        }
    }
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
}
