package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.BO.AutomovelBO;
import model.VO.AutomovelVO;

public class TelaAutomoveisController extends TelaPrincipalController implements Initializable{
    @FXML private TextField SearchBar;
    @FXML private TableView<AutomovelVO> tabelaAutomoveis;

    @FXML private TableColumn<AutomovelVO, String> colunaMarca;
    @FXML private TableColumn<AutomovelVO, Integer> colunaAno;
    @FXML private TableColumn<AutomovelVO, String> colunaPlaca;
    @FXML private TableColumn<AutomovelVO, String> colunaCor;
    @FXML private TableColumn<AutomovelVO, Integer> colunaQuilometragem;
    @FXML private TableColumn<AutomovelVO, String> colunaProprietario;

    @FXML private Button botaoDetalhesAutomovel;
    
    ObservableList<AutomovelVO> lista = FXCollections.observableArrayList();
    ObservableList<AutomovelVO> todos = FXCollections.observableArrayList();

    public AutomovelBO automovelBO = new AutomovelBO();
    
    public void initialize(URL location, ResourceBundle resources) {
        colunaMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colunaAno.setCellValueFactory(new PropertyValueFactory<>("anoDoModelo"));
        colunaPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        colunaCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        colunaQuilometragem.setCellValueFactory(new PropertyValueFactory<>("quilometragem"));
        colunaProprietario.setCellValueFactory(new PropertyValueFactory<>("proprietario"));
        List<AutomovelVO> automoveis = new ArrayList<>();

        try {
            automoveis = automovelBO.listarTodos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (automoveis != null) {
            lista.addAll(automoveis);
            tabelaAutomoveis.setItems(lista);
            todos.addAll(automoveis);
        } else {
            System.out.println("Deu erro confia.");
        }
    }

    public void removerAutomovel(ActionEvent event){
        
    }

    public void infoAutomovel(ActionEvent event){
        
    }
}
