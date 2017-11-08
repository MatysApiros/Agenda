package Model;

public class Pessoa {

    private String nome;
    private int numero;
    private int id;

    public Pessoa(String nome, int numero) {
        this.nome = nome;
        this.numero  = numero;
        this.id = id;
    }

    public Pessoa(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "Nome: " + nome + "Número: " + numero + "ID: " + id + '}';
    }
}
