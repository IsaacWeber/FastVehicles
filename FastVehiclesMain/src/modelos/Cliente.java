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
public class Cliente extends Entidade {
    
    private String rg;
    private String cpf;
    private String cnh;
    
    private List<Locadora> locadoras;
    private List<Cartao> cartoes;
    private List<Locacao> locacoes;
    
    public Cliente() {
        locadoras = new ArrayList<>(5);
        cartoes = new ArrayList<>(5);
        locacoes = new ArrayList<>(5);
    }


    //construtor sem locadora e cartao - constructro without locator and card
    public Cliente(String nome, String telefone, String email, String endereco,
            String rg, String cpf, String cnh, String senha) {
        super(nome, telefone, email, endereco, senha);
        this.rg = rg;
        this.cpf = cpf;
        this.cnh = cnh;
        
        locadoras = new ArrayList<>(5);
        cartoes = new ArrayList<>(5);
        locacoes = new ArrayList<>(5);
    }
    
    //construtor com somente uma locadora - constructor with just one locator
    public Cliente(String nome, String telefone, String email, String endereco,
            String rg, String cpf, String cnh, String senha, Locadora locadora, Cartao cartao) { 
        super(nome, telefone, email, endereco, senha);
        this.rg = rg;
        this.cpf = cpf;
        this.cnh = cnh;
        
        locadoras = new ArrayList<>(5);
        locadoras.add(locadora);
        cartoes = new ArrayList<>(5);
        cartoes.add(cartao);
        locacoes = new ArrayList<>(5);
    }
    
    //construtor com somente uma locadora + lista de cartoes - constructor with just one locator + card list
    public Cliente(String nome, String telefone, String email, String endereco,
            String rg, String cpf, String cnh, String senha, Locadora locadora, List<Cartao> cartoes) { 
        super(nome, telefone, email, endereco, senha);
        this.rg = rg;
        this.cpf = cpf;
        this.cnh = cnh;
        
        locadoras = new ArrayList<>(5);
        locadoras.add(locadora);
        cartoes = new ArrayList<>(5);
        cartoes.addAll(cartoes);
        locacoes = new ArrayList<>(5);
    }
    
    
    //gets e sets
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public List<Locadora> getLocadoras() {
        return locadoras;
    }

    public void setLocadoras(List<Locadora> locadoras) {
        this.locadoras = locadoras;
    }

    public List<Cartao> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<Cartao> cartoes) {
        this.cartoes = cartoes;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(List<Locacao> locacoes) {
        this.locacoes = locacoes;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "rg=" + rg + ", cpf=" + cpf + ", cnh=" + cnh  + '}';
    }
    
    
   
}
