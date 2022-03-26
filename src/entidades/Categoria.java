package entidades;

import java.io.Serializable;

/**
 * Classe para acessar 3 tipos de string diferente
 * @author Mateus Balda
 * @since 1.0
 */
public enum Categoria implements Serializable {
    LEITO("Leito"),
    EXECUTIVO("Executivo"),
    CONVENCIONAL("Convencional");

    private String descricao;

    Categoria(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return descricao;
    }
}
