package teste;

import entidades.Categoria;
import arquivo.Arquivo;
import servicos.GerenciadorClientes;
import entidades.Cliente;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Main{

    //public static void main(String[] args) throws Exception {
          GerenciadorClientes clientes = new GerenciadorClientes();

          if (new File("clientes.bin").exists()){
              try {
                  clientes = (GerenciadorClientes) Arquivo.ler("clientes.bin");
              }catch (Exception e){
                  System.err.println(e.getMessage());
              }
          }

        /**
         *
         * Primeiro método V
         */
//        Cliente c1 = new Cliente("oi", 123, 123, "casa", 12);
//        Cliente c2 = new Cliente("Marcelinho", 128, 123, "Casarao", 190);
//        Cliente c3 = new Cliente("Matheus", 4545, 8989, "Avenida", 191);
//        clientes.add(c1);
//        clientes.add(c2);
//        clientes.add(c3);

        /**
         * Segundo método V
         */
        //System.out.println(clientes.get(123));

        /**
         * Terceiro método V
         */
        //System.out.println(clientes.getInfo(123));
        /**
         * Quarto método V
         */
       System.out.println(clientes.getInfo());

        /**
         * Quinta método V
         */
        //System.out.println(clientes.getResumoInfo());

        /**
         * Sexto método V
         */
        //System.out.println(clientes.set(123,c1));

        /**
         * Sétimo método V
         */
//         clientes.remove(123);

        /**
         * Oitavo método V
         */
//         System.out.println(clientes.existe(123));
//         System.out.println(clientes.getInfo());

//        try{
//            Arquivo.gravar((Object) clientes, "clientes.bin");
//        }catch (Exception e){
//            System.err.println("ERRO: "+e.getMessage());
//        }
    //}
}
