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
import java.sql.Types;
import modelos.Carro;
import modelos.Cliente;
import modelos.Locadora;

/**
 *
 * @author Isaac
 */
public class CarroDao implements Dao<Carro>{
        
    @Override
    public Carro get(long id) {
        Carro carro = null;
        
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM `carro` WHERE `id`= ?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                carro = new Carro(rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9),
                        rs.getLong(10), rs.getString(11), rs.getDouble(12),rs.getDouble(13),
                        rs.getString(14), rs.getInt(15), rs.getInt(16), 
                        InstanceDao.LOCADORA_DAO.get(rs.getLong(3)));
                carro.setId(rs.getLong(1)); //coloca id
            }
            //fecha conexoes - close connections
            rs.close();
            stmt.close();
            con.close();
          }catch(SQLException e) {
                  System.err.println("ERROR:\n" + e);
                  e.printStackTrace();
          }
        
        return carro;
    }

    @Override
    public List<Carro> getAll() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       return null;
    }

    @Override
    public void save(Carro carro) {
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO carro(idcliente, idlocadora, tipo, marca, modelo, cor, combustivel, ano, quilometragem,"
                        + " placa, caucao, valor_diario, motor, cavalos, portas)"
                    + " VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setNull(1, Types.NULL);
            stmt.setLong(2, carro.getLocadora().getId());
            stmt.setString(3, carro.getTipo());
            stmt.setString(4, carro.getMarca());
            stmt.setString(5, carro.getModelo());
            stmt.setString(6, carro.getCor());
            stmt.setString(7, carro.getCombustivel());
            stmt.setInt(8, carro.getAno());
            stmt.setLong(9, carro.getQuilometragem());
            stmt.setString(10, carro.getPlaca());
            stmt.setDouble(11, carro.getCaucao());
            stmt.setDouble(12, carro.getValorDiario());
            stmt.setString(13, carro.getMotor());
            stmt.setInt(14, carro.getCavalos());
            stmt.setInt(15, carro.getPortas());
            
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
    public void update(Carro carro, String[] Data) {
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt = con.prepareStatement(
                "UPDATE `carro` \n" +
                    "SET \n" +
                    "`tipo` = ?, \n" +
                    "`marca` = ?,\n" +
                    "`modelo` = ?,\n" +
                    "`cor` = ?,\n" +
                    "`combustivel` = ?,\n" +
                    "`ano` = ?,\n" +
                    "`quilometragem` = ?,\n" +
                    "`placa` = ?,\n" +
                    "`caucao` = ?,\n" +
                    "`valor_diario` = ?,\n" +
                    "`motor` = ?, \n" +
                    "`cavalos` = ?,  \n" +
                    "`portas` = ?\n" +
                    "WHERE `id` = ?");
            
            stmt.setString(1, carro.getTipo());
            stmt.setString(2, carro.getMarca());
            stmt.setString(3, carro.getModelo());
            stmt.setString(4, carro.getCor());
            stmt.setString(5, carro.getCombustivel());
            stmt.setInt(6, carro.getAno());
            stmt.setLong(7, carro.getQuilometragem());
            stmt.setString(8, carro.getPlaca());
            stmt.setDouble(9, carro.getCaucao());
            stmt.setDouble(10, carro.getValorDiario());
            stmt.setString(11, carro.getMotor());
            stmt.setInt(12, carro.getCavalos());
            stmt.setInt(13, carro.getPortas());
            stmt.setLong(14, carro.getId());
            
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
    public void delete(Carro t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public List<Carro> getAllByLocadora(Locadora locadora) { //pega todos os carros pela locadora, exige que a locadora esteja atualizada
        List<Carro> carros = new ArrayList<>(5);
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM `carro` WHERE `idlocadora` = ?");
            stmt.setLong(1, locadora.getId());
            ResultSet rs = stmt.executeQuery();
                        
            while(rs.next()) {
                //cria moto e add para motos
                Carro carro = new Carro(rs.getString(4), rs.getString(5),
                    rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9),
                    rs.getLong(10), rs.getString(11), rs.getDouble(12),rs.getDouble(13),
                    rs.getString(14), rs.getInt(15), rs.getInt(16), locadora);
                carro.setId(rs.getLong(1)); //coloca id
                
                for(Cliente cliente: locadora.getClientes()) { //percorre lista de clientes
                    if(cliente.getId() == rs.getLong(2)) { // se id igual ao id coletado do bd
                        carro.setCliente(cliente); //set cliente
                    }
                }
                
                carros.add(carro);               
            }


            //fecha conexoes - close connections
            rs.close();
            stmt.close();
            con.close();
          }catch(SQLException e) {
                  System.err.println("ERROR:\n" + e);
                  e.printStackTrace();
          }

          return carros;
    }
    
    
    public void updateCliente(Carro carro, Cliente cliente) {
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt = con.prepareStatement(
                "UPDATE `carro` SET `idcliente` = ? WHERE `id` = ?");
            
            if(cliente != null) { //se o cliente n eh null - se cliente is not null
                stmt.setLong(1, cliente.getId());
            }else { //se null - if null
                stmt.setNull(1, Types.NULL);
            }
            stmt.setLong(2, carro.getId()); //coloca id do carro
            stmt.executeUpdate();
    
            //fecha conexoes - close connections
            stmt.close();
            con.close();
        }catch(SQLException e) {
                System.err.println("ERROR:\n" + e);
                e.printStackTrace();
        }
    }
                        
}
