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
public class Cliente extends Pessoa{
    
    public Cliente(){
        super();
    }

    public Cliente(String cpf, String nome, String email, String senha, String endereco, Date dataNascimento, String sexo){
        
        super(cpf, nome, email, senha, endereco, dataNascimento, sexo);
    }
}
