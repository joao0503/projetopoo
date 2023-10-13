package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableView;

public class InfoClienteController {
    @FXML TextField campoNomeCLiente;
    @FXML TextField campoEndereco;
    @FXML TextField campoCPF;
    @FXML TreeTableView tabelaAutomoveis;

    public void novoRegistro(){
        System.out.println("Novo registro");
    }
}
