package src;

public class Servico {
	private String nome;
	private double valor;
	private int status;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if(nome != null && nome.equals("")) {
			this.nome = nome;
		} else {
			System.out.println("Nome inválido");
		}
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        if ( valor > 0  && valor < 10000){
            this.valor = valor;
        }
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        if(status < 0){
            System.out.println("Status inválido (não pode ser negativo)");
        }
        else {
            this.status = status;
        }
    }
}