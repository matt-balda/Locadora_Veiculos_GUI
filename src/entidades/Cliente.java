package entidades;

import java.io.Serializable;

/**
 * Classe que permite getters e setters dos atributos. 
 * @author Mateus Balda e Matheus D´Avila
 * @since 1.0
 */

public class Cliente implements Serializable {
    private String nome;
    private long CPF;
    private long numCarteiraMotorista;
    private String endereco;
    private long telefone;

    public Cliente(String nome, long CPF, long numCarteiraMotorista, String endereco, long telefone) {
        this.nome = nome;
        this.CPF = CPF;
        this.numCarteiraMotorista = numCarteiraMotorista;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    /**
     * Método para acessar String nome.
     * @return nome
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Método para alterar String nome
     * @param captura no parâmetro String nome
     * 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Método para acessar CPF
     * @return retorna long CPF 
     */
    public long getCPF() {
        return CPF;
    }
    
    /**
     * Método para alterar long CPF
     * @param captura no parâmetro long  CPF 
     */
    public void setCPF(long CPF) {
        this.CPF = CPF;
    }
    
    /**
     * Método para acessar numCarteiraMotorista
     * @return retorna long do número da carteira de motorista 
     */
    public long getNumCarteiraMotorista() {
        return numCarteiraMotorista;
    }
    
    /**
     * Método para alterar numCarteiraMotorista
     * @param captura no parâmetro long numCarteiraMotorista 
     */
    public void setNumCarteiraMotorista(long numCarteiraMotorista) {
        this.numCarteiraMotorista = numCarteiraMotorista;
    }
    
    /**
     * Método para acessar endereço
     * @return retorna String de endereço 
     */
    public String getEndereco() {
        return endereco;
    }
    
    /**
     * Método para alterar endereço
     * @param captura no parâmetro String endereco 
     */
    public void setEndereco(String endereco)  {
        this.endereco = endereco;
    }
    
    /**
     * Método para acessar telefone
     * @return retorna long telefone
     */
    public long getTelefone() {
        return telefone;
    }
    
    /**
     * Método para alterar telefone
     * @param captura no parâmetro long telefone 
     */
    public void setTelefone(long telefone)  {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", CPF=" + CPF +
                ", numCarteiraMotorista=" + numCarteiraMotorista +
                ", endereco='" + endereco + '\'' +
                ", telefone=" + telefone +
                '}';
    }
}
