/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author rot-civ
 */
public class Cliente extends Pessoa{
    
    public Cliente(){
        super();
    }

    public Cliente(String cpf, String nome, String endereco, Date dataNascimento, String sexo){
        
        super(cpf, nome, endereco, dataNascimento, sexo);
    }
}
