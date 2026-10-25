package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tool.Conexao;
import java.util.ArrayList;
import java.util.List;
import model.Aeronave;

public class AeronaveDAO {
    
    private Connection c;

    public AeronaveDAO(){

        this.c = Conexao.obterConexao();
    }

    public boolean salvar(Aeronave aeronave){

        String sql = "INSERT INTO aeronave (id_aeronave, modelo, gerente_cpf, localizacao, num_assentos) VALUES (?, ?, ?, ?, ?)";
        
        try(PreparedStatement stmt = c.prepareStatement(sql)){
            stmt.setInt(1, aeronave.getIdAeronave());
            stmt.setString(2, aeronave.getModelo());
            stmt.setString(3, aeronave.getGerenteCpf());
            stmt.setString(4, aeronave.getLocalizacao());
            stmt.setInt(5, aeronave.getNumAssentos());
            stmt.executeUpdate();

            return true;

        }catch(SQLException ex){

            return false;
        }
    }

    public boolean atualizar(Aeronave aeronave){

        String sql = "UPDATE aeronave SET modelo = ?, gerente_cpf = ?, localizacao = ?, num_assentos = ? WHERE id_aeronave = ?";

        try(PreparedStatement stmt = c.prepareStatement(sql)){
            stmt.setString(1, aeronave.getModelo());
            stmt.setString(2, aeronave.getGerenteCpf());
            stmt.setString(3, aeronave.getLocalizacao());
            stmt.setInt(4, aeronave.getNumAssentos());
            stmt.setInt(5, aeronave.getIdAeronave());
            stmt.executeUpdate();

            return true;

        }catch(SQLException ex){

            return false;
        }
    }

    public boolean excluir(int idAeronave){

        String sql = "DELETE FROM aeronave WHERE id_aeronave = ?";

        try(PreparedStatement stmt = c.prepareStatement(sql)){
            stmt.setInt(1, idAeronave);
            stmt.executeUpdate();

            return true;

        }catch(SQLException ex){

            return false;
        }
    }

    public List<Aeronave> listarTodos(){

        List<Aeronave> aeronaves = new ArrayList<>();
        String sql = "SELECT * FROM aeronave";

        try(PreparedStatement stmt = c.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Aeronave aeronave = new Aeronave();
                aeronave.setIdAeronave(rs.getInt("id_aeronave"));
                aeronave.setModelo(rs.getString("modelo"));
                aeronave.setGerenteCpf(rs.getString("gerente_cpf"));
                aeronave.setLocalizacao(rs.getString("localizacao"));
                aeronave.setNumAssentos(rs.getInt("num_assentos"));
                aeronaves.add(aeronave);
            }

        }catch(SQLException ex){

            Logger.getLogger(AeronaveDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aeronaves;
    }
}
