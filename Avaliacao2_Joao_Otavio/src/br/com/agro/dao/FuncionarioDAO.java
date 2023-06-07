/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agro.dao;

import br.com.agro.dto.FuncionarioDTO;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author jotav
 */
public class FuncionarioDAO {

    public FuncionarioDAO() {
    }

    private ResultSet rs = null;
    private Statement stmt = null;

    public boolean inserirFuncionario(FuncionarioDTO fdto) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Insert into funcionario (nome_fun, cpf_fun, "
                    + "login, senha_fun, tipo_fun) values ("
                    + "'" + fdto.getNome_fun() + "', '" + fdto.getCpf_fun() + "', "
                    + "'" + fdto.getLogin_fun() + "', '" + criptografar(fdto.getSenha_fun())
                    + "', " + fdto.isTipo_fun() + ")";
            stmt.execute(comando);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    public boolean alterarFuncionario(FuncionarioDTO fdto) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            comando = "update funcionario set nome_fun = '" + fdto.getNome_fun() + "', "
                    + "cpf_fun = '" + fdto.getCpf_fun() + "', login = '" + fdto.getLogin_fun() + "', ";
            if (fdto.getSenha_fun() != null) {
                comando += "senha_fun = '" + criptografar(fdto.getSenha_fun()) + "', ";
            }
            comando += "tipo_fun = " + fdto.isTipo_fun() + " where id_fun = " + fdto.getId_fun();
            stmt.execute(comando);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    public boolean excluirFuncionario(FuncionarioDTO fdto) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Delete from funcionario where id_fun = " + fdto.getId_fun();
            stmt.execute(comando);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    public ResultSet consultarFuncionario(FuncionarioDTO fdto, int opc) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            switch (opc) {
                case 1:
                    comando = "Select f.* from funcionario f where nome_fun "
                            + "ilike '%" + fdto.getNome_fun() + "%' order by f.nome_fun";
                    break;
                case 2:
                    comando = "select f.* from funcionario f where f.id_fun = "
                            + fdto.getId_fun();
                    break;
            }
            rs = stmt.executeQuery(comando);
            return rs;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return rs;
        }
    }

    public int logarFuncionario(FuncionarioDTO fdto) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Select f.tipo_fun from funcionario f where f.login"
                    + " = '" + fdto.getLogin_fun() + "' and f.senha_fun = '" + criptografar(fdto.getSenha_fun()) + "'";
            rs = null;
            System.out.println(comando);
            rs = stmt.executeQuery(comando);
            if (rs.next()) {
                if (rs.getBoolean("tipo_fun")) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 2;
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return 0;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }
    private static MessageDigest md = null;

    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }
    private static char[] hexCodes(byte[] text){
        char[] hexOutput = new char[text.length*3];
        String hexString;
        for (int i=0;i<text.length;i++){
            hexString = "00" + Integer.toHexString(text[i]);
            hexString.toUpperCase().getChars(hexString.length()-3, hexString.length(), hexOutput, i*3);
        }
        return hexOutput;
    }
    public static String criptografar(String pwd){
        if(md!=null){
            return new String(hexCodes(md.digest(pwd.getBytes())));
        }
        return null;
    }
}
