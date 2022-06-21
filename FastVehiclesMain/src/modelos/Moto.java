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
public class Moto extends Veiculo {
    
    private int cilindradas;
    
    public Moto(String tipo, String marca, String modelo,
        String cor, String combustivel, int ano, long quilometragem, 
        String placa, double caucao, double valorDiario, String motor,
        int cilindradas, Locadora locadora) {
       
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
        this.cilindradas = cilindradas;
        this.locadora = locadora;
    }
    
    
    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    
    @Override
    public String toString() {
        return String.format("[id = %d, tipo = %s, marca = %s,"
                + " modelo = %s, cor = %s, combustivel = %s, ano = %d,"
                + " quilometragem = %s, placa = %s, caucao = %.2f,"
                + " valorDiario = %.2f, motor = %s, cilindradas = %d]\n",
                id, tipo, marca, modelo, cor, combustivel, ano, quilometragem,
                placa, caucao, valorDiario, motor, cilindradas);
    }
    
    
    
}
