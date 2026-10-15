package model;

import java.util.Date;

public class Cliente extends Pessoa{
    
    public Cliente(){
        super();
    }

    public Cliente(String cpf, String nome, String endereco, Date dataNascimento, String sexo){
        
        super(cpf, nome, endereco, dataNascimento, sexo);
    }
}
