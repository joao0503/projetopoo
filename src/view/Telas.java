package view;

import controller.AdicionarAutomovelController;
import controller.InfoAutomovelController;
import controller.InfoClienteController;
import controller.InfoPecaController;
import controller.TelaPecasController;
import controller.TelaPrincipalController;
import controller.TelaServicosController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.VO.AutomovelVO;
import model.VO.ClienteVO;
import model.VO.PecaVO;
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
		FXMLLoader loader = new FXMLLoader(Telas.class.getResource("VE/TelaPrincipal.fxml"));
		Parent root = loader.load();
		TelaPrincipalController controller = loader.getController();
		controller.setTipoUsuario(usu.getTipoDeUsuario());

		
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
		FXMLLoader loader = new FXMLLoader(Telas.class.getResource("VE/TelaPrincipal.fxml"));
		Parent root = loader.load();
		TelaPrincipalController controller = loader.getController();
		controller.setTipoUsuario(usu.getTipoDeUsuario());

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

	public static void telaEditarCliente(ClienteVO cliente) throws Exception {
		FXMLLoader loader = new FXMLLoader(Telas.class.getResource("VE/InfoCliente.fxml"));
		Parent root = loader.load();

		InfoClienteController controller = loader.getController();
		
		controller.setCliente(cliente);

		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		cena.getWindow().centerOnScreen();
	}

	public static void telaAdicionarAutomovel(ClienteVO proprietario) throws Exception{
		FXMLLoader loader = new FXMLLoader(Telas.class.getResource("VE/AdicionarAutomovel.fxml"));
		Parent root = loader.load();

		AdicionarAutomovelController controller = loader.getController();
		controller.setProprietario(proprietario);

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
	
	public static void telaEditarAutomovel(AutomovelVO automovel) throws Exception{
		FXMLLoader loader = new FXMLLoader(Telas.class.getResource("VE/InfoAutomovel.fxml"));
		Parent root = loader.load();

		InfoAutomovelController controller = loader.getController();
		controller.setAutomovel(automovel);

		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		cena.getWindow().centerOnScreen();
	}

	public static void telaServicos(int tipoUsuario) throws Exception {
		FXMLLoader loader = new FXMLLoader(Telas.class.getResource("VE/TelaServicos.fxml"));
		Parent root = loader.load();
		TelaServicosController controller = loader.getController();
		controller.setPermissoes(tipoUsuario);
		
		Scene cena = new Scene(root);
		
		primaryStage.setScene(cena);
		cena.getWindow().centerOnScreen();
	}

	public static void telaAdicionarServico() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/AdicionarServico.fxml"));
		
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
	
	public static void telaPecas(int tipoUsuario) throws Exception {
		FXMLLoader loader = new FXMLLoader(Telas.class.getResource("VE/TelaPecas.fxml"));
		Parent root = loader.load();
		TelaPecasController controller = loader.getController();
		controller.setPermissoes(tipoUsuario);
		
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
	
	public static void telaEditarPeca(PecaVO peca) throws Exception {
		FXMLLoader loader = new FXMLLoader(Telas.class.getResource("VE/InfoPeca.fxml"));
		Parent root = loader.load();

		InfoPecaController controller = loader.getController();
		
		controller.setPeca(peca);

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
