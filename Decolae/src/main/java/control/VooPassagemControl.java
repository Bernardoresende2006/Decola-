
package control;

import DAO.VooPassagemDAO;
import java.util.ArrayList;


public class VooPassagemControl {
    
    private VooPassagemDAO dao; 
    
    public VooPassagemControl(){
        this.dao = new VooPassagemDAO();
    }
    
    public ArrayList<String> procuraOrigemDestino(){
        return dao.consultaOrigemDestinoVoos();
    }
}
