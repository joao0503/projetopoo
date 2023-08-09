package src;

public class ListaServicos {
    private Servico[] lista;

    public ListaServicos(Servico[] lista) {
        setLista(lista);
    }

    public Servico[] getLista() {
        return lista;
    }

    public void setLista(Servico[] lista) { // Depois temos que montar a integridade do atributo "lista"
        this.lista = lista;                 // para preencher esse set aqui
    }
}
