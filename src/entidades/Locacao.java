package entidades;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe que permite getters e setters dos atributos.
 * @author Marcelo Arrojo, Matheus Davila, Mateus Balda e João Paulo Merlugo
 * @since 1.0
 */

public class Locacao implements Serializable {
    private static int numeroGeral = 1000;
    private int codLocacao;
    private boolean seguro;
    private double valorDiaria;
    private Date dataInicial;
    private Date dataFinal;
    private Cliente cliente;
    private Veiculo veiculo;

    public Locacao(boolean seguro, double valorDiaria, Date dataInicial, Date dataFinal, Cliente cliente, Veiculo veiculo) {
        this.codLocacao = numeroGeral++;
        this.seguro = seguro;
        this.valorDiaria = valorDiaria;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.cliente = cliente;
        this.veiculo = veiculo;
    }

    public int getCodLocacao() {
        return codLocacao;
    }

    public void setCodLocacao(int codLocacao) {
        this.codLocacao = codLocacao;
    }

    public boolean isSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public String toString() {
        return "Locacao{" +
                "codLocacao=" + codLocacao +
                ", seguro=" + seguro +
                ", valorDiaria=" + valorDiaria +
                ", dataInicial=" + dataInicial +
                ", dataFinal=" + dataFinal +
                ", cliente=" + cliente +
                ", veiculo=" + veiculo +
                '}';
    }
}
