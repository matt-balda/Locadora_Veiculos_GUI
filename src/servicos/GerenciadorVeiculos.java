package servicos;

import entidades.Carro;
import entidades.Cliente;
import entidades.Veiculo;
import implementos.IVeiculos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * Classe que permite a manipulação de um conjunto de veiculos.
 * @author Marcelo Arrojo, Matheus Davila, Mateus Balda e João Paulo Merlugo
 * @since 1.0
 */

public class GerenciadorVeiculos implements IVeiculos, Serializable {
    
    private ArrayList<Veiculo> veiculos;

    public static GerenciadorVeiculos INSTANCE;
    
    public GerenciadorVeiculos() {
        INSTANCE = this;
        this.veiculos = new ArrayList<>();
    }

    @Override
    public void add(Veiculo veiculo) {
        veiculos.add(veiculo);
    }


    @Override
    public Veiculo get(String placa) throws Exception {
        for (Veiculo v : veiculos){
            if (v.getPlaca().equals(placa)){
                return v;
            }
        }
        throw new Exception("Veículo não encontrado!");
    }
    
    public ArrayList<Veiculo> getTodosVeiculos(){
        return veiculos;
    }

    @Override
    public String getInfo(String placa) throws Exception {
        for (Veiculo v : veiculos){
            if(v.getPlaca().equals(placa)){
                return v.toString();
            }
        }
        throw new Exception("Veículo não encontrado!");
    }

    @Override
    public String getInfo() {
        final StringBuilder stringBuilder = new StringBuilder();
        if (veiculos.size() == 0){
            return "Lista vazia!";
        }
        for (Veiculo v : veiculos){
            stringBuilder.append(v.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String getResumoInfo() {
        final StringBuilder stringBuilder = new StringBuilder();
        if (veiculos.size() == 0){
            return "Lista vazia!";
        }
        for (Veiculo v : veiculos){
            stringBuilder.append("Placa: ");
            stringBuilder.append(v.getPlaca());
            stringBuilder.append(" Ano: ");
            stringBuilder.append(v.getAno());
            stringBuilder.append(" Valor Diária: ");
            stringBuilder.append(v.getValorDiaria());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean set(String placa, Veiculo veiculo) throws Exception {
        for (int i = 0; i<veiculos.size(); i++) {
            if (veiculos.get(i).getPlaca().equals(placa)) {
                veiculos.set(i, veiculo);
                return true;
            }
        }
        throw new Exception("Veículo não encontrado!");
    }

    @Override
    public boolean remove(String placa) throws Exception {
        for (Veiculo v : INSTANCE.veiculos){
            if (v.getPlaca().equals(placa)){
                INSTANCE.veiculos.remove(v);
                return true;
            }
        }
        throw new Exception("Veículo não encontrado!");
    }

    @Override
    public boolean existe(String placa) {
        for (Veiculo v : veiculos){
            if (v.getPlaca().equals(placa)){
                return true;
            }
        }
        return false;
    }
    
    public int size() throws Exception{
        if (veiculos.size() == 0){
            throw new Exception("Lista vazia!");
        }
        return this.veiculos.size();
    }
}
