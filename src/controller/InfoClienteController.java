package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;

public class InfoClienteController {
    @FXML private TextField campoNomeCLiente;
    @FXML private TextField campoEndereco;
    @FXML private TextField campoCPF;

    @FXML private TreeTableView tabelaAutomoveis;

    @FXML private TreeTableColumn colunaMarca;
    @FXML private TreeTableColumn colunaAno;
    @FXML private TreeTableColumn colunaPlaca;
    @FXML private TreeTableColumn colunaCor;
    @FXML private TreeTableColumn colunaQuilometragem;

    @FXML private Button botaoEditarCliente;
    @FXML private Button botaoEditarAutomovel;
    @FXML private Button botaoExcluirAutomovel;  
    @FXML private Button botaoNovoRegistro;
    public void editarCliente(){

    }
    public void editarAutomovel(){

    }
    public void excluirAutomovel(){

    }
    public void addRegistro(){
        System.out.println("Novo registro");
    }
}
