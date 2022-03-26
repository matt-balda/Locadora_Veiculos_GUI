package UI;

import entidades.Cliente;
import file.Arquivo;
import servicos.GerenciadorClientes;

import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Scanner;

public class ClienteUI implements Serializable {
    private GerenciadorClientes clientes;

    public ClienteUI(GerenciadorClientes clientes) throws Exception {
        this.clientes = clientes;
    }

    public void menuGerenciarClientes() throws Exception {
        if (new File("clientes1.bin").exists()){
              try {
                  clientes = (GerenciadorClientes) Arquivo.ler("clientes1.bin");
              }catch (Exception e){
                  System.err.println(e.getMessage());
              }
          }
        Scanner sc = new Scanner(System.in);
        int opcao;
        do{
            System.out.println(":: GENRENCIAR CLIENTES ::\n");
            System.out.println("Escolha a opção desejada");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Consultar");
            System.out.println("3 - Alterar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Listar");
            System.out.println("6 - Listar Resumido");
            System.out.println("0 - Voltar Menu Anterior");
            System.out.print("Sua opção: ");
            opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    add();
                    break;
                case 2:
                    get();
                    break;
                case 3:
                    set();
                    break;
                case 4:
                    excluir();
                    break;
                case 5:
                    getInfo();
                    break;
                case 6:
                    getInfoResumo();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }while (opcao != 0);


    }
    public void add() throws Exception{
        Scanner sc = new Scanner(System.in);
        Cliente c;
        String nome, endereco;
        long CPF = 0, numCarteiraMotorista = 0, telefone = 0;

            System.out.print("Nome: ");
            nome = sc.nextLine();
            System.out.print("CPF: ");
            CPF = sc.nextLong();
            System.out.print("Número da Carteira de Motorista: ");
            numCarteiraMotorista = sc.nextLong();
            System.out.print("Endereço: ");
            endereco = sc.nextLine();
            sc.nextLine();
            System.out.print("Telefone: ");
            telefone = sc.nextLong();

        c = new Cliente(nome, CPF, numCarteiraMotorista, endereco, telefone);
        clientes.add(c);

        System.out.println("\nCliente criado com sucesso");
    }

    public void get() throws Exception {
        Scanner sc = new Scanner(System.in);
        long CPF;
        String c;
        System.out.println("Digite o CPF do cliente a ser pesquisado: ");
        System.out.print("- ");
        CPF = sc.nextLong();

        c = clientes.getInfo(CPF);
        if (!clientes.existe(CPF)){
            System.out.println("\nO cliente não foi encontrado.");
        }else{
            System.out.println(c.toString());
        }
    }
    public void set() throws Exception {
        Scanner sc = new Scanner(System.in);
        Cliente c;
        long CPF, novoTelefone = 0;
        int op;
        Thread th = null;
        String novoNome = null, novoEndereco = null;
        System.out.println("Digite o CPF do cliente a ser pesquisado: ");
        System.out.print("- ");
        CPF = sc.nextLong();

        c = clientes.get(CPF);

        if (!clientes.existe(CPF)) { // cliente não encotrado
            System.out.println("\nO cliente não foi encontrado.");
        } else {
            System.out.println(c.toString());
        }
        System.out.println("\nDeseja alterar, qual dado em específico? ");
        System.out.println("1. Nome | 2. Endereço | 3. Telefone");
        System.out.print("- ");
        op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1:
                do {
                    System.out.print("\nNome: ");
                    try {
                        novoNome = sc.nextLine();
                        c.setNome(novoNome);
                    } catch (Exception e) {
                        System.err.print(e.getMessage());
                        th.sleep(1000);
                    }
                }while (novoNome == null || novoNome.equals("") || novoNome.matches("[0-9]*"));
                break;
            case 2:
                do {
                    System.out.print("Endereço: ");
                    try {
                        novoEndereco = sc.nextLine();
                        c.setEndereco(novoEndereco);
                    } catch (Exception e) {
                        System.err.print(e.getMessage());
                        th.sleep(1000);
                    }
                }while (novoEndereco == null || novoEndereco.equals("") || novoEndereco.matches("[0-9]*"));
                break;
            case 3:
                do {
                    System.out.print("Telefone: ");
                    try {
                        novoTelefone = sc.nextLong();
                        c.setTelefone(novoTelefone);
                    } catch (Exception e) {
                        System.err.print(e.getMessage());
                        th.sleep(1000);
                    }
                }while (novoTelefone < 0 || novoTelefone > 999999999);
                break;
        }
        System.out.println(c.toString());

        System.out.println("\nDados alterado com sucesso");
    }
    public void getInfo(){
        System.out.println(clientes.getInfo());
    }
    public void getInfoResumo(){
        System.out.println(clientes.getResumoInfo());
    }
    public void excluir() throws Exception {
        Scanner sc = new Scanner(System.in);
        long CPF;
        String c;
        System.out.println("Digite o CPF do cliente a ser pesquisado: ");
        System.out.print("- ");
        CPF = sc.nextLong();

        c = clientes.getInfo(CPF);
        if (!clientes.existe(CPF)){
            System.out.println("\nO cliente não foi encontrado.");
        }else{
            System.out.println(c.toString());
            clientes.remove(CPF);
        }
    }

}
