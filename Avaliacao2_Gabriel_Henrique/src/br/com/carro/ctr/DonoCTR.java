package br.com.carro.ctr;

import java.sql.ResultSet;
import br.com.carro.dto.DonoDTO;
import br.com.carro.dao.DonoDAO;
import br.com.carro.dao.ConexaoDAO;


public class DonoCTR {
    
    DonoDAO donoDAO = new DonoDAO();

    /**
     * Método construtor da classe
     */
    public DonoCTR() {
    }
    
    /**
     * Método utilizado para controlar o acesso ao método inserirDono da
     * classe DonoAO
     *
     * @param donoDTO, que vem da classe da página (VIEW) 
     * @return String contendo a mensagem
     */
    public String inserirDono(DonoDTO donoDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (donoDAO.inserirDono(donoDTO)) {
                return "Dono Cadastrado com Sucesso!!!";
            } else {
                return "Dono NÃO Cadastrado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Dono NÃO Cadastrado";
        }
    }//Fecha o método inserirDono
    
    
    /**
     * Método utilizado para controlar o acesso ao método alterarDono da
     * classe DonoDAO
     *
     * @param donoDTO, que vem da classe da página (VIEW) 
     * @return String contendo a mensagem
     */
    public String alterarDono(DonoDTO donoDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (donoDAO.alterarDono(donoDTO)) {
                return "Dono Alterado com Sucesso!!!";
            } else {
                return "Dono NÃO Alterado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Dono NÃO Alterado!!!";
        }
    }//Fecha o método alterarDono

    
    /**
     * Método utilizado para controlar o acesso ao método excluirDono da
     * classe DonoDAO
     *
     * @param donoDTO que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String excluirDono(DonoDTO donoDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (donoDAO.excluirDono(donoDTO)) {
                return "Dono Excluído com Sucesso!!!";
            } else {
                return "Dono NÃO Excluído!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no 
          //console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Dono NÃO Excluído!!!";
        }
    }//Fecha o método excluirDono

    
    /**
     * Método utilizado para controlar o acesso ao método consultarDono da
     * classe DonoDAO
     *
     * @param donoDTO que vem da classe da página (VIEW)
     * @param opcao que vem da classe da página (VIEW)
     * @return ResultSet com os dados do dono
     */
    public ResultSet consultarDono(DonoDTO donoDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;
        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = donoDAO.consultarDono(donoDTO, opcao);
        return rs;
    }//Fecha o método consultarDono
    
    
    /**
     * Método utilizado para fechar o banco de dados
     */
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB
    
}//Fecha classe DonoCTR
