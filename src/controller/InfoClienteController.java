package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import model.VO.AutomovelVO;

public class InfoClienteController {
    @FXML private TextField campoNomeCLiente;
    @FXML private TextField campoEndereco;
    @FXML private TextField campoCPF;

    @FXML private TreeTableView<AutomovelVO> tabelaAutomoveis;

    @FXML private TreeTableColumn<AutomovelVO, String> colunaMarca;
    @FXML private TreeTableColumn<AutomovelVO, Integer> colunaAno;
    @FXML private TreeTableColumn<AutomovelVO, String> colunaPlaca;
    @FXML private TreeTableColumn<AutomovelVO, String> colunaCor;
    @FXML private TreeTableColumn<AutomovelVO, String> colunaQuilometragem;

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
