/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package excecoes;

/**
 *
 * Classe para validar exceções da Locação
 * @author Marcelo Arrojo, Matheus Davila, Mateus Balda e João Paulo Merlugo
 * @since 1.0
 */
public class ExcecaoLocacao {
    
    public static boolean dadosLocacaoValido(double valorDiaria) throws Exception{
        valorValido(valorDiaria);
        return true;
    }
    
    public static boolean valorValido(double valorDiaria) throws Exception{
        if (valorDiaria <= 0){
            throw new Exception("Valor inválido!");
        }
        return true;
    }
}
