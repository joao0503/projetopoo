package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import view.Telas;

public class AdicionarPecaController {
    @FXML private TextField campoNomeCLiente;
    @FXML private TextField campoEndereco;
    @FXML private TextField campoCPF;

    @FXML private Button botaoAdicionarPeca;
    @FXML private Button botaoVoltar;
    
    public void salvarPeca(ActionEvent event){
        System.out.println("salvar peca"); // falta basicamente tudo aqui
    }

    public void addPeca(ActionEvent event){

    }

    public void voltarParaPecas(ActionEvent event) throws Exception {
        Telas.telaPecas();
    }
}
