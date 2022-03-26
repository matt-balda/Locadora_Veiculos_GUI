package teste;

import entidades.*;
import file.Arquivo;
import servicos.GerenciadorLocacoes;
import servicos.GerenciadorVeiculos;

import java.io.File;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class main2 {
    public static void main(String[] args) {
        GerenciadorLocacoes locacoes = new GerenciadorLocacoes();

        if (new File("locacoes.bin").exists()){
            try {
                locacoes = (GerenciadorLocacoes) Arquivo.ler("locacoes.bin");
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }

        GregorianCalendar gc = new GregorianCalendar(2022, Calendar.MARCH, 10);
        Date date = gc.getTime();

        GregorianCalendar gc1 = new GregorianCalendar(2022, Calendar.MARCH, 29);
        Date date1 = gc1.getTime();
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);

        Cliente c1 = new Cliente("oi", 123, 123, "casa", 12);
        Cliente c2 = new Cliente("Marcelinho", 128, 123, "Casarao", 190);
        Cliente c3 = new Cliente("Matheus", 4545, 8989, "Avenida", 191);

        Veiculo v1 = new Carro("BR456K",2010,150.00,4,2,1,true);
        Veiculo v2 = new Caminhao("POIO78",2015,500.00,4,10000);
        Veiculo v3 = new Onibus("TYTM8SA7",2018,800.00,30, Categoria.CONVENCIONAL,false, true);
        /**
         * Primeiro Método
         */
//        Locacao l1 = new Locacao(true, 150.00,date, date1,c1,v1);
//        Locacao l2 = new Locacao(false, 500.00,date,date1,c2,v2);
//        Locacao l3 = new Locacao(true, 800.00,date,date1,c3,v3);
//        locacoes.add(l1);
//        locacoes.add(l2);
//        locacoes.add(l3);

        /**
         * Segundo Método
         */
        //System.out.println(locacoes.get(1000));

        /**
         * Terceiro Método
         */
        //System.out.println(locacoes.getInfo(1000));

        /**
         * Quarto Método
         */
        System.out.println(locacoes.getInfo());

        /**
         * Quinto Método
         */
//        System.out.println(locacoes.set(1000,l1));
//        l1.setValorDiaria(1500.00);
//        System.out.println(locacoes.getInfo());
        /**
         * Sexto Método
         */
        //locacoes.remove(1000);

        /**
         * Sétimo Método
         */
//        System.out.println(locacoes.existe(1000));
//        System.out.println(locacoes.getInfo());
        try{
            Arquivo.gravar((Object) locacoes, "locacoes.bin");
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
