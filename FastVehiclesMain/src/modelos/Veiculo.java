/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.List;

/**
 *
 * @author Isaac
 */
public abstract class Veiculo {
    protected long id;
    protected String tipo;
    protected String marca;
    protected String modelo;
    protected String cor;
    protected String combustivel;
    protected int ano;
    protected long quilometragem;
    protected String placa;
    protected double caucao;
    protected double valorDiario;
    protected String motor;
    protected Locadora locadora;
    protected Cliente cliente;

    
    //para serem herdados - just to be inherited
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public long getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(long quilometragem) {
        this.quilometragem = quilometragem;
    }

    public Locadora getLocadora() {
        return this.locadora;
    }

    public void setLocadora(Locadora locadora) {
        this.locadora = locadora;
    }
    

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getCaucao() {
        return caucao;
    }

    public void setCaucao(double caucao) {
        this.caucao = caucao;
    }

    public double getValorDiario() {
        return valorDiario;
    }

    public void setValorDiario(double valorDiario) {
        this.valorDiario = valorDiario;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    

    @Override
    public String toString() {
        return "Veiculo{" + "id=" + id + ", tipo=" + tipo + ", marca=" + marca + ", modelo=" + modelo + ", cor=" + cor + ", combustivel=" + combustivel + ", ano=" + ano + ", quilometragem=" + quilometragem + ", placa=" + placa + ", caucao=" + caucao + ", valorDiario=" + valorDiario + ", motor=" + motor + '}';
    }
    
    
   
    
    
    
}
