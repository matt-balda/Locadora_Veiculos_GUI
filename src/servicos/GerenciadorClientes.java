package servicos;

import entidades.Cliente;
import entidades.Locacao;
import implementos.IClientes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * Classe que permite a manipulação de um conjunto de clientes.
 * @author Marcelo Arrojo, Matheus Davila, Mateus Balda e João Paulo Merlugo
 * @since 1.0
 */
public class GerenciadorClientes implements IClientes, Serializable {
    private ArrayList<Cliente> clientes;

    public static GerenciadorClientes INSTANCE;
    
    public GerenciadorClientes() {
        INSTANCE = this;
        this.clientes = new ArrayList<>();
    }

    public GerenciadorClientes(ArrayList<Cliente> clientes){
        this.clientes = clientes;
    }

    @Override
    public void add(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public Cliente get(long CPF) throws Exception {
        for (Cliente c : clientes){
            if (c.getCPF() == CPF){
                return c;
            }
        }
        throw new Exception("Cliente não encontrado!");
    }
    
    public ArrayList<Cliente> getTodosClientes(){
        return clientes;
    }

    @Override
    public String getInfo(long CPF) throws Exception {
        for(Cliente c : clientes){
            if (c.getCPF() == CPF){
                return c.toString();
            }
        }
        throw new Exception("Cliente não encontrado!");
    }

    @Override
    public String getInfo() {
        final StringBuilder stringBuilder = new StringBuilder();
        if(clientes.size() == 0){
            return "Lista vazia!";
        }
        for (Cliente c : clientes) {
            stringBuilder.append(c.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String getResumoInfo() {
        final StringBuilder stringBuilder = new StringBuilder();
        if(clientes.size() == 0){
            return "Lista vazia!";
        }
        for (Cliente c: clientes) {
            stringBuilder.append("CPF: ");
            stringBuilder.append(c.getCPF());
            stringBuilder.append(" Nome: ");
            stringBuilder.append(c.getNome());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean set(long CPF, Cliente cliente) throws Exception {
        for (int i = 0; i<clientes.size(); i++) {
            if (clientes.get(i).getCPF() == CPF) {
                clientes.set(i, cliente);
                return true;
            }
        }
        throw new Exception("Cliente não encontrado!");
    }

    @Override
    public boolean remove(long CPF) throws Exception {
        for (Cliente c : clientes) {
            if (c.getCPF() == CPF) {
                clientes.remove(c);
                return true;
            }
        }
        throw new Exception("Cliente não encontrado!");
    }

    @Override
    public boolean existe(long CPF) {
        for (Cliente c : clientes){
            if (c.getCPF() == CPF){
                return true;
            }
        }
        return false;
    }
    public int size() throws Exception{
        if(clientes.size() == 0){
            throw new Exception("Lista vazia!");
        }
        return this.clientes.size();
    }
}
