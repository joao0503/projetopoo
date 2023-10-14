package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import view.Telas;

public class AdicionarClienteController {
    @FXML private TextField campoNomeCLiente;
    @FXML private TextField campoEndereco;
    @FXML private TextField campoCPF;

    @FXML private TreeTableView tabelaAutomoveis;

    @FXML private TreeTableColumn colunaMarca;
    @FXML private TreeTableColumn colunaAno;
    @FXML private TreeTableColumn colunaPlaca;
    @FXML private TreeTableColumn colunaCor;
    @FXML private TreeTableColumn colunaQuilometragem;

    @FXML private Button botaoNovoAutomovel;
    @FXML private Button botaoAddCliente;
    @FXML private Button botaoVoltar;

    
    public void salvarCliente(ActionEvent event){
        System.out.println("add cliente"); 
    }

    public void addAutomovel(ActionEvent event){

    }

    public void voltarParaClientes(ActionEvent event) throws Exception {
        Telas.telaClientes();
    }
}
