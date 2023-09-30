package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import model.entity.Usuario;
import view.Telas;

public class RecuperarSenhaController {
	@FXML private TextField usuarioOuEmail;
	@FXML private Label mensagemVerificacao;
	
	public void voltarAoLogin(MouseEvent event) throws Exception {
		try {
			Telas.telaLogin();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void solicitarRecuperacao(ActionEvent event) throws Exception {
		// simulação de recuperação
		try {
			Usuario usu = new Usuario();
			usu.setUsuario(usuarioOuEmail.getText());
			System.out.println(usu.getUsuario());
			mensagemVerificacao.setText("Email de recuperação enviado para o email de: " 
			+ usu.getUsuario());
			mensagemVerificacao.setTextFill(Color.GREEN);
			mensagemVerificacao.setVisible(true);
			System.out.println("Chegou aqui em soliciatarRecuperacao");
			
		} catch(Exception e) {
			e.printStackTrace();
			
		}

	}
	
}
