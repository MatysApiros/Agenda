package Controler;

import Database.AgendaDAO;
import Model.Pessoa;

public class ManagementControler {

    private AgendaDAO agendaDAO = new AgendaDAO();

    public void inseriPessoa(Pessoa pessoa){
        agendaDAO.insertPessoa(pessoa);
    }

    public void atualizarPessoaNumero(Pessoa pessoa){
        agendaDAO.updatePessoaNumero(pessoa);
    }

    public void atualizarPessoaNome(int id, String nome){
        agendaDAO.updatePessoaNome(id,nome);
    }

    public void deletaPessoa(int id){
        agendaDAO.deletePessoa(id);
    }
}
