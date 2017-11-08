package Database;

import Model.Pessoa;
import Model.PessoaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgendaDAO {

    private Connection connection;

    public AgendaDAO() {
        try {
            this.connection = DatabaseConnection.getConexao();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean insertPessoa(Pessoa pessoa){
        String sql = "insert into agenda(nome,numero) values(?,?);";
        try(PreparedStatement statementmt = connection.prepareStatement(sql)){
            statementmt.setString(1, pessoa.getNome());
            statementmt.setString(2, String.valueOf(pessoa.getNumero()));
            statementmt.execute();
            return true;
        }catch (SQLException excption){
            throw new PessoaException("Erro ao Retornar a Pessoa indicada!");
        }
    }

    public boolean updatePessoaNumero(Pessoa pessoa){
        String sql = "update agenda set numero = ? where nome = ?;";
        try(PreparedStatement statementmt = connection.prepareStatement(sql)){
            statementmt.setString(1, String.valueOf(pessoa.getNumero()));
            statementmt.setString(2, pessoa.getNome());
            statementmt.execute();
            return true;
        }catch (SQLException excption){
            throw new PessoaException("Erro ao Atualizar o Número de Telefone para a Pessoa informada!");
        }
    }

    public boolean updatePessoaNome(int id, String nome){
        String sql = "update agenda set nome = ? where id = ?;";
        try(PreparedStatement statementmt = connection.prepareStatement(sql)){
            statementmt.setString(1, String.valueOf(nome));
            statementmt.setString(2, String.valueOf(id));
            statementmt.execute();
            return true;
        }catch (SQLException excption){
            throw new PessoaException("Erro ao Atualizar o Nome para a Pessoa informada!");
        }
    }

    public boolean deletePessoa(int pessoaId){
        String sql = "delete from agenda where pessoa_id = ?;";
        try(PreparedStatement statementmt = connection.prepareStatement(sql)){
            statementmt.setString(1, String.valueOf(pessoaId));
            statementmt.execute();
            return true;
        }catch (SQLException excption){
            throw new PessoaException("Erro ao Deletar a Pessoa informada!");
        }
    }

    public String selectPessoaByName(String nome){
        String sql = "select * from agenda where nome = ?";
        Pessoa pessoa = null;
        try(PreparedStatement statementmt = connection.prepareStatement(sql)){
            statementmt.setString(1, nome);
            ResultSet string = statementmt.executeQuery();
            string.next();
            pessoa = mapFromResultSetPessoa(string);
            return pessoa.toString();
        } catch (SQLException excption){
            throw new PessoaException("Erro ao Pesquisar pela Pessoa informada!");
        }
    }

    public String selectBookByID(Integer id){
        String sql = "select * from agenda where pessoa_id = ?";
        Pessoa pessoa = null;
        try(PreparedStatement statementmt = connection.prepareStatement(sql)){
            statementmt.setInt(1, id);
            ResultSet string = statementmt.executeQuery();
            string.next();
            pessoa = mapFromResultSetPessoa(string);
            return pessoa.toString();
        } catch (SQLException excption){
            throw new PessoaException("Erro ao Pesquisar pela Pessoa informada!");
        }
    }

    public List<Pessoa> selectTodasAsPessoas(){
        String sql = "select * from agenda order by nome;";
        try(PreparedStatement statementmt = connection.prepareStatement(sql)){
            ResultSet string = statementmt.executeQuery();
            return mapResultSetToBookList(string);
        } catch (SQLException excption){
            throw new PessoaException("Erro ao Listar as Pessoas arquivadas na Agenda!");
        }
    }

    private List<Pessoa> mapResultSetToBookList(ResultSet resultSet) throws SQLException {
        List<Pessoa> pessoa = new ArrayList<>();
        while (resultSet.next()) {
            pessoa.add(mapFromResultSetPessoa(resultSet));
        }
        return pessoa;
    }

    private Pessoa mapFromResultSetPessoa(ResultSet string) throws SQLException {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(string.getString("title"));
        pessoa.setNumero(Integer.parseInt(string.getString("numero")));
        pessoa.setId(Integer.parseInt(string.getString("pessoa_id")));
        return pessoa;
    }
}
