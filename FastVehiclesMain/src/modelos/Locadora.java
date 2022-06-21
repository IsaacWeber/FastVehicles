/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Isaac
 */
public class Locadora extends Entidade {
    private String cnpj;
    private List<Cliente> clientes;
    private List<Veiculo> veiculos;
    private List<Locacao> locacoes;
    
    public Locadora() {
        clientes = new ArrayList<>(5);
        veiculos = new ArrayList<>(5);
        locacoes = new ArrayList<>(5);
    }
    
    //construtor sem lista de clientes - constructor without a list of clients
    public Locadora(String nome, String telefone,
            String email, String endereco, String cnpj, String senha) {
        super(nome, telefone, email, endereco, senha);
        this.cnpj = cnpj;
        
        clientes = new ArrayList<>(5);
        veiculos = new ArrayList<>(5);  
        locacoes = new ArrayList<>(5);
    }
    //construtor com lista de clientes e de veiculos - constructor with a list of clients and vehicles
    public Locadora(String nome, String telefone,
            String email, String endereco, String cnpj, String senha,
            List<Cliente> clientes, List<Veiculo> veiculos) {
        super(nome, telefone, email, endereco, senha);
        this.cnpj = cnpj;
        this.clientes = clientes;
        this.veiculos = veiculos;
        locacoes = new ArrayList<>(5);
    }

    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(List<Locacao> locacoes) {
        this.locacoes = locacoes;
    }
    
    @Override
    public String toString() {
        return "Locadora{" + "cnpj=" + cnpj + '}';
    }
    

    

}
