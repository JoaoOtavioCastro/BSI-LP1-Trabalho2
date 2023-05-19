package br.com.carro.dao;


import java.sql.*;
import br.com.carro.dto.CarroDTO;
import br.com.carro.dto.DonoDTO;

public class CarroDAO {
    
    /**
     * Método construtor da classe
     */
    public CarroDAO() {
    }

    //Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o banco de dados
    private Statement stmt = null;
    
    
    /**
     * Método utilizado para inserir um objeto carroDTO no banco de dados
     * @param carroDTO, que vem da classe CarroDTO
     * @param donoDTO, que vem da classe DonoDTO
     * @return Um boolean
     */
    public boolean inserirCarro(CarroDTO carroDTO, DonoDTO donoDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Instancia o Statement que sera responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Insert into carro (modelo_car, ano_car, "
                    + "marca_car, id_don) values ( "
                    + "'" + carroDTO.getModelo_car()+ "', "
                    + "'" + carroDTO.getAno_car()+ "', "
                    + "'" + carroDTO.getMarca_car()+ "', "
                    + donoDTO.getId_don()+ ") ";
            
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
    }//Fecha o método inserirCarro
    
    
    /**
     * Método utilizado para alterar um objeto carroDTO no banco de dados
     *
     * @param carroDTO, que vem da classe CarroCTR
     * @param donoDTO, que vem da classe DonoCTR
     * @return Um boolean
     */
    public boolean alterarCarro(CarroDTO carroDTO, DonoDTO donoDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Update carro set "
                    + "modelo_car = '" + carroDTO.getModelo_car()+ "', "
                    + "marca_car = '" + carroDTO.getMarca_car()+ "', "
                    + "ano_car = '" + carroDTO.getAno_car()+ "', "
                    + "id_don = " + donoDTO.getId_don()+ " "
                    + "where id_car = " + carroDTO.getId_car();
                       
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
    }//Fecha o método alterarCarro
    
    
    /**
     * Método utilizado para excluir um objeto carroDTO no banco de dados
     *
     * @param carroDTO que vem da classe CarroCTR
     * @return Um boolean
     */
    public boolean excluirCarro(CarroDTO carroDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Instancia o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Delete from carro where id_car = " 
                             + carroDTO.getId_car();

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
    }//Fecha o método excluirCarro
    
        
    
    /**
     * Método utilizado para consultar um objeto carroDTO no banco de dados
     *
     * @param carroDTO, que vem da classe CarroCTR
     * @param opcao, que vem da classe CarroCTR
     * @return Um ResultSet com os dados do carro e dono
     */
    public ResultSet consultarCarro(CarroDTO carroDTO, int opcao) {
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
                              "from carro p "+
                              "where p.modelo_car ilike '" + carroDTO.getModelo_car()+ "%' " +
                              "order by p.modelo_car";    
                break;
                case 2:
                    comando = "Select p.*, f.* "+
                              "from carro p, dono f " +
                              "where p.id_don = f.id_don and " +
                              "p.id_car = " + carroDTO.getId_car();
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
    }//Fecha o método consultarCarro
    
}//Fecha classe CarroDAO
