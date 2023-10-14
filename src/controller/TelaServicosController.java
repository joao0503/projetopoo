package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import view.Telas;

public class TelaServicosController extends TelaPrincipalController{

    @FXML private TextField searchBar;
    @FXML private TableView tabelaClientes;
    @FXML private TableColumn colunaDescricao;
    @FXML private TableColumn colunaValor;

    @FXML private Button botaoDetalhes;
    @FXML private Button botaoExcluirServico;
    @FXML private Button botaoNovoServico;

    public void detalharServico(ActionEvent event){
        System.out.println("buscou");
    }

    public void excluirServico(ActionEvent event){

    }

    public void addServico(ActionEvent event) throws Exception {
        Telas.telaAdicionarServico();
    }
}
