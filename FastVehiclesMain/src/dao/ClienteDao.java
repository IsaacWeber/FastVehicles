/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.ArrayList;
import modelos.Cliente;
import bd.Bd;
import javax.swing.JOptionPane;
import modelos.Cartao;
import modelos.Locadora;

/**
 *
 * @author Isaac
 */
public class ClienteDao implements Dao<Cliente> {
    
    @Override
    public Cliente get(long id) {
        Cliente cliente = null;
        
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `cliente` WHERE `id` = ?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                //adiciona somente dados do cliente - add just client data
                cliente = new Cliente(
                    rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getString(6),
                    rs.getString(7), rs.getString(8), rs.getString(9));
                cliente.setId(rs.getLong(1)); //coloca id
                
                cliente.setCartoes(InstanceDao.CARTAO_DAO.getCardsByCliente(cliente));
                cliente.setLocadoras(InstanceDao.LOCADORA_DAO.getLocadorasByCliente(cliente));
                
            }
            
            //fecha conexoes - close connections
            rs.close();
            stmt.close();
            con.close();
        }catch(SQLException e) {
                System.err.println("ERROR:\n" + e);
                e.printStackTrace();
        }

        return cliente;
    }

    @Override
    public List<Cliente> getAll() {
        List<Cliente> clientes = new ArrayList<>(10);
        

        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `cliente`");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                //adiciona somente dados do cliente - add just client data
                Cliente cliente = new Cliente(
                    rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getString(6),
                    rs.getString(7), rs.getString(8), rs.getString(9));
                cliente.setId(rs.getLong(1)); //coloca id
                
                cliente.setCartoes(InstanceDao.CARTAO_DAO.getCardsByCliente(cliente));
                cliente.setLocadoras(InstanceDao.LOCADORA_DAO.getLocadorasByCliente(cliente));

                clientes.add(cliente);
                
            }
            
            
            //fecha conexoes - close connections
            rs.close();
            stmt.close();
            con.close();
        }catch(SQLException e) {
                System.err.println("ERROR:\n" + e);
                e.printStackTrace();
        }

        return clientes;
    }
    
        
    public List<Cliente> getAllByLocadora(Locadora locadora) { 
        List<Cliente> clientes = new ArrayList<>(10);
        
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            //adiciona cartoes - add cards
            PreparedStatement stmt = con.prepareStatement("SELECT `idcliente` FROM `cliente_locadora` WHERE `idlocadora` = ?");
            stmt.setLong(1, locadora.getId());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) { //there is just 1 locator for a client
                
                stmt = con.prepareStatement("SELECT * FROM `cliente` WHERE `id` = ?");
                stmt.setLong(1, rs.getLong(1));
                ResultSet rs2 = stmt.executeQuery();
            
                while(rs2.next()) {

                    Cliente cliente = new Cliente(
                        rs2.getString(2), rs2.getString(3),
                        rs2.getString(4), rs2.getString(5), rs2.getString(6),
                        rs2.getString(7), rs2.getString(8), rs2.getString(9));
                    
                    cliente.setId(rs.getLong(1)); //coloca id
                    cliente.setCartoes(InstanceDao.CARTAO_DAO.getCardsByCliente(cliente));
                    cliente.setLocadoras(InstanceDao.LOCADORA_DAO.getLocadorasByCliente(cliente));
                    //System.out.println(locadora);
                    clientes.add(cliente);

                }
            }

            //fecha conexoes - close connections
            rs.close();
            stmt.close();
            con.close();
        }catch(SQLException e) {
                System.err.println("ERROR:\n" + e);
                e.printStackTrace();
        }

        return clientes; 
    }
    
    
    @Override
    public void save(Cliente cliente) {
         try {
            
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO cliente(nome, telefone, email, endereco, rg, cpf, cnh, senha) "
                    + "values(?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getRg());
            stmt.setString(6, cliente.getCpf());
            stmt.setString(7, cliente.getCnh());
            stmt.setString(8, cliente.getSenha());
            stmt.executeUpdate();

            stmt.close();
            con.close();
            
            for(Cartao c: cliente.getCartoes()) { //salva os cartoes do cliente - save all client cards
                InstanceDao.CARTAO_DAO.save(c);
            }
            
        }catch(SQLException e) {
            System.err.println("ERROR:\n" + e);
            JOptionPane.showMessageDialog(null, "Erro ao salvar cliente\n" + e.getMessage(), 
                "ERRO BD", JOptionPane.ERROR_MESSAGE);
        }
	
        
    }

    @Override
    public void update(Cliente t, String[] tData) {
    }

    @Override
    public void delete(Cliente cliente) {
        
    }

    
}
