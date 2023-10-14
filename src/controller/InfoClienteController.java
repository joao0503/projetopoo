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

    @FXML private TreeTableColumn Marca;
    @FXML private TreeTableColumn Ano;
    @FXML private TreeTableColumn Placa;
    @FXML private TreeTableColumn Cor;
    @FXML private TreeTableColumn Quilometragem;

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
