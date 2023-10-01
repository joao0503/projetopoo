package controller;

import javafx.scene.input.MouseEvent;
import view.Telas;

public class TelaPrincipalController{
	
	public void irParaTelaClientes(MouseEvent event) throws Exception {
		Telas.telaClientes();
	}
	
	public void irParaTelaAutomoveis(MouseEvent event) throws Exception {
		Telas.telaAutomoveis();
	}
	
	public void irParaTelaServicos(MouseEvent event) throws Exception {
		Telas.telaServicos();
	}
	
	public void irParaTelaOrcamentos(MouseEvent event) throws Exception {
		Telas.telaOrcamentos();
	}
	
	public void irParaTelaPecas(MouseEvent event) throws Exception {
		Telas.telaPecas();
	}
	
	public void irParaTelaLoginAut(MouseEvent event) throws Exception {
		Telas.telaLoginAut();
	}
	
	public void irParaTelaLogin(MouseEvent event) throws Exception {
		Telas.telaLogin();
	}
}
