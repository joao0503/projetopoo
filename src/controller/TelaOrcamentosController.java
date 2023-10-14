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
    @FXML private TableColumn colunaAutomovel;
    @FXML private TableColumn colunaPlaca;
    @FXML private TableColumn colunaCliente;
    @FXML private TableColumn colunaData;

    @FXML private Button botaoDetalhesOrcamento;

    public void infoOrcamento(ActionEvent event){
        
    }
}
