package entidades;

import java.io.Serializable;

/**
 * Classe estende Veiculo, permite getters e setters nos atributos.
 * @author Marcelo Arrojo e Mateus Balda
 * @since 1.0
 */
public class Caminhao extends Veiculo implements Serializable {
    private int numEixos;
    private int cargaMax;

    public Caminhao(String placa, int ano, double valorDiaria, int numEixos, int cargaMax) {
        super(placa, ano, valorDiaria);
        this.numEixos = numEixos;
        this.cargaMax = cargaMax;
    }

    public int getNumEixos() {
        return numEixos;
    }

    public void setNumEixos(int numEixos) {
        this.numEixos = numEixos;
    }

    public int getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    @Override
    public String toString() {
        return super.toString()+"Caminhao{" +
                "numEixos=" + numEixos +
                ", cargaMax=" + cargaMax +
                '}';
    }
}
