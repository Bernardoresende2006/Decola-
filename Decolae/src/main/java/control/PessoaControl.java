
package control;

import DAO.PessoaDAO;
import model.Pessoa;


public class PessoaControl {
    private PessoaDAO dao;
    
    public PessoaControl(){
        dao = new PessoaDAO();
    }
    
    public Pessoa verificaLogin(Pessoa pessoaEntrada){
        return dao.consultaLogin(pessoaEntrada);
    }

}
