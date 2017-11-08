package Model;

public class PessoaException extends RuntimeException{

    private String mensagem;

    public PessoaException(String msg){
        super(msg);
        this.mensagem = msg;
    }
}
