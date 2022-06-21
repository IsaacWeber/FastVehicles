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
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelos.Carro;
import modelos.Cartao;
import modelos.Cliente;
import modelos.Locadora;
import modelos.Moto;

/**
 *
 * @author Isaac
 */
public class MotoDao implements Dao<Moto> {
    
    @Override
    public Moto get(long id) {
        Moto moto = null;
        
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM `moto` WHERE `id`= ?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next() ) {
                moto = new Moto(rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9),
                        rs.getLong(10), rs.getString(11), rs.getDouble(12),rs.getDouble(13),
                        rs.getString(14), rs.getInt(15),  InstanceDao.LOCADORA_DAO.get(rs.getLong(3)));
                moto.setId(rs.getLong(1)); //coloca id
            }
            //fecha conexoes - close connections
            rs.close();
            stmt.close();
            con.close();
          }catch(SQLException e) {
                  System.err.println("ERROR:\n" + e);
                  e.printStackTrace();
          }
        
        return moto;

    }

    @Override
    public List<Moto> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Moto moto) {
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO moto(idcliente, idlocadora, tipo, marca, modelo, cor, combustivel, ano, quilometragem,"
                        + " placa, caucao, valor_diario, motor, cilindradas)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            stmt.setNull(1, Types.NULL);
            stmt.setLong(2, moto.getLocadora().getId());
            stmt.setString(3, moto.getTipo());
            stmt.setString(4, moto.getMarca());
            stmt.setString(5, moto.getModelo());
            stmt.setString(6, moto.getCor());
            stmt.setString(7, moto.getCombustivel());
            stmt.setInt(8, moto.getAno());
            stmt.setLong(9, moto.getQuilometragem());
            stmt.setString(10, moto.getPlaca());
            stmt.setDouble(11, moto.getCaucao());
            stmt.setDouble(12, moto.getValorDiario());
            stmt.setString(13, moto.getMotor());
            stmt.setInt(14, moto.getCilindradas());
            
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
    public void update(Moto moto, String[] tData) {
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt = con.prepareStatement(
                "UPDATE `moto` \n" +
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
                    "`cilindradas` = ?  \n" +
                    "WHERE `id` = ?");
            
            stmt.setString(1, moto.getTipo());
            stmt.setString(2, moto.getMarca());
            stmt.setString(3, moto.getModelo());
            stmt.setString(4, moto.getCor());
            stmt.setString(5, moto.getCombustivel());
            stmt.setInt(6, moto.getAno());
            stmt.setLong(7, moto.getQuilometragem());
            stmt.setString(8, moto.getPlaca());
            stmt.setDouble(9, moto.getCaucao());
            stmt.setDouble(10, moto.getValorDiario());
            stmt.setString(11, moto.getMotor());
            stmt.setInt(12, moto.getCilindradas());
            stmt.setLong(13, moto.getId());
            
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
    public void delete(Moto t) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Moto> getAllByLocadora(Locadora locadora) { //pega todos os carros pela locadora, exige que a locadora esteja atualizada
        List<Moto> motos = new ArrayList<>(5);
        
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM `moto` WHERE `idlocadora` = ?");
            stmt.setLong(1, locadora.getId());
            ResultSet rs = stmt.executeQuery();
           
            while(rs.next()) {
                //cria moto e add para motos
                Moto mt = new Moto(rs.getString(4), rs.getString(5),
                    rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9),
                    rs.getLong(10), rs.getString(11), rs.getDouble(12),rs.getDouble(13),
                    rs.getString(14), rs.getInt(15), locadora);
                mt.setId(rs.getLong(1));//coloca id 
                                
                for(Cliente cliente: locadora.getClientes()) { //percorre lista de clientes
                    if(cliente.getId() == rs.getLong(2)) { // se id igual ao id coletado do bd
                        mt.setCliente(cliente); //set cliente
                    }
                }
                
                motos.add(mt);               
            }


            //fecha conexoes - close connections
            rs.close();
            stmt.close();
            con.close();
          }catch(SQLException e) {
                  System.err.println("ERROR:\n" + e);
                  e.printStackTrace();
          }

          return motos;
    }
    
    public void updateCliente(Moto moto, Cliente cliente) {
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt = con.prepareStatement(
                "UPDATE `moto` SET `idcliente` = ? WHERE `id` = ?");
            
            if(cliente != null) { //se o cliente n eh null - se cliente is not null
                stmt.setLong(1, cliente.getId());
            }else { //se null - if null
                stmt.setNull(1, Types.NULL);
            }
            stmt.setLong(2, moto.getId());
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
