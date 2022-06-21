/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Isaac
 */
public class Cartao {
    private long id;
    private String numero;
    private String nomeTitular;
    private String banco;
    private String validade;
    private int cvc;
    private String funcao;
    private String bandeira;
    private Cliente cliente;
    
    
    public Cartao() {
        
    }
    public Cartao(String numero, String nomeTitular, String banco, 
            String validade, int cvc, String funcao, String bandeira) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.banco = banco;
        this.validade = validade;
        this.cvc = cvc;
        this.funcao = funcao;
        this.bandeira = bandeira;
    }

    public Cartao(String numero, String nomeTitular, String banco, 
            String validade, int cvc, String funcao, String bandeira,
            Cliente cliente) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.banco = banco;
        this.validade = validade;
        this.cvc = cvc;
        this.funcao = funcao;
        this.cliente = cliente;
        this.bandeira = bandeira;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }


    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }
    
    
    @Override
    public String toString() {
        return "Cartao{" + "id " + id + " numero=" + numero + ", nomeTitular=" + nomeTitular + ", banco=" + banco + ", validade=" + validade + ", cvc=" + cvc + ", funcao=" + funcao + ", cliente=" + cliente + '}';
    }
    
    
    
}
