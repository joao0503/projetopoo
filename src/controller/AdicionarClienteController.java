package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;

public class AdicionarClienteController {
    @FXML private TextField campoNomeCLiente;
    @FXML private TextField campoEndereco;
    @FXML private TextField campoCPF;

    @FXML private TreeTableView tabelaAutomoveis;

    @FXML private TreeTableColumn Marca;
    @FXML private TreeTableColumn Ano;
    @FXML private TreeTableColumn Placa;
    @FXML private TreeTableColumn Cor;
    @FXML private TreeTableColumn Quilometragem;

    @FXML private Button botaoNovoAutomovel;
    @FXML private Button botaoAddCliente;
    @FXML private Button botaoVoltar;

    
    public void salvarCliente(ActionEvent event){
        System.out.println("add cliente"); 
    }

    public void addAutomovel(ActionEvent event){

    }

    public void voltarParaClientes(ActionEvent event){

    }
}
