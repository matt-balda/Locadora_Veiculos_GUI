/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excecoes;

/**
 *
 * Classe para validar exceções do cliente
 * @author Marcelo Arrojo, Matheus Davila, Mateus Balda e João Paulo Merlugo
 * @since 1.0
 */
public class ExcecaoCliente {
    
    public static boolean dadosClienteValido(String nome, long cpf, long numCarteiraMotorista, String endereco, long telefone) throws IllegalArgumentException{
        nomeValido(nome);
        cpfValido(cpf);
        numCarteiraMotoristaValido(numCarteiraMotorista);
        enderecoValido(endereco);
        telefoneValido(telefone);
        return true;
    }
    
    public static boolean nomeValido(String nome) throws IllegalArgumentException {
        if (nome == null || nome.isEmpty() || nome.matches("[0-9]*")) {
            throw new IllegalArgumentException("Nome inválido!");
        }
        return true;
    }
    public static boolean cpfValido(long cpf) throws IllegalArgumentException{
        if (cpf == 0 || cpf > 99999999999L){
            throw new IllegalArgumentException("CPF inválido!");
        }
        return true;
    }
    public static boolean numCarteiraMotoristaValido(long numCarteiraMotorista) throws IllegalArgumentException{
        if (numCarteiraMotorista <= 0 || numCarteiraMotorista > 99999999999L){
            throw new IllegalArgumentException("Número de Carteira inválido!");
        }
        return true;
    }
    public static boolean enderecoValido(String endereco) throws IllegalArgumentException{
        if (endereco == null || endereco.isEmpty()){
            throw new IllegalArgumentException("Endereço inválido!");
        }
        return true;
    }
    public static boolean telefoneValido(long telefone) throws IllegalArgumentException{
        if (telefone == 0 || telefone > 99999999999L){
            throw new IllegalArgumentException("Telefone inválido!");
        }
        return true;
    }
}
