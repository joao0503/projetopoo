package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;

public class TelaAutomoveisController extends TelaPrincipalController{
    @FXML private TextField SearchBar;
    @FXML private TableView tabelaAutomoveis;

    @FXML private TableColumn Marca;
    @FXML private TableColumn Ano;
    @FXML private TableColumn Placa;
    @FXML private TableColumn Cor;
    @FXML private TableColumn Quilometragem;

    @FXML private Button botaoDetalhesAutomovel;
    
    public void removerAutomovel(ActionEvent event){
        
    }

    public void infoAutomovel(ActionEvent event){
        
    }
}
