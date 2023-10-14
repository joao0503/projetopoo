package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import view.Telas;

public class TelaPecasController extends TelaPrincipalController{

    @FXML private TextField searchBar;
    @FXML private TableView tabelaPecas;
    @FXML private TableColumn Quantidade;
    @FXML private TableColumn Nome;
    @FXML private TableColumn Fabricante;
    @FXML private TableColumn Preco;

    @FXML private Button botaoDetalhes;
    @FXML private Button botaoRemoverPeca;
    @FXML private Button botaoAddPeca;

    public void detalharPeca(ActionEvent event){
        System.out.println("detalhar peca");
    }

    public void addPeca(ActionEvent event) throws Exception{
        Telas.telaAdicionarPeca();

    }
    public void removerPeca(ActionEvent event){
        
    }
}
