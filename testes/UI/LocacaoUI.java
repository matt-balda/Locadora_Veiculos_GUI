package UI;

import entidades.*;
import servicos.GerenciadorClientes;
import servicos.GerenciadorLocacoes;
import servicos.GerenciadorVeiculos;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class LocacaoUI {
    private GerenciadorLocacoes locacoes;
    private GerenciadorClientes clientes;
    private GerenciadorVeiculos veiculos;
    private Locacao locacao;
    private Cliente cliente;
    private Veiculo veiculo;

    public LocacaoUI(GerenciadorLocacoes locacoes, GerenciadorClientes clientes, GerenciadorVeiculos veiculos, Cliente cliente, Veiculo veiculo){
        this.locacoes = locacoes;
        this.clientes = clientes;
        this.veiculos = veiculos;
        this.cliente = cliente;
        this.veiculo = veiculo;
    }
    public void menuGerenciarLocacaoes() throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcao;
        do{
            System.out.println(":: GENRENCIAR LOCAÇÕES ::\n");
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
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }while (opcao != 0);


    }
    public void add() throws Exception{
        Scanner sc = new Scanner(System.in);
        //Cliente c;
        //Veiculo v;
        //Locacao l;
        char alter;
        double valorDiaria = 0;
        long CPF;
        Date dataInicio = null, dataFim = null;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        boolean seguro = false;
        String placa, dataRecebida1, dataRecebida2;

        System.out.print("Digite o CPF do cliente: ");
        CPF = sc.nextLong();
        cliente = clientes.get(CPF);
        if (!clientes.existe(CPF)){
            System.out.println("\nO cliente não foi encontrado.");
        }else{
            System.out.println(cliente.toString());
        }

        System.out.print("Digite a Placa do veículo ");
        placa = sc.nextLine();
        veiculo = veiculos.get(placa);

        System.out.println("Seguro de Vida: s/n ");
        alter = sc.next().charAt(0);
        switch (alter) {
            case 's':
                seguro = true;
                break;
            case 'n':
                seguro = false;
                break;
        }
        System.out.print("Valor da diária: ");
        valorDiaria = sc.nextDouble();
        sc.nextLine();

        System.out.print("Data Inicial (gg/aa/yy): ");
            dataRecebida1 = sc.nextLine();
            if(null != dataRecebida1 && dataRecebida1.trim().length() > 0){
                dataInicio = format.parse(dataRecebida1);
            }
          //  System.out.print(dataRecebida1);
        System.out.print("Data Final (gg/aa/yy): ");
        dataRecebida2 = sc.nextLine();
        if(null != dataRecebida2 && dataRecebida2.trim().length() > 0){
            dataFim = format.parse(dataRecebida2);
        }
        //System.out.print(dataRecebida2);
        locacao = new Locacao(seguro, valorDiaria, dataInicio, dataFim, cliente, veiculo);
        locacoes.add(locacao);

        System.out.println("Locação criada com sucesso!");
    }
    public void get() throws Exception {
        Scanner sc = new Scanner(System.in);
        Locacao l;
        int codLocacao;
        System.out.println("Digite o código da locação a ser pesquisado: ");
        System.out.print("- ");
        codLocacao = sc.nextInt();

        l = locacoes.get(codLocacao);
        if (!locacoes.existe(codLocacao)){
            System.out.println("\nO código não foi encontrado.");
        }else{
            System.out.println(l.toString());
        }
    }
    public void set() throws Exception {
        Scanner sc = new Scanner(System.in);
        char alter;
        Locacao l;
        int codLocacao, op;
        double valorDiaria = 0;
        Date dataInicio = null, dataFim = null;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        boolean seguro = false;
        String placa, dataRecebida1, dataRecebida2;

        System.out.println("Digite o código da locação a ser pesquisado: ");
        System.out.print("- ");
        codLocacao = sc.nextInt();

        l = locacoes.get(codLocacao);
        if (!locacoes.existe(codLocacao)){
            System.out.println("\nO código não foi encontrado.");
        }else{
            System.out.println(l.toString());
        }

        System.out.println("\nO que deseja alterar: ");
        System.out.println("1. Seguro | 2. Valor Diário | 3. Data Inicial | 4. Data Final");
        System.out.print("- ");
        op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1:
                System.out.println("Seguro de Vida: s/n ");
                alter = sc.next().charAt(0);
                switch (alter) {
                    case 's':
                        l.setSeguro(seguro = true);
                        break;
                    case 'n':
                        l.setSeguro(seguro = false);
                        break;
                }
                break;
            case 2:
                System.out.print("Valor da diária: ");
                valorDiaria = sc.nextDouble();
                l.setValorDiaria(valorDiaria);
                break;
            case 3:
                System.out.print("Data Inicial (gg/aa/yy): ");
                dataRecebida1 = sc.nextLine();
                if(null != dataRecebida1 && dataRecebida1.trim().length() > 0){
                    l.setDataInicial(dataInicio = format.parse(dataRecebida1)) ;
                }
                break;
            case 4:
                System.out.print("Data Final (gg/aa/yy): ");
                dataRecebida2 = sc.nextLine();
                if(null != dataRecebida2 && dataRecebida2.trim().length() > 0){
                    l.setDataFinal(dataFim = format.parse(dataRecebida2));
                }
                break;
        }
        System.out.println(l.toString());

        System.out.println("\nDados alterado com sucesso");
    }
    public void getInfo(){
        System.out.println(locacoes.getInfo());
    }
    public void excluir() throws Exception {
        Scanner sc = new Scanner(System.in);
        Locacao l;
        int codLocacao;
        System.out.println("Digite o código da locação a ser pesquisado: ");
        System.out.print("- ");
        codLocacao = sc.nextInt();

        l = locacoes.get(codLocacao);
        if (!locacoes.existe(codLocacao)){
            System.out.println("\nA locação não foi encontrado.");
        }else{
            System.out.println(l.toString());
            locacoes.remove(codLocacao);
        }
    }
}
