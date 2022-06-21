/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Isaac
 */
public class InstanceDao { //classe para ser usada nos DAOs, para evitar StackOverflows - class to be used in DAOs to avoid StackOverflows
    
    public static final LocadoraDao LOCADORA_DAO = new LocadoraDao();
    public static final ClienteDao CLIENTE_DAO = new ClienteDao();
    public static final CarroDao CARRO_DAO = new CarroDao();
    public static final MotoDao MOTO_DAO = new  MotoDao();
    public static final CartaoDao CARTAO_DAO =  new CartaoDao();
    public static final LocacaoCarroDao LOCACAO_CARRO_DAO = new LocacaoCarroDao();
    public static final LocacaoMotoDao LOCACAO_MOTO_DAO = new LocacaoMotoDao();
    
}
