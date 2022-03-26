package servicos;

import entidades.Cliente;
import entidades.Locacao;
import implementos.ILocacoes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * Classe que permite a manipulação de um conjunto de locações.
 * @author Marcelo Arrojo, Matheus Davila, Mateus Balda e João Paulo Merlugo
 * @since 1.0
 */

public class GerenciadorLocacoes implements ILocacoes, Serializable {
    
    private ArrayList<Locacao> locacoes;

     public static GerenciadorLocacoes INSTANCE;
    
    public GerenciadorLocacoes() {
        INSTANCE = this;
        this.locacoes = new ArrayList<>();
    }

    @Override
    public void add(Locacao locacao) {
        locacoes.add(locacao);
    }

    @Override
    public Locacao get(int codigo) throws Exception {
        for (Locacao l : locacoes){
            if (l.getCodLocacao() == codigo){
                return l;
            }
        }
        throw new Exception("Locação não encontrada!");
    }
    
    public ArrayList<Locacao> getTodosLocacoes(){
        return locacoes;
    }

    @Override
    public String getInfo(int codigo) throws Exception {
        for (Locacao l : locacoes){
            if (l.getCodLocacao() == codigo){
                return l.toString();
            }
        }
        throw new Exception("Locação não encontrada!");
    }

    @Override
    public String getInfo() {
        final StringBuilder stringBuilder = new StringBuilder();
        if (locacoes.size() == 0){
            return "Lista vazia!";
        }
        for(Locacao l : locacoes){
            stringBuilder.append(l.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean set(int codigo, Locacao locacao) throws Exception {
        for (int i = 0; i<locacoes.size(); i++) {
            if (locacoes.get(i).getCodLocacao() == codigo) {
                locacoes.set(i, locacao);
                return true;
            }
        }
        throw new Exception("Locação não encontrada!");
    }

    @Override
    public boolean remove(int codigo) throws Exception {
        for (Locacao l : locacoes){
            if (l.getCodLocacao() == codigo){
                locacoes.remove(l);
                return true;
            }
        }
        throw new Exception("Locação não encontrada!");
    }

    @Override
    public boolean existe(int codigo) {
        for (Locacao l : locacoes){
            if (l.getCodLocacao() == codigo){
                return true;
            }
        }
        return false;
    }
    
    public int size(){
        return this.locacoes.size();
    }
}
