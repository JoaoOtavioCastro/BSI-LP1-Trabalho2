package br.com.carro.dao;

import java.sql.*;
import br.com.carro.dto.DonoDTO;

public class DonoDAO {
    
    /**
     * Método construtor da classe
     */
    public DonoDAO() {
    }

    //Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o banco de dados
    private Statement stmt = null;
    
    
    /**
     * Método utilizado para inserir um objeto donoDTO no banco de dados
     *
     * @param donoDTO, que vem da classe DonoCTR
     * @return Um boolean
     */
    public boolean inserirDono(DonoDTO donoDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Instancia o Statement que sera responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Insert into dono (nome_don, cpf_don, tel_don, "
                    + "email_don) values ( "
                    + "'" + donoDTO.getNome_don() + "', "
                    + "'" + donoDTO.getCpf_don()+ "', '"
                    + donoDTO.getTel_don()+ "', "
                    + "'" + donoDTO.getEmail_don()+ "') ";
            
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
    }//Fecha o método inserirDono
    
    
    /**
     * Método utilizado para alterar um objeto donoDTO no banco de dados
     *
     * @param donoDTO, que vem da classe DonoCTR
     * @return Um boolean
     */
    public boolean alterarDono(DonoDTO donoDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Update dono set "
                    + "nome_don = '" + donoDTO.getNome_don()+ "', "
                    + "tel_don = '" + donoDTO.getTel_don()+ "', "
                    + "cpf_don = '" + donoDTO.getCpf_don()+ "', "
                    + "email_don = '" + donoDTO.getEmail_don()+ "' "
                    + "where id_don = " + donoDTO.getId_don();
                       
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
    }//Fecha o método alterarDono
    
    
    /**
     * Método utilizado para excluir um objeto donoDTO no banco de dados
     *
     * @param donoDTO que vem da classe DonoCTR
     * @return Um boolean
     */
    public boolean excluirDono(DonoDTO donoDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Instancia o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Delete from dono where id_don = " 
                             + donoDTO.getId_don();

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
    }//Fecha o método excluirDono
    
        
    
    /**
     * Método utilizado para consultar um objeto donoDTO no banco de dados
     *
     * @param donoDTO, que vem da classe DonoCTR
     * @param opcao, que vem da classe DonoCTR
     * @return Um ResultSet com os dados do dono
     */
    public ResultSet consultarDono(DonoDTO donoDTO, int opcao) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "";
            switch (opcao){
                case 1:
                    comando = "Select c.* "+
                              "from dono c "+
                              "where nome_don like '" + donoDTO.getNome_don()+ "%' " +
                              "order by c.nome_don";    
                break;
                case 2:
                    comando = "Select c.* "+
                              "from dono c " +
                              "where c.id_don = " + donoDTO.getId_don();
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
    }//Fecha o método consultarDono
   
    
    
    
}//Fecha classe DonoDAO
