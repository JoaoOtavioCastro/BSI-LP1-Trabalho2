package br.com.carro.ctr;
/**
 *
 * @author Andre Luis Gobbi Primo/Ivan Oliveira Lopes
 */

import java.sql.ResultSet;
import br.com.carro.dto.DonoDTO;
import br.com.carro.dto.CarroDTO;
import br.com.carro.dao.CarroDAO;
import br.com.carro.dao.ConexaoDAO;

public class CarroCTR {
    
    CarroDAO carroDAO = new CarroDAO();
    
    /**
     * Método construtor da classe
     */
    public CarroCTR() {
    }

    
    
    /**
     * Método utilizado para controlar o acesso ao método inserirCarro da
     * classe CarroDAO
     * @param carroDTO, que vem da classe sa página (VIEW)
     * @param donoDTO, que vem da classe da página (VIEW) 
     * @return String contendo a mensagem
     */
    public String inserirCarro(CarroDTO carroDTO, DonoDTO donoDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (carroDAO.inserirCarro(carroDTO, donoDTO)) {
                return "Carro Cadastrado com Sucesso!!!";
            } else {
                return "Carro NÃO Cadastrado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Carro NÃO Cadastrado";
        }
    }//Fecha o método inserirCarro
    
    
    /**
     * Método utilizado para controlar o acesso ao método alterarCarro da
     * classe CarroDAO
     * @param carroDTO, que vem da classe da página (VIEW)
     * @param donoDTO, que vem da classe da página (VIEW) 
     * @return String contendo a mensagem
     */
    public String alterarCarro(CarroDTO carroDTO, DonoDTO donoDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (carroDAO.alterarCarro(carroDTO, donoDTO)) {
                return "Carro Alterado com Sucesso!!!";
            } else {
                return "Carro NÃO Alterado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Carro NÃO Alterado!!!";
        }
    }//Fecha o método alterarCarro

    
    /**
     * Método utilizado para controlar o acesso ao método excluirCarro da
     * classe CarroDAO
     * @param carroDTO que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String excluirCarro(CarroDTO carroDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (carroDAO.excluirCarro(carroDTO)) {
                return "Carro Excluído com Sucesso!!!";
            } else {
                return "Carro NÃO Excluído!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Carro NÃO Excluído!!!";
        }
    }//Fecha o método excluirCarro

    
    /**
     * Método utilizado para controlar o acesso ao método consultarCarro da
     * classe CarroDAO
     * @param carroDTO que vem da classe da página (VIEW)
     * @param opcao que vem da classe da página (VIEW)
     * @return ResultSet com os dados do carro e dono
     */
    public ResultSet consultarCarro(CarroDTO carroDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;
        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = carroDAO.consultarCarro(carroDTO, opcao);
        return rs;
    }//Fecha o método consultarCarro
    
    
    /**
     * Método utilizado para fechar o banco de dados
     */
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB
    
    
}//Fecha classe CarroCTR
