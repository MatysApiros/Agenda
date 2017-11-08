package Controler;

import Database.AgendaDAO;
import Model.Pessoa;
import java.util.List;

public class SelectsControler {

    private AgendaDAO agendaDAO = new AgendaDAO();

    public String selecionaPessoaPorNome(String nome){
        return agendaDAO.selectPessoaByName(nome);
    }

    public String selecionaPessoaPorID(int id){
        return agendaDAO.selectBookByID(id);
    }

    public List<Pessoa> selecionaTodasAsPessoas(){
        return agendaDAO.selectTodasAsPessoas();
    }
}
