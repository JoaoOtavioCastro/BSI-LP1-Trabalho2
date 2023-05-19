package br.com.carro.ctr;
/**
 *
 * @author Andre Luis Gobbi Primo/Ivan Oliveira Lopes
 */

import java.sql.ResultSet;
import br.com.carro.dto.CarroDTO;
import br.com.carro.dto.MotorDTO;
import br.com.carro.dao.MotorDAO;
import br.com.carro.dao.ConexaoDAO;

public class MotorCTR {
    
    MotorDAO motorDAO = new MotorDAO();
    
    /**
     * Método construtor da classe
     */
    public MotorCTR() {
    }

    
    
    /**
     * Método utilizado para controlar o acesso ao método inserirMotor da
     * classe MotorDAO
     * @param motorDTO, que vem da classe sa página (VIEW)
     * @param carroDTO, que vem da classe da página (VIEW) 
     * @return String contendo a mensagem
     */
    public String inserirMotor(MotorDTO motorDTO, CarroDTO carroDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (motorDAO.inserirMotor(motorDTO, carroDTO)) {
                return "Motor Cadastrado com Sucesso!!!";
            } else {
                return "Motor NÃO Cadastrado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Motor NÃO Cadastrado";
        }
    }//Fecha o método inserirMotor
    
    
    /**
     * Método utilizado para controlar o acesso ao método alterarMotor da
     * classe MotorDAO
     * @param motorDTO, que vem da classe da página (VIEW)
     * @param carroDTO, que vem da classe da página (VIEW) 
     * @return String contendo a mensagem
     */
    public String alterarMotor(MotorDTO motorDTO, CarroDTO carroDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (motorDAO.alterarMotor(motorDTO, carroDTO)) {
                return "Motor Alterado com Sucesso!!!";
            } else {
                return "Motor NÃO Alterado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Motor NÃO Alterado!!!";
        }
    }//Fecha o método alterarMotor

    
    /**
     * Método utilizado para controlar o acesso ao método excluirMotor da
     * classe MotorDAO
     * @param motorDTO que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String excluirMotor(MotorDTO motorDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (motorDAO.excluirMotor(motorDTO)) {
                return "Motor Excluído com Sucesso!!!";
            } else {
                return "Motor NÃO Excluído!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Motor NÃO Excluído!!!";
        }
    }//Fecha o método excluirMotor

    
    /**
     * Método utilizado para controlar o acesso ao método consultarMotor da
     * classe MotorDAO
     * @param motorDTO que vem da classe da página (VIEW)
     * @param opcao que vem da classe da página (VIEW)
     * @return ResultSet com os dados do motor e carro
     */
    public ResultSet consultarMotor(MotorDTO motorDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;
        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = motorDAO.consultarMotor(motorDTO, opcao);
        return rs;
    }//Fecha o método consultarMotor
    
    
    /**
     * Método utilizado para fechar o banco de dados
     */
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB
    
    
}//Fecha classe MotorCTR
