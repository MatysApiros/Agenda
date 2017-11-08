package View;

import Controler.ManagementControler;
import Controler.SelectsControler;
import Model.Pessoa;

import java.util.Scanner;

public class Menu {

    private Scanner teclado = new Scanner(System.in);

    ManagementControler managementControler = new ManagementControler();
    SelectsControler selectsControler = new SelectsControler();

    public void menuPrincipal() {
        System.out.println("Menu Principal");
        System.out.println("Opções:");
        System.out.println("1 - Menu de Gerenciamento de Informações;");
        System.out.println("2 - Menu de Gerenciamento de Pesquisas;");
        System.out.println("3 - Finallizar Aplicação;");
        int entrada = teclado.nextInt();
        switch (entrada){
            case 1:
                managementMenu();
                return;
            case 2:
                selectMenu();
                return;
            case 3:
                System.exit(0);
            default:
                menuPrincipal();
                break;
        }
    }

    public void managementMenu(){
        System.out.print("\nSelecione a funcionalidade que deseja utilizar!\n");
        System.out.println("0 - Retornar ao menu anterior;");
        System.out.println("1 - Inserir Pessoa;");
        System.out.println("2 - Atualizar Número de Telefone;");
        System.out.println("3 - Atualizar Nome da uma Pessoa;");
        System.out.println("4 - Deletar uma Pessoa;");
        int entrada = teclado.nextInt();

        switch (entrada){
            case 0:
                menuPrincipal();
            case 1:
                System.out.print("\n");
                managementControler.inseriPessoa(insertPessoaData());
                System.out.println("Pessoa inserida com sucesso;");
                managementMenu();
                return;
            case 2:
                System.out.print("\n");
                managementControler.atualizarPessoaNumero(insertPessoaData());
                System.out.println("Número de Telefone alterado com sucesso;");
                managementMenu();
                return;
            case 3:
                System.out.print("\n");
                System.out.println("Insira o ID da Pessoa(*Caso não saiba o ID, consulte o ID da Pessoa através de uma das opções de pesquisa!*):");
                int id = teclado.nextInt();
                System.out.println("Insira o novo Nome para a Pessoa:");
                String nome = teclado.nextLine();
                managementControler.atualizarPessoaNome(id, nome);
                System.out.println("Nome da Pessoa alterado com sucesso;");
                managementMenu();
                return;
            case 4:
                System.out.print("\n");
                System.out.println("Insira o ID da Pessoa(*Caso não saiba o ID, consulte o ID da Pessoa através de uma das opções de pesquisa!*):");
                int id2 = teclado.nextInt();
                managementControler.deletaPessoa(id2);
                System.out.println("Pessoa Deletada com sucesso;");
                managementMenu();
                return;
            default:
                managementMenu();
                break;
        }
    }

    public void selectMenu(){
        System.out.println("\nSelecione a funcionalidade que deseja utilizar!\n");
        System.out.println("0 - Retornar ao menu anterior;");
        System.out.println("1 - Pesquisar Pessoa por Nome;");
        System.out.println("2 - Pesquisar Pessoa por ID;");
        System.out.println("3 - Retornar lista de todos as Pessoas(*Em ordem Alfabética*);");
        int entrada = teclado.nextInt();
        switch (entrada){
            case 0:
                menuPrincipal();
            case 1:
                System.out.print("\nInsira o Nome da Pessoa:");
                String nome = teclado.next();
                System.out.println(selectsControler.selecionaPessoaPorNome(nome));
                selectMenu();
                return;
            case 2:
                System.out.print("\nInsira o ID do Livro(*Caso não saiba o ID, consulte o ID do Livro através de uma das opções de pesquisa!*):");
                int id = teclado.nextInt();
                System.out.println(selectsControler.selecionaPessoaPorID(id));
                selectMenu();
                return;
            case 3:
                System.out.print("\n" + selectsControler.selecionaTodasAsPessoas());
                selectMenu();
                return;
            default:
                System.out.print("\n");
                selectMenu();
                break;
        }
    }

    public Pessoa insertPessoaData(){
        System.out.println("Insira o Nome da Pessoa:");
        String nome = teclado.next();
        System.out.println("Insira o Número de Telefone:");
        int numero = teclado.nextInt();
        Pessoa pessoa = new Pessoa(nome,numero);
        return pessoa;
    }
}
