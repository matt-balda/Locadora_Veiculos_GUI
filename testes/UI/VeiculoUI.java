package UI;

import entidades.*;
import servicos.GerenciadorVeiculos;

import java.io.BufferedReader;
import java.io.Serializable;
import java.util.Scanner;

public class VeiculoUI implements Serializable {
    private GerenciadorVeiculos veiculos;

    public VeiculoUI(GerenciadorVeiculos veiculos){
        this.veiculos = veiculos;
    }

    public void menuGerenciarVeiculos() throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcao;
        do{
            System.out.println(":: GENRENCIAR VEICULOS ::\n");
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
        Veiculo v = null;
        Categoria categoria = null;
        char alter;
        double valorDiaria;
        int ano, numPassageiros = 0, numPortas = 0, mediaKMLitro = 0, numEixos = 0, cargaMax = 0, op;
        boolean arCondicionado = false, servicoInternet = false;
        String placa;

        System.out.print("Placa: ");
        placa = sc.nextLine();
        System.out.print("Ano: ");
        ano = sc.nextInt();
        System.out.print("Valor da diária: ");
        valorDiaria = sc.nextDouble();
        sc.nextLine();
        System.out.print("Qual o tipo do veículo: [1] Carro [2]Ônibus [3]Caminhão ");
        op = sc.nextInt();

        if (op == 1){
            System.out.println("Número de Passageiros: ");
            numPassageiros = sc.nextInt();
            System.out.println("Número de Portas: ");
            numPortas = sc.nextInt();
            System.out.println("Média de KM por litro");
            mediaKMLitro = sc.nextInt();
            System.out.println("Ar condicionado: s/n ");
            alter = sc.next().charAt(0);
            switch (alter){
                case 's':
                    arCondicionado = true;
                    break;
                case 'n':
                    arCondicionado = false;
                    break;
            }
        }
        if (op == 2){
            System.out.println("Número de Passageiros: ");
            numPassageiros = sc.nextInt();
            System.out.println("Qual categoria: [1]Leito [2]Executivo [3]Convencional ");
            int op2 = sc.next().charAt(0);
            switch (op2){
                case 1:
                    categoria = Categoria.LEITO;
                    System.out.println(categoria.getDescricao());

                    break;
                case 2:
                    categoria = Categoria.EXECUTIVO;
                    System.out.println(categoria.getDescricao());
                    break;
                case 3:
                    categoria = Categoria.CONVENCIONAL;
                    System.out.println(categoria.getDescricao());
                    break;
            }
            System.out.println("Serviço de Internet: s/n ");
            char alter2 = sc.next().charAt(0);
            switch (alter2){
                case 's':
                    servicoInternet = true;
                    break;
                case 'n':
                    servicoInternet = false;
                    break;
            }
            System.out.println("Ar condicionado: s/n ");
            alter = sc.next().charAt(0);
            switch (alter){
                case 's':
                    arCondicionado = true;
                    break;
                case 'n':
                    arCondicionado = false;
                    break;
            }
        }
        if (op == 3){
            System.out.println("Número de Eixos do Caminhão: ");
            numEixos = sc.nextInt();
            System.out.println("Número de carga Máxima em toneladas: ");
            cargaMax = sc.nextInt();
        }

        if (op == 1){
            v = new Carro(placa, ano, valorDiaria, numPassageiros,numPortas, mediaKMLitro,arCondicionado);
        }
        else if (op == 2) {
            v = new Onibus(placa, ano, valorDiaria, numPassageiros, categoria, servicoInternet, arCondicionado);
        }
        else if(op == 3){
            v = new Caminhao(placa, ano, valorDiaria, numEixos, cargaMax);
        }
        veiculos.add(v);
        
        System.out.println("\nVeículo criado com sucesso");
    }

    public void get() throws Exception {
        Scanner sc = new Scanner(System.in);
        String v, placa;
        System.out.println("Digite a placa do veículo a ser pesquisado: ");
        System.out.print("- ");
        placa = sc.nextLine();

        v = veiculos.getInfo(placa);
        if (!veiculos.existe(placa)){
            System.out.println("\nO veículo não foi encontrado.");
        }else{
            System.out.println(v.toString());
        }
    }
    public void set() throws Exception {
        Scanner sc = new Scanner(System.in);
        Thread th = null;
        Veiculo v = null;
        Carro c = null;
        Caminhao c1 = null;
        Onibus o = null;
        Categoria categoria1;
        char alter;
        double valorDiaria;
        int ano, numPassageiros, numPortas, mediaKMLitro = 0, numEixos, cargaMax, op;
        boolean arCondicionado = false, servicoInternet = false;
        String placa;

        System.out.println("\nDeseja alterar, qual veículo? ");
        System.out.println("1. Carro | 2. Ônibus | 3. Ar Condicionado");
        System.out.print("- ");
        op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1:
                System.out.println("Digite a placa do veículo a ser pesquisado: ");
                System.out.print("- ");
                placa = sc.nextLine();

                v = veiculos.get(placa);

                if (!veiculos.existe(placa)) { // cliente não encotrado
                    System.out.println("\nO veículo não foi encontrado.");
                } else {
                    System.out.println(v.toString());
                }
                    System.out.print("\nValor diária: ");
                try {
                        valorDiaria = sc.nextDouble();
                        v.setValorDiaria(valorDiaria);
                    } catch (Exception e) {
                        System.err.print(e.getMessage());
                        th.sleep(1000);
                    }
                    System.out.println("Número de Passageiros: ");

                    numPassageiros = sc.nextInt();
                    c.setNumPassageiros((int) numPassageiros);

                System.out.println("Número de Portas");

                    numPortas = sc.nextInt();
                    c.setNumPortas((int)numPortas);
                System.out.println("Ar condicionado: s/n ");
                alter = sc.next().charAt(0);
                switch (alter){
                    case 's':
                        c.setArCondicionado(arCondicionado = true);
                        break;
                    case 'n':
                        c.setArCondicionado(arCondicionado = false);
                        break;
                }
                break;
            case 2:
                System.out.println("Digite a placa do veículo a ser pesquisado: ");
                System.out.print("- ");
                placa = sc.nextLine();

                v = veiculos.get(placa);

                if (!veiculos.existe(placa)) { // cliente não encotrado
                    System.out.println("\nO veículo não foi encontrado.");
                } else {
                    System.out.println(v.toString());
                }
                System.out.print("\nValor diária: ");
                try {
                    valorDiaria = sc.nextDouble();
                    v.setValorDiaria(valorDiaria);
                } catch (Exception e) {
                    System.err.print(e.getMessage());
                    th.sleep(1000);
                }
                    System.out.print("Número de Passageiros: ");
                    try {
                        numPassageiros = sc.nextInt();
                        o.setNumPassageiros(numPassageiros);
                    } catch (Exception e) {
                        System.err.print(e.getMessage());
                        th.sleep(1000);
                    }
                System.out.println("Qual categoria: [1]Leito [2]Executivo [3]Convencional ");
                int op2 = sc.next().charAt(0);
                switch (op2){
                    case 1:
                        o.setCategoria(categoria1 = Categoria.valueOf(Categoria.LEITO.getDescricao()));
                        break;
                    case 2:
                        o.setCategoria(categoria1 = Categoria.valueOf(Categoria.EXECUTIVO.getDescricao()));
                        break;
                    case 3:
                        o.setCategoria(categoria1 = Categoria.valueOf(Categoria.CONVENCIONAL.getDescricao()));
                        break;
                }
                System.out.println("Serviço de Internet: s/n ");
                char alter2 = sc.next().charAt(0);
                switch (alter2){
                    case 's':
                        o.setServicoInternet(servicoInternet = true);
                        break;
                    case 'n':
                        o.setServicoInternet(servicoInternet = false);
                        break;
                }
                System.out.println("Ar condicionado: s/n ");
                alter = sc.next().charAt(0);
                switch (alter){
                    case 's':
                        o.setArCondicionado(arCondicionado = true);
                        break;
                    case 'n':
                        o.setArCondicionado(arCondicionado = false);
                        break;
                }
                break;
            case 3:
                System.out.println("Digite a placa do veículo a ser pesquisado: ");
                System.out.print("- ");
                placa = sc.nextLine();

                v = veiculos.get(placa);

                if (!veiculos.existe(placa)) { // cliente não encotrado
                    System.out.println("\nO veículo não foi encontrado.");
                } else {
                    System.out.println(v.toString());
                }
                System.out.print("\nValor diária: ");
                try {
                    valorDiaria = sc.nextDouble();
                    v.setValorDiaria(valorDiaria);
                } catch (Exception e) {
                    System.err.print(e.getMessage());
                    th.sleep(1000);
                }
                System.out.println("Número de Eixos: ");
                numEixos = sc.nextInt();
                c1.setNumEixos(numEixos);

                System.out.println("Número de Carga");
                cargaMax = sc.nextInt();
                c1.setCargaMax(cargaMax);

                break;
        }
        System.out.println(v.toString());

        System.out.println("\nDados alterado com sucesso");
    }
    public void getInfo(){
        System.out.println(veiculos.getInfo());
    }
    public void getInfoResumo(){
        System.out.println(veiculos.getResumoInfo());
    }
    public void excluir() throws Exception {
        Scanner sc = new Scanner(System.in);
        String v, placa;
        System.out.println("Digite a placa do veículo a ser pesquisado: ");
        System.out.print("- ");
        placa = sc.nextLine();

        v = veiculos.getInfo(placa);
        if (!veiculos.existe(placa)){
            System.out.println("\nO veículo não foi encontrado.");
        }else{
            System.out.println(v.toString());
            veiculos.remove(placa);
        }
    }
}
