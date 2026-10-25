/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author rot-civ
 */
public class Gerente extends Pessoa {
    
    private float salario;
    
    public Gerente(){
        super();
    }
    
    public Gerente(String cpf, String nome, String endereco, Date dataNascimento, String sexo, String email, String senha, float salario){
        
        super(cpf, nome, endereco, dataNascimento, sexo, email, senha);
        this.salario = salario;
    }
    
    public float getSalario(){  
        return salario;
    }
    
    public void setSalario(float salario){    
        this.salario = salario;
    }
}
