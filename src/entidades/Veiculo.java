package entidades;

import java.io.Serializable;

/**
 * Classe abstrata que permite getters e setters dos atributos.
 * @author Marcelo Arrojo e João Paulo Merlugo
 * @since 1.0
 */
public abstract class Veiculo implements Serializable {
    private String placa;
    private int ano;
    private double valorDiaria;

    public Veiculo(String placa, int ano, double valorDiaria) {
        this.placa = placa;
        this.ano = ano;
        this.valorDiaria = valorDiaria;
    }
    
    /**
     * Método para acessar placa
     * @return retorna String placa 
     */
    public String getPlaca() {
        return placa;
    }
    
    /**
     * Método para alterar placa
     * @param captura no parâmetro String placa
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    /**
     * Método para acessar ano
     * @return retorna int ano  
     */
    public int getAno() {
        return ano;
    }

    public void setAno(int ano)  {
        this.ano = ano;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }
    public void setValorDiaria(double valorDiaria)  {
        this.valorDiaria = valorDiaria;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + 
                "\nAno: " + ano +
                "\nValor da Diária: " + valorDiaria;
    }
}
