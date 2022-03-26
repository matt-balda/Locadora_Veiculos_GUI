/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package excecoes;

/**
 *
 * Classe para validar exceções do carro
 * @author Marcelo Arrojo, Matheus Davila, Mateus Balda e João Paulo Merlugo
 * @since 1.0
 */
public class ExcecaoCarro {
    
    public static boolean dadosCarroValido(String placa, int ano, double valorDiaria, int numPassageiros, int numPortas, int mediaKMLitro) throws Exception{
        placaValida(placa);
        anoValido(ano);
        valorValido(valorDiaria);
        numPassageirosValido(numPassageiros);
        numPortasValido(numPortas);
        mediaKmValido(mediaKMLitro);
        return true;
    }
    
    public static boolean placaValida(String placa) throws Exception{
        if (placa == null || placa.isEmpty()){
            throw new Exception("Placa inválida!");
        }
        return true;
    }
    
    public static boolean anoValido(int ano) throws Exception{
        if (ano < 2000 || ano > 2022){
            throw new Exception("Ano inválido!");
        }
        return true;
    }
    
    public static boolean valorValido(double valorDiaria) throws Exception{
        if (valorDiaria <= 0){
            throw new Exception("Valor inválido!");
        }
        return true;
    }
    
    public static boolean numPassageirosValido(int numPassageiros) throws Exception{
        if (numPassageiros <= 0 || numPassageiros > 7){
            throw new Exception("Número de Passageiros inválido!");
        }
        return true;
    }
    
    public static boolean numPortasValido(int numPortas) throws Exception{
        if (numPortas <= 0 || numPortas > 5){
            throw new Exception("Número de Portas inválido!");
        }
        return true;
    }
    
    public static boolean mediaKmValido(int mediaKMLitro) throws Exception{
        if (mediaKMLitro <= 0 || mediaKMLitro > 100){
            throw new Exception("Número de Média por Litro inválido!");
        }
        return true;
    }
    
    public static String booleanToString(boolean value){
        return value? "Sim": "Não";
    }
    public static boolean stringToBoolean(String value){
        return value.equalsIgnoreCase("Sim");
    }
}
