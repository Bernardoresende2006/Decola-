
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tool.Conexao;
import model.Pessoa;

public class PessoaDAO {
    private Connection c;
    
    public PessoaDAO(){
        this.c = Conexao.obterConexao();
    }
    
    public Pessoa consultaLogin(Pessoa pessoaEntrada){
        Pessoa pessoaResultado = null;
        
        String sql = "SELECT * FROM empresa.pessoa WHERE (cpf=? OR email=?) AND senha=?";
        
        try(PreparedStatement consulta = c.prepareStatement(sql)){
            consulta.setString(1, pessoaEntrada.getCpf());
            consulta.setString(2, pessoaEntrada.getEmail());
            consulta.setString(3, pessoaEntrada.getSenha());
            
            ResultSet resultado = consulta.executeQuery();
            if(resultado.next()){
                pessoaResultado = new Pessoa();
                        
                pessoaResultado.setCpf(resultado.getString("cpf"));
                pessoaResultado.setNome(resultado.getString("nome"));
                pessoaResultado.setEndereco(resultado.getString("endereco"));
                pessoaResultado.setDataNascimento(resultado.getDate("data_nascimento"));
                pessoaResultado.setSexo(resultado.getString("sexo"));
                pessoaResultado.setEmail(resultado.getString("email"));
                pessoaResultado.setSenha(resultado.getString("senha"));
            }
        }catch(SQLException ex){
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro: " + ex.getMessage());
        }
        
        return pessoaResultado;
    }
    
}
