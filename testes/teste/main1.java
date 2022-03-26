package teste;

import entidades.*;
import arquivo.Arquivo;
import servicos.GerenciadorClientes;
import servicos.GerenciadorVeiculos;

import java.io.File;

public class main1 {
   // public static void main(String[] args) {
        GerenciadorVeiculos veiculos = new GerenciadorVeiculos();

        if (new File("veiculos.bin").exists()){
            try {
                veiculos = (GerenciadorVeiculos) Arquivo.ler("veiculos.bin");
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
        /**
         * Primeiro método V
         */
//        Veiculo v1 = new Carro("BR456K",2010,150.00,4,2,1,true);
//        Veiculo v2 = new Caminhao("POIO78",2015,500.00,4,10000);
//        Veiculo v3 = new Onibus("TYTM8SA7",2018,800.00,30, Categoria.CONVENCIONAL,false, true);
//        veiculos.add(v1);
//        veiculos.add(v2);
//        veiculos.add(v3);

        /**
         * Segundo método V
         */
        //System.out.println(veiculos.get("BR456K"));

        /**
         * Terceiro método V
         */
       // System.out.println(veiculos.getInfo("BR456K"));

        /**
         * Quarto método V
         */
        System.out.println(veiculos.getInfo());

        /**
         * Quinto método V
         */
       // System.out.println(veiculos.getResumoInfo());

        /**
         * Sexto método V
         */
//        System.out.println(veiculos.set("BR456K", v1));
//        v1.setValorDiaria(5000.00);
//        System.out.println(veiculos.getResumoInfo());

        /**
         * Sétimo método V
         */
        //veiculos.remove("BR456K");

        /**
         * Oitavo método V
         */
       // System.out.println(veiculos.existe("BR456K"));
        //System.out.println(veiculos.getInfo());

        try{
            Arquivo.gravar((Object) veiculos, "veiculos.bin");
        }catch (Exception e){
            System.err.println("ERRO; "+e.getMessage());
        }
   // }
}
