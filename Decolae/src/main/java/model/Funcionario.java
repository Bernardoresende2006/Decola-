/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author rot-civ
 */
public class Funcionario extends Pessoa {
    
    private String cargo;
    private String gerente_cpf;
    private LocalDateTime inicio_expediente;
    private LocalDateTime fim_expediente;
    private float salario;
    
    public Funcionario(){}
    
    public Funcionario(String cargo, String gerente_cpf, LocalDateTime inicio_expediente, LocalDateTime fim_expediente, float salario){
        
        this.cargo = cargo;
        this.gerente_cpf = gerente_cpf;
        this.inicio_expediente = inicio_expediente;
        this.fim_expediente = fim_expediente;
        this.salario = salario;
    }
    
    public String getCargo(){
        return this.cargo;
    }
    
    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    
    public String getCpfGerente(){
        return this.gerente_cpf;
    }
    
    public void setCpfGerente(String gerente_cpf){
        this.gerente_cpf = gerente_cpf;
    }
    
    public LocalDateTime getInicioExpediente(){
        return this.inicio_expediente;
    }
    
    public void setInicioExpediente(LocalDateTime inicio_expediente){
        this.inicio_expediente = inicio_expediente;
    }
    
    public LocalDateTime getFimExpediente(){
        return this.fim_expediente;
    }
    
    public void setFimExpediente(LocalDateTime fim_expediente){
        this.fim_expediente = fim_expediente;
    }
    
    public float getSalario(){
        return this.salario;
    }
    
    public void setSalario(float salario){
        this.salario = salario;
    }
}