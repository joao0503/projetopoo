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
import model.BO.PecaBO;
import model.VO.PecaVO;
import view.Telas;

public class TelaPecasController extends TelaPrincipalController implements Initializable{

    @FXML private TextField searchBar;
    @FXML private TableView<PecaVO> tabelaPecas;
    @FXML private TableColumn<PecaVO, Double> colunaId;
    @FXML private TableColumn<PecaVO, Integer> colunaQuantidade; // no PecaVO ta como int, ver se dá problema de compatibilidade
    @FXML private TableColumn<PecaVO, String> colunaNome;
    @FXML private TableColumn<PecaVO, String> colunaFabricante;
    @FXML private TableColumn<PecaVO, Double> colunaPreco;

    @FXML private Button botaoDetalhes;
    @FXML private Button botaoRemoverPeca;
    @FXML private Button botaoAddPeca;

    private PecaBO pecaBO = new PecaBO();

    ObservableList<PecaVO> lista = FXCollections.observableArrayList();
    ObservableList<PecaVO> todos = FXCollections.observableArrayList();

    public void initialize(URL location, ResourceBundle resources) {
        colunaId.setCellValueFactory(new PropertyValueFactory<>("pecaId"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidadePeca"));
        colunaFabricante.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
        colunaPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        
        List<PecaVO> pecas = new ArrayList<>();

        try {
            pecas = pecaBO.listarTodos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (pecas != null) {
            lista.addAll(pecas);
            tabelaPecas.setItems(lista);
            todos.addAll(pecas);
        } else {
            System.out.println("Deu erro confia.");
        }
    }

    public void detalharPeca(ActionEvent event) throws Exception{
        System.out.println("detalhar peca");
    }

    public void addPeca(ActionEvent event) throws Exception{
        Telas.telaAdicionarPeca();

    }
    public void removerPeca(ActionEvent event){
        
    }
}
