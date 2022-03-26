/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package excecoes;

/**
 *
 * Classe para validar exceções do Ônibus
 * @author Marcelo Arrojo, Matheus Davila, Mateus Balda e João Paulo Merlugo
 * @since 1.0
 */
public class ExcecaoOnibus {
    
    public static boolean dadosOnibusValido(String placa, int ano, double valorDiaria, int numPassageiros) throws Exception{
        placaValida(placa);
        anoValido(ano);
        valorValido(valorDiaria);
        numPassageirosValido(numPassageiros);
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
        if (numPassageiros <= 0 || numPassageiros > 45){
            throw new Exception("Número de Passageiros Excedido!");
        }
        return true;
    }
}
