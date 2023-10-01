package controller;

import dao.UsuarioDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.entity.Funcionario;
import model.entity.Gerente;
import model.entity.Usuario;
import view.Telas;

public class UsuarioController {
	
	@FXML private TextField usuario;
	@FXML private TextField senha;
	@FXML private Label erroAutenticacao;
	//@FXML private Label esqueceuSenha;
	
	//@FXML private Label nomeUsuario;
	//@FXML private Label mensagemAutentic;
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
			// ex: UsuarioVO autenticado = usuBO.autenticar(usuar);
			Usuario autenticado = usuDAO.autent(usuar);
			System.out.println("O usuario autenticado é: " + autenticado.getUsuario() + " " + 
					autenticado.getSenha());
			autenticado.setNome("Ana");
			System.out.println("O nome do autenticado é: " + autenticado.getNome());
			if(autenticado instanceof Gerente) {
				System.out.println("Você é um gerente");
				
				Telas.telaPrincipalGerente(autenticado);
			}
			
			if(autenticado instanceof Funcionario) {
				System.out.println("Você é um funcionário");
				
				Telas.telaPrincipalFuncionario(autenticado);
			}
			
		} catch(Exception e) {
			System.out.println("Entrou no catch");
			erroAutenticacao.setText("Usuário ou senha incorretos!");
			erroAutenticacao.setVisible(true);
			e.printStackTrace();
		}
		
	}
	
	public void irParaTelaRecuperarSenha(MouseEvent event) throws Exception {
		try {
			System.out.println("Chegou aqui em irParaTelaRecuperarSenha");
			Telas.telaRecuperarSenha();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
