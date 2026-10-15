package dao;

import java.sql.Connection;
import model.Cliente;
import tool.Conexao;

public class ClienteDAO{

    private Connection c;

    public boolean salvarCliente(){

        String sql = "INSERT INTO Pessoa (cpf, nome, endereco, dataNascimento, sexo) VALUES (?, ?, ?, ?, ?)";

        try(PreparedStatement insercao = c.prepareStatement(sql))
    }
    
}
