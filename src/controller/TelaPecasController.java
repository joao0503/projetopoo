package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import exception.InserirException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import model.BO.PecaBO;
import model.VO.PecaVO;
import view.Telas;

public class TelaPecasController extends TelaPrincipalController implements Initializable{

    @FXML private TextField searchBar;
    @FXML private TableView<PecaVO> tabelaPecas;
    @FXML private TableColumn<PecaVO, Double> colunaId;
    @FXML private TableColumn<PecaVO, Integer> colunaQuantidade;
    @FXML private TableColumn<PecaVO, String> colunaNome;
    @FXML private TableColumn<PecaVO, String> colunaFabricante;
    @FXML private TableColumn<PecaVO, Double> colunaPreco;

    @FXML private Button botaoDetalhes;
    @FXML private Button botaoRemoverPeca;
    @FXML private Button botaoAddPeca;

    private PecaBO pecaBO = new PecaBO();

    private static int tipoUsuario;

    ObservableList<PecaVO> lista = FXCollections.observableArrayList();
    ObservableList<PecaVO> todos = FXCollections.observableArrayList();

    public void setPermissoes(int tipo){
        if (tipo == 2){
            botaoDetalhes.setDisable(true);
            botaoAddPeca.setDisable(true);
            botaoRemoverPeca.setDisable(true);
        }
    }

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

    public void addPeca(ActionEvent event) throws Exception{
        Telas.telaAdicionarPeca();
    }

    public void detalharPeca(ActionEvent event) throws Exception{
        PecaVO peca = tabelaPecas.getSelectionModel().getSelectedItem();
        if (peca != null) {
            try {
                Telas.telaEditarPeca(peca);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void removerPeca(ActionEvent event) throws Exception{ //incompleto, pois depende de serviço por uma foreign key
        PecaVO peca = tabelaPecas.getSelectionModel().getSelectedItem();
        try{
            if (peca != null) {
                pecaBO.remover(peca);
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Sucesso");
                alert.setHeaderText("REMOVIDO COM SUCESSO");
                alert.setContentText("A peça foi removida com sucesso.");
                ButtonType ok = new ButtonType("OK", ButtonData.OK_DONE);
                alert.getButtonTypes().setAll(ok);
                alert.showAndWait();
            }
        } catch (InserirException iE){
            iE.printStackTrace();
        }
        Telas.telaPecas(tipoUsuario);
    }

    @FXML
    public void filtrar(KeyEvent event){
         String busca = searchBar.getText().toLowerCase(); // se quiser case sensitive, tirar lowercase

        if (busca.isEmpty()){
            tabelaPecas.setItems(lista);
        }
        else{
            List<PecaVO> resultados = new ArrayList<>();

            for (PecaVO peca : lista){
                if (String.valueOf(peca.getPecaId()).contains(busca)
                    || peca.getNome().toLowerCase().contains(busca)
                    || peca.getFabricante().toLowerCase().contains(busca)){
                    //|| peca.getPreco().toString().contains(busca)
                    //|| peca.getQuantidadePeca().toString().contains(busca)){
                        resultados.add(peca);
                }
            }

            ObservableList<PecaVO> resultadosObservable = FXCollections.observableArrayList();
            resultadosObservable.addAll(resultados);
            tabelaPecas.setItems(resultadosObservable);
        }
    }
}

