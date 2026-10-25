
package tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;


public abstract class Conexao {
    public static Connection obterConexao() {
        try {
            String url = "jdbc:postgresql://localhost:5432/Decolae";
            String usuario = "postgres";
            String senha = "qwe123";

            Connection con = DriverManager.getConnection(url, usuario, senha);
            return con;
        } catch (java.sql.SQLException ex) {
            System.out.println("Erro ao conectar no banco: " + ex.getMessage());
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}


