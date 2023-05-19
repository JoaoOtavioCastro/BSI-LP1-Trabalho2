package br.com.carro.ctr;

import java.sql.ResultSet;
import br.com.carro.dto.MecanicoDTO;
import br.com.carro.dao.MecanicoDAO;
import br.com.carro.dao.ConexaoDAO;


public class MecanicoCTR {
    
    MecanicoDAO mecanicoDAO = new MecanicoDAO();

    /**
     * Método construtor da classe
     */
    public MecanicoCTR() {
    }
    
    /**
     * Método utilizado para controlar o acesso ao método inserirMecanico da
     * classe MecanicoAO
     *
     * @param mecanicoDTO, que vem da classe da página (VIEW) 
     * @return String contendo a mensagem
     */
    public String inserirMecanico(MecanicoDTO mecanicoDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (mecanicoDAO.inserirMecanico(mecanicoDTO)) {
                return "Mecanico Cadastrado com Sucesso!!!";
            } else {
                return "Mecanico NÃO Cadastrado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Mecanico NÃO Cadastrado";
        }
    }//Fecha o método inserirMecanico
    
    
    /**
     * Método utilizado para controlar o acesso ao método alterarMecanico da
     * classe MecanicoDAO
     *
     * @param mecanicoDTO, que vem da classe da página (VIEW) 
     * @return String contendo a mensagem
     */
    public String alterarMecanico(MecanicoDTO mecanicoDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (mecanicoDAO.alterarMecanico(mecanicoDTO)) {
                return "Mecanico Alterado com Sucesso!!!";
            } else {
                return "Mecanico NÃO Alterado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Mecanico NÃO Alterado!!!";
        }
    }//Fecha o método alterarMecanico

    
    /**
     * Método utilizado para controlar o acesso ao método excluirMecanico da
     * classe MecanicoDAO
     *
     * @param mecanicoDTO que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String excluirMecanico(MecanicoDTO mecanicoDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (mecanicoDAO.excluirMecanico(mecanicoDTO)) {
                return "Mecanico Excluído com Sucesso!!!";
            } else {
                return "Mecanico NÃO Excluído!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Mecanico NÃO Excluído!!!";
        }
    }//Fecha o método excluirMecanico

    
    /**
     * Método utilizado para controlar o acesso ao método consultarMecanico da
     * classe MecanicoDAO
     *
     * @param mecanicoDTO que vem da classe da página (VIEW)
     * @param opcao que vem da classe da página (VIEW)
     * @return ResultSet com os dados do mecanico
     */
    public ResultSet consultarMecanico(MecanicoDTO mecanicoDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;
        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = mecanicoDAO.consultarMecanico(mecanicoDTO, opcao);
        return rs;
    }//Fecha o método consultarMecanico
    
    
    /**
     * Método utilizado para fechar o banco de dados
     */
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB
    
}//Fecha classe MecanicoCTR
