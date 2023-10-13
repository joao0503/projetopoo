package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableView;

public class AdicionarClienteController {
    @FXML TextField campoNomeCLiente;
    @FXML TextField campoEndereco;
    @FXML TextField campoCPF;
    @FXML TreeTableView tabelaAutomoveis;
    
    public void salvarCliente(ActionEvent event){
        System.out.println("add cliente"); // falta basicamente tudo aqui
    }
}
