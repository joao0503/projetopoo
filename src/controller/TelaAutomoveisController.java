package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.VO.AutomovelVO;

public class TelaAutomoveisController extends TelaPrincipalController{
    @FXML private TextField SearchBar;
    @FXML private TableView<AutomovelVO> tabelaAutomoveis;

    @FXML private TableColumn<AutomovelVO, String> colunaMarca;
    @FXML private TableColumn<AutomovelVO, String> colunaAno;
    @FXML private TableColumn<AutomovelVO, String> colunaPlaca;
    @FXML private TableColumn<AutomovelVO, String> colunaCor;
    @FXML private TableColumn<AutomovelVO, Integer> colunaQuilometragem;
    @FXML private TableColumn<AutomovelVO, String> colunaProprietario;

    @FXML private Button botaoDetalhesAutomovel;
    
    public void removerAutomovel(ActionEvent event){
        
    }

    public void infoAutomovel(ActionEvent event){
        
    }
}
