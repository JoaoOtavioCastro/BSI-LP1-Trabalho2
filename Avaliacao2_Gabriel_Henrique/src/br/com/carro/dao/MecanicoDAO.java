package br.com.carro.dao;

import java.sql.*;
import br.com.carro.dto.MecanicoDTO;

public class MecanicoDAO {
    
    /**
     * Método construtor da classe
     */
    public MecanicoDAO() {
    }

    //Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o banco de dados
    private Statement stmt = null;
    
    
    /**
     * Método utilizado para inserir um objeto mecanicoDTO no banco de dados
     *
     * @param mecanicoDTO, que vem da classe MecanicoCTR
     * @return Um boolean
     */
    public boolean inserirMecanico(MecanicoDTO mecanicoDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Instancia o Statement que sera responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Insert into mecanico (nome_mec, cpf_mec, tel_mec "
                    + ") values ( "
                    + "'" + mecanicoDTO.getNome_mec() + "', "
                    + "'" + mecanicoDTO.getCpf_mec()+ "', '"
                    + mecanicoDTO.getTel_mec()+ "') ";
            
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
    }//Fecha o método inserirMecanico
    
    
    /**
     * Método utilizado para alterar um objeto mecanicoDTO no banco de dados
     *
     * @param mecanicoDTO, que vem da classe MecanicoCTR
     * @return Um boolean
     */
    public boolean alterarMecanico(MecanicoDTO mecanicoDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Update mecanico set "
                    + "nome_mec = '" + mecanicoDTO.getNome_mec()+ "', "
                    + "tel_mec = '" + mecanicoDTO.getTel_mec()+ "', "
                    + "cpf_mec = '" + mecanicoDTO.getCpf_mec()+ "' "
                    + "where id_mec = " + mecanicoDTO.getId_mec();
                       
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
    }//Fecha o método alterarMecanico
    
    
    /**
     * Método utilizado para excluir um objeto mecanicoDTO no banco de dados
     *
     * @param mecanicoDTO que vem da classe MecanicoCTR
     * @return Um boolean
     */
    public boolean excluirMecanico(MecanicoDTO mecanicoDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Instancia o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Delete from mecanico where id_mec = " 
                             + mecanicoDTO.getId_mec();

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
    }//Fecha o método excluirMecanico
    
        
    
    /**
     * Método utilizado para consultar um objeto mecanicoDTO no banco de dados
     *
     * @param mecanicoDTO, que vem da classe MecanicoCTR
     * @param opcao, que vem da classe MecanicoCTR
     * @return Um ResultSet com os dados do mecanico
     */
    public ResultSet consultarMecanico(MecanicoDTO mecanicoDTO, int opcao) {
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
                              "from mecanico c "+
                              "where nome_mec like '" + mecanicoDTO.getNome_mec()+ "%' " +
                              "order by c.nome_mec";    
                break;
                case 2:
                    comando = "Select c.* "+
                              "from mecanico c " +
                              "where c.id_mec = " + mecanicoDTO.getId_mec();
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
    }//Fecha o método consultarMecanico
   
    
    
    
}//Fecha classe MecanicoDAO
