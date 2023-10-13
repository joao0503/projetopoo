package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableView;

public class AdicionarPecaController {
    @FXML TextField campoNomeCLiente;
    @FXML TextField campoEndereco;
    @FXML TextField campoCPF;
    
    public void salvarPeca(ActionEvent event){
        System.out.println("salvar peca"); // falta basicamente tudo aqui
    }
}
