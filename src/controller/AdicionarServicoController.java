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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.BO.PecaBO;
import model.VO.PecaVO;
import model.BO.ServicoBO;
import model.VO.ServicoVO;
import view.Telas;

public class AdicionarServicoController implements Initializable{
    @FXML private TextField campoNome;
    @FXML private TextField campoDescricao;
    @FXML private TextField campoValor;

    @FXML
    private TableView<PecaVO> tabelaPeca;
    @FXML
    private TableColumn<PecaVO, Long> colunaId;
    @FXML
    private TableColumn<PecaVO, String> colunaNome;
    @FXML
    private TableColumn<PecaVO, String> colunaFabricante;
    @FXML
    private TableColumn<PecaVO, Integer> colunaQuantidade;
    @FXML
    private TableColumn<PecaVO, Double> colunaPreco;

    @FXML private Button botaoAdicionarServico;
    @FXML private Button botaoVoltar;

    public PecaBO pecaBO = new PecaBO();
    public ServicoBO servicoBO = new ServicoBO();

    ObservableList<PecaVO> lista = FXCollections.observableArrayList();
    ObservableList<PecaVO> todos = FXCollections.observableArrayList();

    @FXML
    public void initialize(URL location, ResourceBundle resources){
        colunaId.setCellValueFactory(new PropertyValueFactory<>("pecaId"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaFabricante.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
        colunaQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidadePeca"));
        colunaPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        List<PecaVO> pecas = new ArrayList<>();

        try{
            pecas = pecaBO.listarTodos();
        } catch (Exception e){
            e.printStackTrace();
        }
    
        if (pecas != null){
            lista.addAll(pecas);
            tabelaPeca.setItems(lista);
            todos.addAll(pecas);
        } else {
            System.out.println("Deu erro confia.");
        }
    }
    
    public void setServico(ServicoVO servico) {
        colunaId.setCellValueFactory(new PropertyValueFactory<>("pecaId"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaFabricante.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
        colunaQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidadePeca"));
        colunaPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        List<PecaVO> pecas = new ArrayList<>();

        try{
            pecas = pecaBO.listarTodos();
        } catch (Exception e){
            e.printStackTrace();
        }
    
        if (pecas != null){
            lista.addAll(pecas);
            tabelaPeca.setItems(lista);
            todos.addAll(pecas);
        }
    }


    public void addServico(ActionEvent event){
        ServicoBO servicoBO = new ServicoBO();

        String nomeTexto = campoNome.getText();
        String descricaoTexto = campoDescricao.getText();
        String precoTexto = campoValor.getText();
        
        ServicoVO servico = new ServicoVO();
        servico.setNome(nomeTexto);
        servico.setDescricao(descricaoTexto);
        servico.setValor(Double.parseDouble(precoTexto));

        try {
            servicoBO.cadastrar(servico);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setContentText("O serviço foi adicionado com sucesso.");
            ButtonType ok = new ButtonType("OK", ButtonData.OK_DONE);
            alert.getButtonTypes().setAll(ok);
            alert.showAndWait();
            Telas.telaServicos(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void voltarParaServicos(ActionEvent event) throws Exception {
        Telas.telaServicos(1);
    }
}
