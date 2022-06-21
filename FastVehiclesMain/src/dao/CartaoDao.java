/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bd.Bd;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.Cartao;
import modelos.Cliente;

/**
 *
 * @author Isaac
 */
public class CartaoDao implements Dao<Cartao> {
    
    @Override
    public Cartao get(long id) {
        Cartao cartao = null;
        
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `cartao` WHERE `id` = ?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                //adiciona somente dados do cliente - add just client data
                cartao = new Cartao(
                    rs.getString(2), rs.getString(4), rs.getString(5),
                    rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9));
                
                cartao.setId(rs.getLong(1)); //coloca id             
            }
            
            
            //fecha conexoes - close connections
            rs.close();
            stmt.close();
            con.close();
        }catch(SQLException e) {
                System.err.println("ERROR:\n" + e);
                e.printStackTrace();
        }

        return cartao;
    }

    @Override
    public List<Cartao> getAll() {
        List<Cartao> cartoes = new ArrayList<>(10);
        
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `cartao`");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                //adiciona somente dados do cliente - add just client data
                Cartao cartao = new Cartao(
                    rs.getString(2), rs.getString(4), rs.getString(5),
                    rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9));
                
                cartao.setId(rs.getLong(1)); //coloca id
                cartoes.add(cartao);               
            }
            
            
            //fecha conexoes - close connections
            rs.close();
            stmt.close();
            con.close();
        }catch(SQLException e) {
                System.err.println("ERROR:\n" + e);
                e.printStackTrace();
        }

        return cartoes;
    }
    
    @Override
    public void save(Cartao cartao) {
        try {
            
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO cartao(numero, idcliente, nome_titular, banco, validade, cvc, funcao, bandeira) "
                    + "values(?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setLong(1, Long.parseLong(cartao.getNumero()));
            stmt.setLong(2, cartao.getCliente().getId());
            stmt.setString(3, cartao.getNomeTitular());
            stmt.setString(4, cartao.getBanco());
            stmt.setString(5, cartao.getValidade());
            stmt.setInt(6, cartao.getCvc());
            stmt.setString(7, cartao.getFuncao());
            stmt.setString(8, cartao.getBandeira());
            stmt.executeUpdate();

            stmt.close();
            con.close();
        }catch(SQLException e) {
            System.err.println("ERROR:\n" + e);
            JOptionPane.showMessageDialog(null, "Erro ao salvar cartao\n" + e.getMessage(), 
                    "ERRO BD", JOptionPane.ERROR_MESSAGE);
        }
	
    }

    @Override
    public void update(Cartao t, String[] tData) {
      
    }

    @Override
    public void delete(Cartao cartao) {
        try {
            
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt = con.prepareStatement(
                "DELETE FROM `cartao` WHERE `id` = ?");
            stmt.setLong(1, cartao.getId()); //insere id para delecao - insert id to delete card
            stmt.executeUpdate();

            stmt.close();
            con.close();
        }catch(SQLException e) {
            System.err.println("ERROR:\n" + e);
            JOptionPane.showMessageDialog(null, "Erro ao deletar cartao\n" + e.getMessage(), 
                    "ERRO BD", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public List<Cartao> getCardsByCliente(Cliente cliente) {
        List<Cartao> cartoes = new ArrayList<>(10);
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            //adiciona cartoes - add cards
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `cartao` WHERE `idcliente` = ?");
            stmt.setLong(1, cliente.getId());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                Cartao cartao = new Cartao( rs.getString(2), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), cliente);
                cartao.setId(rs.getLong(1));
               //System.out.println(cartao);
                cartoes.add(cartao);

            }
                
       
            
            //fecha conexoes - close connections
            rs.close();
            stmt.close();
            con.close();
        }catch(SQLException e) {
                System.err.println("ERROR:\n" + e);
                e.printStackTrace();
        }

        return cartoes;
        
    }
    
    
}
