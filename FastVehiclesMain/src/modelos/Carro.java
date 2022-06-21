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
public class Carro extends Veiculo {
    
    private int cavalos;
    private int portas;
    
    //construtor com somente uma locadoras - constructor with just one locator
    public Carro(String tipo, String marca, String modelo,
        String cor, String combustivel, int ano, long quilometragem, 
        String placa, double caucao, double valorDiario, String motor,
        int cavalos, int portas, Locadora locadora) {
        
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.combustivel = combustivel;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.placa = placa;
        this.caucao = caucao;
        this.valorDiario = valorDiario;
        this.motor = motor;
        this.cavalos = cavalos;
        this.portas = portas;
        this.locadora = locadora;
    }
    
    

    public int getCavalos() {
        return cavalos;
    }

    public void setCavalos(int cavalos) {
        this.cavalos = cavalos;
    }

    public int getPortas() {
        return portas;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }

    @Override
    public String toString() {
        return "Carro{" + "id=" + id + ", tipo=" + tipo + ", marca=" + marca + ", modelo=" + modelo + ", cor=" + cor + ", combustivel=" + combustivel + ", ano=" + ano + ", quilometragem=" + quilometragem + ", placa=" + placa + ", caucao=" + caucao + ", valorDiario=" + valorDiario + ", motor=" + motor + ", cavalos=" + cavalos + ", portas=" + portas + '}';
    }
    

    
    
}
