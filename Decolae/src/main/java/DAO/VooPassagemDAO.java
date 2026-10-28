
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
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
    
    public ArrayList<Integer> consultaAssentosOcupados(String cidadeOrigem, String cidadeDestino, LocalTime horarioPartida){
        ArrayList<Integer> assentosResultado = new ArrayList<>();
        
        String sql = "SELECT p.num_assento FROM empresa.voo AS v JOIN empresa.passagem AS p ON v.num_voo = p.num_voo WHERE v.cidade_origem=? AND v.cidade_destino=? AND v.horario_partida=?";
        
        try(PreparedStatement consulta = c.prepareStatement(sql)){
            consulta.setString(1, cidadeOrigem);
            consulta.setString(2, cidadeDestino);
            consulta.setObject(3, horarioPartida);
            
            ResultSet resultado = consulta.executeQuery();
            
            while(resultado.next()){
                assentosResultado.add(resultado.getInt("num_assento"));
            }
        }catch(SQLException ex){
            Logger.getLogger(VooPassagemDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro: " + ex.getMessage());
        }
        
        return assentosResultado;
    }
    
    public ArrayList<LocalTime> consultaHorariosVoo(String cidadeOrigem, String cidadeDestino){
        ArrayList<LocalTime> horarioResult = new ArrayList<>();
        
        String sql = "SELECT horario_partida FROM empresa.voo WHERE cidade_origem=? AND cidade_destino=?";
        
        try(PreparedStatement consulta = c.prepareStatement(sql)){
            consulta.setString(1, cidadeOrigem);
            consulta.setString(2, cidadeDestino);
            
            ResultSet resultado = consulta.executeQuery();
            
            while(resultado.next()){
                java.sql.Time horarioBanco = resultado.getTime("horario_partida");
                horarioResult.add(horarioBanco.toLocalTime());
            }
        }catch(SQLException ex){
            Logger.getLogger(VooPassagemDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro: " + ex.getMessage());
        }
        
        return horarioResult;
    }
    
    public boolean inserePassagem(int numAssento, String clienteCpf, String origem, String destino, LocalTime horarioPartida){
        String sql = "INSERT INTO empresa.passagem (num_assento, num_voo, cliente_cpf, preco, origem, partida, tempo_trajeto) "
           + "SELECT "
           + "  ?, "                             
           + "  v.num_voo, "                     
           + "  ?, "                             
           + "  350, "                           
           + "  v.cidade_origem, "               
           + "  (v.data + v.horario_partida), "  
           + "  (v.horario_chegada - v.horario_partida) " 
           + "FROM empresa.voo v "
           + "WHERE v.cidade_origem = ? "        
           + "  AND v.cidade_destino = ? "       
           + "  AND v.horario_partida = ?";
        
        try(PreparedStatement consulta = c.prepareStatement(sql)){
            consulta.setInt(1, numAssento);
            consulta.setString(2, clienteCpf);
            consulta.setString(3, origem);
            consulta.setString(4, destino);
            consulta.setObject(5, horarioPartida);
            
            int resultado = consulta.executeUpdate();
            if(resultado>0) return true;
            
        }catch(SQLException ex){
            Logger.getLogger(VooPassagemDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro: " + ex.getMessage());
        }
        return false;
    }
}
