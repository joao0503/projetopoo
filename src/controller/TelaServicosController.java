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
import model.BO.ServicoBO;
import model.VO.ServicoVO;
import view.Telas;

public class TelaServicosController extends TelaPrincipalController implements Initializable{
    public ServicoBO servicoBO = new ServicoBO();
    @FXML private TextField searchBar;
    @FXML private TableView<ServicoVO> tabelaServicos;
    @FXML private TableColumn<ServicoVO, Long> id;
    @FXML private TableColumn<ServicoVO, String> colunaDescricao;
    @FXML private TableColumn<ServicoVO, Double> colunaValor;

    @FXML private Button botaoDetalhes;
    @FXML private Button botaoExcluirServico;
    @FXML private Button botaoNovoServico;

    ObservableList<ServicoVO> lista = FXCollections.observableArrayList();
    ObservableList<ServicoVO> todos = FXCollections.observableArrayList();

    public void initialize(URL location, ResourceBundle resources) {
    	id.setCellValueFactory(new PropertyValueFactory<>("servicoId"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        List<ServicoVO> servicos = new ArrayList<>();
        
        try {
            servicos = servicoBO.listarTodos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (servicos != null) {
            lista.addAll(servicos);
            tabelaServicos.setItems(lista);
            todos.addAll(servicos);
        } else {
            System.out.println("Deu erro confia.");
        }
    }

    public void detalharServico(ActionEvent event){
        
    }

    public void excluirServico(ActionEvent event){

    }

    public void addServico(ActionEvent event) throws Exception {
        Telas.telaAdicionarServico();
    }
}
