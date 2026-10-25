/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author rot-civ
 */
public class Aeronave {
    
    private int id_aeronave;
    private String modelo;
    private String gerente_cpf;
    private String localizacao;
    private int num_assentos;

    public Aeronave() {}

    public Aeronave(int id_aeronave, String modelo, String gerente_cpf, String localizacao, int num_assentos) {
        this.id_aeronave = id_aeronave;
        this.modelo = modelo;
        this.gerente_cpf = gerente_cpf;
        this.localizacao = localizacao;
        this.num_assentos = num_assentos;
    }

    public int getIdAeronave() {
        return id_aeronave;
    }

    public void setIdAeronave(int id_aeronave) {
        this.id_aeronave = id_aeronave;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getGerenteCpf() {
        return gerente_cpf;
    }

    public void setGerenteCpf(String gerente_cpf) {
        this.gerente_cpf = gerente_cpf;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getNumAssentos() {
        return num_assentos;
    }

    public void setNumAssentos(int num_assentos) {
        this.num_assentos = num_assentos;
    }
}
