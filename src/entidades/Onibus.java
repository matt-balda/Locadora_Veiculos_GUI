package entidades;

import java.io.Serializable;

/**
 * Classe para manipular getters e setters dos atributos
 * @author Mateus Balda e Marcelo Arrojo
 * @since 1.0
 */
public class Onibus extends Veiculo implements Serializable {
    private int numPassageiros;
    private Categoria categoria;
    private boolean servicoInternet;
    private boolean arCondicionado;

    public Onibus(String placa, int ano, double valorDiaria, int numPassageiros, Categoria categoria, boolean servicoInternet, boolean arCondicionado) {
        super(placa, ano, valorDiaria);
        this.numPassageiros = numPassageiros;
        this.categoria = categoria;
        this.servicoInternet = servicoInternet;
        this.arCondicionado = arCondicionado;
    }

    public int getNumPassageiros() {
        return numPassageiros;
    }

    public void setNumPassageiros(int numPassageiros) {
        this.numPassageiros = numPassageiros;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isServicoInternet() {
        return servicoInternet;
    }

    public void setServicoInternet(boolean servicoInternet) {
        this.servicoInternet = servicoInternet;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public String toString() {
        return super.toString()+"Onibus{" +
                "numPassageiros=" + numPassageiros +
                ", categoria=" + categoria.getDescricao() +
                ", servicoInternet=" + servicoInternet +
                ", arCondicionado=" + arCondicionado +
                '}';
    }
}
