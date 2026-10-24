/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author rot-civ
 */
public class Gerente extends Pessoa {
    
    private float salario;
    
    public Gerente(){
        super();
    }
    
    public Gerente(String cpf, String nome, String endereco, Date dataNascimento, String sexo, float salario){
        
        super(cpf, nome, endereco, dataNascimento, sexo);
        this.salario = salario;
    }
}
