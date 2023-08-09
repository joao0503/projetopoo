package src;

public class Oficina {
	public static void main(String[] args) {
		
		System.out.println("Oficina mecânica");
		
		// Testando a validação do ano do carro que está no setter
		Automovel carro = new Automovel("Ford", 2020);
		System.out.println("Ano do carro é: " + carro.getAno());
	}
}
