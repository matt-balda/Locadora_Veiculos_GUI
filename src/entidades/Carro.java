package entidades;

import java.io.Serializable;

/**
 * Classe estende Veiculo, permite getters e setters dos atributos.
 * @author Mateus Balda e Matheus Davila
 * @since 1.0
 */
public class Carro extends Veiculo implements Serializable {
    private int numPassageiros;
    private int numPortas;
    private int mediaKMLitro;
    private boolean arCondicionado;

    public Carro(String placa, int ano, double valorDiaria, int numPassageiros, int numPortas, int mediaKMLitro, boolean arCondicionado) {
        super(placa, ano, valorDiaria);

        this.numPassageiros = numPassageiros;
        this.numPortas = numPortas;
        this.mediaKMLitro = mediaKMLitro;
        this.arCondicionado = arCondicionado;
    }

    public int getNumPassageiros() {
        return numPassageiros;
    }

    public void setNumPassageiros(int numPassageiros)  {
        this.numPassageiros = numPassageiros;
    }

    public int getNumPortas() {
        return numPortas;
    }

    public void setNumPortas(int numPortas)  {
        this.numPortas = numPortas;
    }

    public int getMediaKMLitro() {
        return mediaKMLitro;
    }

    public void setMediaKMLitro(int mediaKMLitro)  {
        this.mediaKMLitro = mediaKMLitro;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public String toString() {
        return super.toString() +"Carro{" +
                "numPassageiros=" + numPassageiros +
                ", numPortas=" + numPortas +
                ", mediaKMLitro=" + mediaKMLitro +
                ", arCondicionado=" + arCondicionado +
                '}';
    }
}
