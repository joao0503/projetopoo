package controller;

import dao.UsuarioDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entity.Funcionario;
import model.entity.Gerente;
import model.entity.Usuario;
import view.TesteLogin;

public class UsuarioController {
	
	@FXML private TextField usuario;
	@FXML private TextField senha;
	@FXML private Label erroAutenticacao;
	//@FXML private Button botaoEntrar;
	
	// instanciar aqui o bo para autenticar
	// generic que pode ser Funcionario
	UsuarioDAO<Usuario> usuDAO = new UsuarioDAO<Usuario>();
	public void autenticar(ActionEvent event) {
		Usuario usuar = new Usuario();
		usuar.setUsuario(usuario.getText());
		usuar.setSenha(senha.getText());
		System.out.println("O usuário em autenticar é: " + usuar.getUsuario() + " e a senha é: " 
		+ usuar.getSenha());
		
		// mandar o objeto usuar criado para o bo, quando ele for implementado 
		try {
			System.out.println("Entrou no try");
			// ex: UsuarioVO autenticado = usuBO.autenticar(usuar);
			Usuario autenticado = usuDAO.autent(usuar);
			System.out.println("O usuario autenticado é: " + autenticado.getUsuario() + " " + 
					autenticado.getSenha());
			System.out.println("Entrou no try depois de autenticado");
			autenticado.setNome("Ana");
			System.out.println("O nome do autenticado é: " + autenticado.getNome());
			if(autenticado instanceof Gerente) {
				System.out.println("Entrou em gerente");
				System.out.println("Você é um gerente");
				
				TesteLogin.telaPrincipalGerente(autenticado);
				
				//erroAutenticacao.setText("Gerente logado");
				//erroAutenticacao.setVisible(true);
			}
			
			if(autenticado instanceof Funcionario) {
				System.out.println("Entrou em funcionário");
				System.out.println("Você é um funcionário");
				
				TesteLogin.telaPrincipalFuncionario(autenticado);
				
				//erroAutenticacao.setText("Funcionário logado");
				//erroAutenticacao.setVisible(true);	
			}
			
		} catch(Exception e) {
			// colocar aqui uma exceção criada, se existir
			System.out.println("Entrou no catch");
			erroAutenticacao.setText("Usuário ou senha incorretos!");
			erroAutenticacao.setVisible(true);
			e.printStackTrace();
		}
		
	}
	
	public void irParaTelaClientes(ActionEvent event) throws Exception {
		TesteLogin.telaClientes();
	}
	
	public void irParaTelaAutomoveis(ActionEvent event) throws Exception {
		TesteLogin.telaAutomoveis();
	}
	
	public void irParaTelaServicos(ActionEvent event) throws Exception {
		TesteLogin.telaServicos();
	}
	
	public void irParaTelaOrcamentos(ActionEvent event) throws Exception {
		TesteLogin.telaOrcamentos();
	}
	
	public void irParaTelaPecas(ActionEvent event) throws Exception {
		TesteLogin.telaPecas();
	}
	
	public void irParaTelaLoginAut(ActionEvent event) throws Exception {
		TesteLogin.telaLoginAut();
	}
}
