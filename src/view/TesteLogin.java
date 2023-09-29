package view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.entity.Usuario;

public class TesteLogin extends Application {
	private static Stage primaryStage;
	
	@FXML static Label nomeUsuario;
	@FXML static Label mensagemAutentic;
	
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	public static void setPrimaryStage(Stage primaryStage) {
		TesteLogin.primaryStage = primaryStage;
	}
	public void start(Stage primaryStage) throws Exception {
		setPrimaryStage(primaryStage);
		primaryStage.setTitle("Oficina do Sr. Zezé");
		primaryStage.show();
		telaLogin();
	}
	
	public static void telaLogin() throws Exception {
		Parent root = FXMLLoader.load(TesteLogin.class.getResource("VE/LoginUsuario.fxml"));
		
		Scene cena = new Scene(root);
	
		primaryStage.setScene(cena);
	}
	
	public static void telaPrincipalGerente(Usuario usu) throws Exception{
		System.out.println("Chamando TelaPrincipal Gerente");
		Parent root = FXMLLoader.load(TesteLogin.class.getResource("VE/TelaPrincipal.fxml"));
		
		Scene cena = new Scene(root);
		
		System.out.println(usu.getNome());
		
		// ver qual o problema em nomeUsuario
		//nomeUsuario.setText(usu.getNome());
		//mensagemAutentic.setText("Gerente " + mensagemAutentic.getText());
		primaryStage.setScene(cena);
	}
	
	public static void telaPrincipalFuncionario(Usuario usu) throws Exception {
		System.out.println("Chamando TelaPrincipal Funcionário");
		Parent root = FXMLLoader.load(TesteLogin.class.getResource("VE/TelaPrincipal.fxml"));
		
		Scene cena = new Scene(root);
		
		System.out.println(usu.getNome());
		
		// ver qual o problema em nomeUsuario
		//nomeUsuario.setText(usu.getNome());
		//mensagemAutentic.setText("Funcionário " + mensagemAutentic.getText());
		
		primaryStage.setScene(cena);
	}
	
	public static void telaClientes() throws Exception {
		Parent root = FXMLLoader.load(TesteLogin.class.getResource("VE/TelaPrincipal.fxml"));
		
		Scene cena = new Scene(root);
		
		
		primaryStage.setScene(cena);
	}
	
	public static void telaAutomoveis() throws Exception {
		Parent root = FXMLLoader.load(TesteLogin.class.getResource("VE/TelaPrincipal.fxml"));
		
		Scene cena = new Scene(root);
		
		
		primaryStage.setScene(cena);
	}
	
	public static void telaServicos() throws Exception {
		Parent root = FXMLLoader.load(TesteLogin.class.getResource("VE/TelaPrincipal.fxml"));
		
		Scene cena = new Scene(root);
		
		
		primaryStage.setScene(cena);
	}
	
	public static void telaOrcamentos() throws Exception {
		Parent root = FXMLLoader.load(TesteLogin.class.getResource("VE/TelaPrincipal.fxml"));
		
		Scene cena = new Scene(root);
		
		
		primaryStage.setScene(cena);
	}
	
	public static void telaPecas() throws Exception {
		Parent root = FXMLLoader.load(TesteLogin.class.getResource("VE/TelaPrincipal.fxml"));
		
		Scene cena = new Scene(root);
		
		
		primaryStage.setScene(cena);
	}
	
	public static void telaLoginAut() throws Exception {
		Parent root = FXMLLoader.load(TesteLogin.class.getResource("VE/TelaPrincipal.fxml"));
		
		Scene cena = new Scene(root);
		
		
		primaryStage.setScene(cena);
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
