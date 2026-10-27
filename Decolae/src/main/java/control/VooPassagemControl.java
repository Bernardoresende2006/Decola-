
package control;

import DAO.VooPassagemDAO;
import java.time.LocalTime;
import java.util.ArrayList;


public class VooPassagemControl {
    
    private VooPassagemDAO dao; 
    
    public VooPassagemControl(){
        this.dao = new VooPassagemDAO();
    }
    
    public ArrayList<String> procuraOrigemDestino(){
        return dao.consultaOrigemDestinoVoos();
    }
    
    public ArrayList<Integer> procuraAssentosOcupados(String cidadeOrigem, String cidadeDestino, LocalTime horario){
        return dao.consultaAssentosOcupados(cidadeOrigem, cidadeDestino, horario);
    }
    
    public ArrayList<LocalTime> procuraHorariosVoo(String cidadeOrigem, String cidadeDestino){
        return dao.consultaHorariosVoo(cidadeOrigem, cidadeDestino);
    }
}
