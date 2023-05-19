package br.com.carro.dao;


import java.sql.*;
import br.com.carro.dto.MotorDTO;
import br.com.carro.dto.CarroDTO;

public class MotorDAO {
    
    /**
     * Método construtor da classe
     */
    public MotorDAO() {
    }

    //Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o banco de dados
    private Statement stmt = null;
    
    
    /**
     * Método utilizado para inserir um objeto motorDTO no banco de dados
     * @param motorDTO, que vem da classe MotorDTO
     * @param carroDTO, que vem da classe CarroDTO
     * @return Um boolean
     */
    public boolean inserirMotor(MotorDTO motorDTO, CarroDTO carroDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Instancia o Statement que sera responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Insert into motor (potencia_mot, qtdbloco_mot, "
                    + " id_car) values ( "
                    + "" + motorDTO.getPotencia_mot()+ ", "
                    + "" + motorDTO.getQtdBloco_mot()+ ", "
                    + carroDTO.getId_car()+ ") ";
            
            //Executa o comando SQL no banco de Dados
            stmt.execute(comando.toUpperCase());
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            return true;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } //Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }//Fecha o método inserirMotor
    
    
    /**
     * Método utilizado para alterar um objeto motorDTO no banco de dados
     *
     * @param motorDTO, que vem da classe MotorCTR
     * @param carroDTO, que vem da classe CarroCTR
     * @return Um boolean
     */
    public boolean alterarMotor(MotorDTO motorDTO, CarroDTO carroDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Update motor set "
                    + "qtdbloco_mot = '" + motorDTO.getQtdBloco_mot()+ "', "
                    + "potencia_mot = '" + motorDTO.getPotencia_mot()+ "', "
                    + "id_car = " + carroDTO.getId_car()+ " "
                    + "where id_mot = " + motorDTO.getId_mot();
                       
            //Executa o comando SQL no banco de Dados
            stmt.execute(comando.toUpperCase());
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            return true;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem 
          //no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } //Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }//Fecha o método alterarMotor
    
    
    /**
     * Método utilizado para excluir um objeto motorDTO no banco de dados
     *
     * @param motorDTO que vem da classe MotorCTR
     * @return Um boolean
     */
    public boolean excluirMotor(MotorDTO motorDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Instancia o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Delete from motor where id_mot = " 
                             + motorDTO.getId_mot();

            //Executa o comando SQL no banco de Dados
            stmt.execute(comando);
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            return true;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } //Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }//Fecha o método excluirMotor
    
        
    
    /**
     * Método utilizado para consultar um objeto motorDTO no banco de dados
     *
     * @param motorDTO, que vem da classe MotorCTR
     * @param opcao, que vem da classe MotorCTR
     * @return Um ResultSet com os dados do motor e carro
     */
    public ResultSet consultarMotor(MotorDTO motorDTO, int opcao) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "";
            switch (opcao){
                case 1:
                    comando = "Select p.* "+
                              "from motor p "+
                              "where p.potencia_mot =" + motorDTO.getPotencia_mot();    
                break;
                case 2:
                    comando = "Select p.*, f.* "+
                              "from motor p, carro f " +
                              "where p.id_car = f.id_car and " +
                              "p.id_mot = " + motorDTO.getId_mot();
                break;
                                
            }
            //Executa o comando SQL no banco de Dados
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }//Fecha o método consultarMotor
    
}//Fecha classe MotorDAO
