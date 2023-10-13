package view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.VO.UsuarioVO;

public class Telas extends Application {
	private static Stage primaryStage;
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	public static void setPrimaryStage(Stage primaryStage) {
		Telas.primaryStage = primaryStage;
	}
	public void start(Stage primaryStage) throws Exception {
		setPrimaryStage(primaryStage);
		primaryStage.setTitle("Oficina do Sr. Zezé");
		primaryStage.show();
		telaLogin();
	}
	
	public static void telaLogin() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/LoginUsuario.fxml"));
		
		Scene cena = new Scene(root);
	
		primaryStage.setScene(cena);
		cena.getWindow().centerOnScreen();
	}
	
	public static void telaRecuperarSenha() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/RecuperarSenha.fxml"));
		
		Scene cena = new Scene(root);
	
		primaryStage.setScene(cena);
		cena.getWindow().centerOnScreen();
	}
	
	public static void telaPrincipalGerente(UsuarioVO usu) throws Exception {
		System.out.println("Chamando TelaPrincipal Gerente");
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaPrincipal.fxml"));
		
		Scene cena = new Scene(root);
		
		//System.out.println(usu.getNome());
		
		// ver qual o problema em nomeUsuario
		//nomeUsuario.setText(usu.getNome());
		//mensagemAutentic.setText("Gerente " + mensagemAutentic.getText());
		primaryStage.setScene(cena);
		cena.getWindow().centerOnScreen();
	}
	
	public static void telaPrincipalFuncionario(UsuarioVO usu) throws Exception {
		System.out.println("Chamando TelaPrincipal Funcionário");
		
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaPrincipal.fxml"));

		Scene cena = new Scene(root);
		
		//nomeUsuario.setText("Funcionário Teste");
		//mensagemAutentic.setText("Autenticado");
		//System.out.println(usu.getNome());
		
		// ver qual o problema em nomeUsuario
		//nomeUsuario.setText(usu.getNome());
		//mensagemAutentic.setText("Funcionário " + mensagemAutentic.getText());
		
		primaryStage.setScene(cena);
		cena.getWindow().centerOnScreen();
	}
	
	public static void telaClientes() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaClientes.fxml"));
		
		Scene cena = new Scene(root);

		primaryStage.setScene(cena);
		cena.getWindow().centerOnScreen();

		
	}

	public static void telaAdicionarCliente() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/AdicionarCliente.fxml"));
		
		Scene cena = new Scene(root);
	
		primaryStage.setScene(cena);
		cena.getWindow().centerOnScreen();
	}
	
	public static void telaAutomoveis() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaAutomoveis.fxml"));
		
		Scene cena = new Scene(root);
		
		
		primaryStage.setScene(cena);
		cena.getWindow().centerOnScreen();
	}
	
	public static void telaServicos() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaServicos.fxml"));
		
		Scene cena = new Scene(root);
		
		
		primaryStage.setScene(cena);
		cena.getWindow().centerOnScreen();
	}
	
	public static void telaOrcamentos() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaOrcamentos.fxml"));
		
		Scene cena = new Scene(root);
		
		
		primaryStage.setScene(cena);
		cena.getWindow().centerOnScreen();
	}
	
	public static void telaPecas() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaPecas.fxml"));
		
		Scene cena = new Scene(root);
		
		
		primaryStage.setScene(cena);
		cena.getWindow().centerOnScreen();
	}

	public static void telaAdicionarPeca() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/AdicionarPeca.fxml"));
		
		Scene cena = new Scene(root);
		
		
		primaryStage.setScene(cena);
		cena.getWindow().centerOnScreen();
	}
	
	public static void telaLoginAut() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaPrincipal.fxml"));
		
		Scene cena = new Scene(root);
		

		primaryStage.setScene(cena);
		cena.getWindow().centerOnScreen();
	}
	

	public static void main(String ... args) {
		launch();
	}
}



/*public class TesteLogin extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("VE/LoginUsuario.fxml"));
		
		Scene cena = new Scene(root);
		
		primaryStage.setTitle("Oficina do Sr.Zé");
		primaryStage.setScene(cena);
		primaryStage.show();
		// implementar o controller
	}

}*/
