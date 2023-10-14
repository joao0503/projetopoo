package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TelaOrcamentosController extends TelaPrincipalController{

    @FXML private TextField searchBar;
    @FXML private TableView tabelaOrcamentos;
    @FXML private TableColumn Automovel;
    @FXML private TableColumn Placa;
    @FXML private TableColumn Cliente;
    @FXML private TableColumn Data;

    @FXML private Button botaoDetalhesOrcamento;

    public void infoOrcamento(ActionEvent event){
        
    }
}
