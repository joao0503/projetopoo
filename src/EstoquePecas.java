package src;

public class EstoquePecas {
    private Peca[] pecas;

    public EstoquePecas(Peca[] pecas) {
        setPecas(pecas);
    }

    public Peca[] getPecas() {
        return pecas;
    }

    public void setPecas(Peca[] pecas) { //Talvez falte coisa no set porém eu sou incapaz
        this.pecas = pecas;
    }
}
