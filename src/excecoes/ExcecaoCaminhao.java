/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package excecoes;

/**
 * Classe para validar exceções do caminhão
 * @author Marcelo Arrojo, Matheus Davila, Mateus Balda e João Paulo Merlugo
 * @since 1.0
 */
public class ExcecaoCaminhao {
    
    public static boolean dadosCaminhaoValido(String placa, int ano, double valorDiaria, int numEixos, int cargaMax) throws Exception{
        placaValida(placa);
        anoValido(ano);
        valorValido(valorDiaria);
        numEixosValido(numEixos);
        cargaMaxValida(cargaMax);
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
    
    public static boolean numEixosValido(int numEixos) throws Exception{
        if (numEixos <= 0 || numEixos > 9){
            throw new Exception("Número de Eixo Inválido!");
        }
        return true;
    }
    
    public static boolean cargaMaxValida(int cargaMax) throws Exception{
        if (cargaMax <= 0 || cargaMax > 74){
            throw new Exception("Número Máximo de Carga Excedido!");
        }
        return true;
    }
    
}
