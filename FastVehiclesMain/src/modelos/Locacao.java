/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Date;

/**
 *
 * @author Isaac
 */
public class Locacao {
    private long id;
    private Locadora locadora;
    private Cliente cliente;
    private Veiculo veiculo;
    private Cartao cartao;
    private Date dataLocacao;
    private Date dataEntrega;
    private double valorTotal;
    private String formaPagamento;
    private double multa;
    
    public Locacao() {
        
    }
    public Locacao(Locadora locadora, Cliente cliente, Veiculo veiculo, Cartao cartao,
            Date dataLocacao, Date dataEntrega, double valorTotal, 
            String formaPagamento, double multa) { //cosntrutor com todos os valores
        this.locadora = locadora;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.cartao = cartao;
        this.dataLocacao = dataLocacao;
        this.dataEntrega = dataEntrega;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
        this.multa = multa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public Locadora getLocadora() {
        return locadora;
    }

    public void setLocadora(Locadora locadora) {
        this.locadora = locadora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    @Override
    public String toString() {
        return "Locacao{" + "id=" + id + ", locadora=" + locadora + ", cliente=" + cliente + ", veiculo=" + veiculo + ", cartao=" + cartao + ", dataLocacao=" + dataLocacao + ", dataEntrega=" + dataEntrega + ", valorTotal=" + valorTotal + ", formaPagamento=" + formaPagamento + ", multa=" + multa + '}';
    }
    
    
    
    
    
    
}
