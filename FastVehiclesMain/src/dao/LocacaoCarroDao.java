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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modelos.Carro;
import modelos.Cartao;
import modelos.Cliente;
import modelos.Locacao;
import modelos.Locadora;

/**
 *
 * @author Isaac
 */
public class LocacaoCarroDao implements Dao<Locacao> {
            
    @Override
    public void save(Locacao locacao) {
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO locacao_carro(idlocadora, idcliente, idcartao, idcarro, data_locacao,"
                        + " data_entrega, valor_total, forma_pagamento, multa) "
                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            stmt.setLong(1, locacao.getLocadora().getId());
            stmt.setLong(2, locacao.getCliente().getId());
            stmt.setLong(3, locacao.getCartao().getId());
            stmt.setLong(4, locacao.getVeiculo().getId());
            stmt.setDate(5, locacao.getDataLocacao());
            stmt.setDate(6, locacao.getDataEntrega());
            stmt.setDouble(7, locacao.getValorTotal());
            stmt.setString(8, locacao.getFormaPagamento());
            stmt.setDouble(9, locacao.getMulta());
            
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
    public void update(Locacao t, String[] tData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Locacao locacao) {
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            PreparedStatement stmt = con.prepareStatement("DELETE FROM locacao_carro WHERE `id` = ?");
            stmt.setLong(1, locacao.getId());
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
    public Locacao get(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Locacao> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Locacao> getAllByCliente(Cliente cliente) {
     List<Locacao> locacoes = new ArrayList<>(10);
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            //adiciona cartoes - add cards
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM `locacao_carro` WHERE `idcliente` = ?");
            stmt.setLong(1, cliente.getId());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                Locacao locacao = new Locacao(); //cria locacao com construtor vazio
                locacao.setId(rs.getLong(1)); //coloca id
                
                locacao.setDataLocacao(rs.getDate(6));
                locacao.setDataEntrega(rs.getDate(7));
                locacao.setValorTotal(rs.getDouble(8));
                locacao.setFormaPagamento(rs.getString(9));
                locacao.setMulta(rs.getDouble(10));
                locacao.setVeiculo(InstanceDao.CARRO_DAO.get(rs.getLong(5)));
                locacao.setLocadora(InstanceDao.LOCADORA_DAO.get(rs.getLong(2)));
                locacao.setCartao(InstanceDao.CARTAO_DAO.get(rs.getLong(4)));
                locacao.setCliente(InstanceDao.CLIENTE_DAO.get(rs.getLong(3))); //add cliente

                locacoes.add(locacao);

            }
                
       
            
            //fecha conexoes - close connections
            rs.close();
            stmt.close();
            con.close();
        }catch(SQLException e) {
                System.err.println("ERROR:\n" + e);
                e.printStackTrace();
        }

        return locacoes;
    }
    
    public void deleteAllByCliente(long clienteId) {
         try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            //adiciona cartoes - add cards
            PreparedStatement stmt = con.prepareStatement(
                "DELETE FROM `locacao_carro` WHERE `idcliente` = ?");
            stmt.setLong(1, clienteId);
            stmt.executeUpdate();
            
            //fecha conexoes - close connections
            stmt.close();
            con.close();
        }catch(SQLException e) {
                System.err.println("ERROR:\n" + e);
                e.printStackTrace();
        }

    }
    
    public List<Locacao> getAllByLocadora(Locadora locadora) {
        List<Locacao> locacoes = new ArrayList<>(10);
        
        try {
            Connection con = DriverManager.getConnection(Bd.URL, Bd.USUARIO, Bd.SENHA);
            //adiciona cartoes - add cards
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM `locacao_carro` WHERE `idlocadora` = ?");
            stmt.setLong(1, locadora.getId());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                Locacao locacao = new Locacao(); //cria locacao com construtor vazio
                locacao.setId(rs.getLong(1)); //coloca id
                locacao.setDataLocacao(rs.getDate(6));
                locacao.setDataEntrega(rs.getDate(7));
                locacao.setValorTotal(rs.getDouble(8));
                locacao.setFormaPagamento(rs.getString(9));
                locacao.setMulta(rs.getDouble(10));
                locacao.setVeiculo(InstanceDao.CARRO_DAO.get(rs.getLong(5)));
                locacao.setLocadora(InstanceDao.LOCADORA_DAO.get(rs.getLong(2)));
                locacao.setCartao(InstanceDao.CARTAO_DAO.get(rs.getLong(4)));
                locacao.setCliente(InstanceDao.CLIENTE_DAO.get(rs.getLong(3))); //add cliente

                
                locacoes.add(locacao);

            }
            
            //fecha conexoes - close connections
            rs.close();
            stmt.close();
            con.close();
        }catch(SQLException e) {
                System.err.println("ERROR:\n" + e);
                e.printStackTrace();
        }

        return locacoes;
    }
    
    
}
