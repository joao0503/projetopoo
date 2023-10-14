package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class InfoAutomovelController {
    @FXML private TextField campoMarca;
    @FXML private TextField campoAno;
    @FXML private TextField campoCor;
    @FXML private TextField campoQuilometragem;
    @FXML private TextField campoProprietário;
    @FXML private TextField campoPlaca;
    @FXML private TableView tabelaServicos;

    @FXML private TableColumn colunaDescricao;
    @FXML private TableColumn colunaValor;
    @FXML private TableColumn colunaStatus;
    @FXML private TableColumn colunaEncarregado;
    @FXML private TableColumn colunaPeca;

    @FXML private Button botaoEditarAuto;
    @FXML private Button botaoEditarServico;
    @FXML private Button botaoExcluirServico;
    @FXML private Button botaoAddServico;
    

    //método de editar info do automovel
    //método de editar serviço na lista
    //método de excluir serviço na lista
    //método de adicionar serviço

}
