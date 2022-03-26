package UI;

import entidades.Categoria;
import entidades.Cliente;
import entidades.Veiculo;
import file.Arquivo;
import servicos.GerenciadorClientes;
import servicos.GerenciadorLocacoes;
import servicos.GerenciadorVeiculos;

import java.io.Serializable;
import java.util.Scanner;

public class LocadoraUI implements Serializable {
    private GerenciadorClientes clientes;
    private GerenciadorVeiculos veiculos;
    private GerenciadorLocacoes locacoes;
    private ClienteUI clienteUI;
    private VeiculoUI veiculoUI;
    private LocacaoUI locacaoUI;
    private Categoria categoria;
    private Cliente cliente;
    private Veiculo veiculo;

    public LocadoraUI() throws Exception {
        clientes = new GerenciadorClientes();
        veiculos = new GerenciadorVeiculos();
        locacoes = new GerenciadorLocacoes();
        clienteUI = new ClienteUI(clientes);
        veiculoUI = new VeiculoUI(veiculos);
        locacaoUI = new LocacaoUI(locacoes, clientes, veiculos, null, null);
    }

    public void menuPrincipal() throws Exception {
        int opcao;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("\n :: ADMINISTRAÇÃO DO SISTEMA");
            System.out.println("Escolha a opção desejada");
            System.out.println("1 - Gerenciar Clientes");
            System.out.println("2 - Gerenciar Veículos");
            System.out.println("3 - Gerenciar Locações");
            System.out.println("0 - Sair");
            System.out.print("Sua opção: ");
            opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    clienteUI.menuGerenciarClientes();
                    break;
                case 2:
                    veiculoUI.menuGerenciarVeiculos();
                    break;
                case 3:
                    locacaoUI.menuGerenciarLocacaoes();
                    break;
            }
        }while (opcao != 0);
        try{
            Arquivo.gravar((Object) clientes, "clientes1.bin");
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
