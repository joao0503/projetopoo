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

    @FXML private TableColumn colunaMarca;
    @FXML private TableColumn colunaAno;
    @FXML private TableColumn colunaPlaca;
    @FXML private TableColumn colunaCor;
    @FXML private TableColumn colunaQuilometragem;
    @FXML private TableColumn colunaProprietario;

    @FXML private Button botaoDetalhesAutomovel;
    
    public void removerAutomovel(ActionEvent event){
        
    }

    public void infoAutomovel(ActionEvent event){
        
    }
}
