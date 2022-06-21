/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bd.Bd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.Cliente;
import modelos.Locadora;

/**
 *
 * @author Isaac
 */
public class LocadoraDao implements Dao<Locadora> {

    @Override
    public Locadora get(long id) {
        Locadora loc = null;
        
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `locadora` WHERE `id` = ?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {

                loc = new Locadora(rs.getString(2),
                     rs.getString(3),  rs.getString(4),  rs.getString(5),
                     rs.getString(6),  rs.getString(7));

                loc.setId(rs.getLong(1));
                loc.setClientes(InstanceDao.CLIENTE_DAO.getAllByLocadora(loc));
                loc.getVeiculos().addAll(InstanceDao.CARRO_DAO.getAllByLocadora(loc));
                loc.getVeiculos().addAll(InstanceDao.MOTO_DAO.getAllByLocadora(loc));             
            }
            
            //fecha conexoes - close connections
            rs.close();
            stmt.close();
            con.close();
        }catch(SQLException e) {
            System.err.println("ERROR:\n" + e);
            e.printStackTrace();
        }

      return loc;
    }

    @Override
    public List<Locadora> getAll() {
        List<Locadora> locadoras = new ArrayList<>(10);
        
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `locadora`");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {

                Locadora loc = new Locadora(rs.getString(2),
                     rs.getString(3),  rs.getString(4),  rs.getString(5),
                     rs.getString(6),  rs.getString(7));
                loc.setId(rs.getLong(1));
            loc.setClientes(InstanceDao.CLIENTE_DAO.getAllByLocadora(loc));
            loc.getVeiculos().addAll(InstanceDao.CARRO_DAO.getAllByLocadora(loc));
            loc.getVeiculos().addAll(InstanceDao.MOTO_DAO.getAllByLocadora(loc));             
 
            
                //pega motos, carros e clientes para add na locadora
                locadoras.add(loc);               
            }     
            
            //fecha conexoes - close connections
            rs.close();
            stmt.close();
            con.close();
        }catch(SQLException e) {
            System.err.println("ERROR:\n" + e);
            e.printStackTrace();
        }

        return locadoras;
        
        
    }

    @Override
    public void save(Locadora loc) {
         try {
            
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO locadora(nome, telefone, email, endereco, cnpj, senha) VALUES(?, ?, ?, ?, ?, ?)");
            stmt.setString(1, loc.getNome());
            stmt.setString(2, loc.getTelefone());
            stmt.setString(3, loc.getEmail());
            stmt.setString(4, loc.getEndereco());
            stmt.setString(5, loc.getCnpj());
            stmt.setString(6, loc.getSenha());
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
    public void update(Locadora loc, String[] tData) {
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt = con.prepareStatement(
                "UPDATE `locadora` \n" +
                    "SET \n" +
                    "`nome` = ?, \n" +
                    "`telefone` = ?,\n" +
                    "`email` = ?,\n" +
                    "`endereco` = ?,\n" +
                    "`cnpj` = ?\n" +
                    "WHERE `id` = ?");
            
            stmt.setString(1, loc.getNome());
            stmt.setString(2, loc.getTelefone());
            stmt.setString(3, loc.getEmail());
            stmt.setString(4, loc.getEndereco());
            stmt.setString(5, loc.getCnpj());
            stmt.setLong(6, loc.getId());
            
            stmt.executeUpdate();
            
            //fecha conexoes - close connections
            stmt.close();
            con.close();
        }catch(SQLException e) {
            System.err.println("ERROR:\n" + e);
            e.printStackTrace();
        }


    }

    @Override
    public void delete(Locadora t) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void deleteCliente(long id) { //deleta cliente da locadora - delete client from locadora
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt = con.prepareStatement("DELETE FROM `cliente_locadora` WHERE `idcliente` = ?");
            stmt.setLong(1, id);
            stmt.executeUpdate();
            
            stmt.close();
            con.close();
        }catch(SQLException e) {
            System.err.println("ERROR:\n" + e);
            e.printStackTrace();
        }
        
    }
    
    public void addCliente(Locadora locadora, Cliente cliente) { //add cliente a a locadora - add client to locator
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt = con.prepareStatement("INSERT INTO cliente_locadora(idcliente, idlocadora) VALUES(?, ?)");
            stmt.setLong(1, cliente.getId());
            stmt.setLong(2, locadora.getId());
            stmt.executeUpdate();
            
            stmt.close();
            con.close();
        }catch(SQLException e) {
            System.err.println("ERROR:\n" + e);
            e.printStackTrace();
        }
        
    }
    
    
    public void deleteCarro(long id) { //deleta carro da locadora - delete car from locadora
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt1 = con.prepareStatement("DELETE FROM `locacao_carro` WHERE `idcarro` = ?"); //se houver
            stmt1.setLong(1, id);
            stmt1.executeUpdate();
            
            PreparedStatement stmt2 = con.prepareStatement("DELETE FROM `carro` WHERE `id` = ?"); //deleta o carro
            stmt2.setLong(1, id);
            stmt2.executeUpdate();
            
            stmt1.close();
            stmt2.close();
            con.close();
        }catch(SQLException e) {
            System.err.println("ERROR:\n" + e);
            e.printStackTrace();
        }
        
    }
    
    public void deleteMoto(long id) { //deleta moto da locadora - delete bike from locadora
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt1 = con.prepareStatement("DELETE FROM `locacao_moto` WHERE `idmoto` = ?"); //se houver
            stmt1.setLong(1, id);
            stmt1.executeUpdate();
            
            PreparedStatement stmt2 = con.prepareStatement("DELETE FROM `moto` WHERE `id` = ?");
            stmt2.setLong(1, id);
            stmt2.executeUpdate();
            
            stmt1.close();
            stmt2.close();
            con.close();
           
        }catch(SQLException e) {
            System.err.println("ERROR:\n" + e);
            e.printStackTrace();
        }
        
    }

        
    public long getClientCount(long idLocadora) {
        long count = 0;
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt = con.prepareStatement(
                "SELECT COUNT(*) FROM `cliente_locadora` WHERE `idlocadora` = ?");
            stmt.setLong(1, idLocadora);
            ResultSet rs = stmt.executeQuery();
            
            rs.next();
            count = rs.getLong(1);
        }catch(SQLException e) {
            System.err.println("ERROR:\n" + e);
            e.printStackTrace();
        }
        
        return count;  
    }
    
    public List<Locadora> getLocadorasByCliente(Cliente cliente) {
        List<Locadora> locadoras = new ArrayList<>(10);
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            //adiciona cartoes - add cards
            PreparedStatement stmt = con.prepareStatement("SELECT `idlocadora` FROM `cliente_locadora` WHERE `idcliente` = ?");
            stmt.setLong(1, cliente.getId());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) { //there is just 1 locator for a client
                stmt = con.prepareStatement("SELECT * FROM `locadora` WHERE `id` = ?");
                stmt.setLong(1, rs.getLong(1));
                ResultSet rs2 = stmt.executeQuery();
            
                while(rs2.next()) {

                    Locadora locadora = new Locadora(
                        rs2.getString(2), rs2.getString(3),
                        rs2.getString(4), rs2.getString(5), rs2.getString(6),
                        rs2.getString(7));
                    
                    locadora.setId(rs.getLong(1));
                    //System.out.println(locadora);
                    locadoras.add(locadora);

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

        return locadoras;
        
    }
    
}
