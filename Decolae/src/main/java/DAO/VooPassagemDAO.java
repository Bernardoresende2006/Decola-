
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tool.Conexao;

public class VooPassagemDAO {
    
    private Connection c;
    
    public VooPassagemDAO(){
        this.c = Conexao.obterConexao();
    }
    
    public ArrayList<String> consultaOrigemDestinoVoos(){
        ArrayList<String> cidadeResultados = new ArrayList<>();
        
        String sql = "SELECT cidade_origem, cidade_destino FROM empresa.voo";
        
        try(PreparedStatement consulta = c.prepareStatement(sql)){
            ResultSet resultado = consulta.executeQuery();
                          
            while(resultado.next()){
                cidadeResultados.add(resultado.getString("cidade_origem"));
                cidadeResultados.add(resultado.getString("cidade_destino"));
            }                
            
        }catch(SQLException ex){
            Logger.getLogger(VooPassagemDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro: " + ex.getMessage());
        }
        
        return cidadeResultados;
    }
}
