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
import javafx.scene.input.KeyEvent;
import model.BO.ServicoBO;
import model.VO.ServicoVO;
import view.Telas;

public class TelaServicosController extends TelaPrincipalController implements Initializable{
    public ServicoBO servicoBO = new ServicoBO();
    @FXML private TextField searchBar;
    @FXML private TableView<ServicoVO> tabelaServicos;
    @FXML private TableColumn<ServicoVO, Long> id;
    @FXML private TableColumn<ServicoVO, String> colunaNome;
    @FXML private TableColumn<ServicoVO, String> colunaDescricao;
    @FXML private TableColumn<ServicoVO, Double> colunaValor;

    @FXML private Button botaoEditarServico;
    @FXML private Button botaoExcluirServico;
    @FXML private Button botaoNovoServico;

    ObservableList<ServicoVO> lista = FXCollections.observableArrayList();
    ObservableList<ServicoVO> todos = FXCollections.observableArrayList();

    public void setPermissoes(int tipo){
        if (tipo == 2){
            botaoExcluirServico.setDisable(true);
            botaoNovoServico.setDisable(true);
        }
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
    	id.setCellValueFactory(new PropertyValueFactory<>("servicoId"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
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

    public void excluirServico(ActionEvent event){
        ServicoVO servico = tabelaServicos.getSelectionModel().getSelectedItem();

        try{
            if (servico != null){
                servicoBO.remover(servico);
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Sucesso");
                alert.setHeaderText("REMOVIDO COM SUCESSO");
                alert.setContentText("O serviço foi removido com sucesso.");
                ButtonType ok = new ButtonType("OK", ButtonData.OK_DONE);
                alert.getButtonTypes().setAll(ok);
                alert.showAndWait();
            }
            else{
                System.out.println("Nenhum serviço foi passado para a deleção.");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addServico(ActionEvent event) throws Exception {
        Telas.telaAdicionarServico();
    }

    public void infoServico(ActionEvent event) throws Exception {
        ServicoVO servico = tabelaServicos.getSelectionModel().getSelectedItem();
        if (servico != null) {
            try {
                Telas.telaEditarServico(servico);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void filtrar(KeyEvent event){
        String busca = searchBar.getText().toLowerCase(); // se quiser case sensitive, tirar lowercase

        if (busca.isEmpty()){
            tabelaServicos.setItems(lista);
        }
        else{
            List<ServicoVO> resultados = new ArrayList<>();

            for (ServicoVO servico : lista){
                if (String.valueOf(servico.getServicoId()).contains(busca)
                    || servico.getNome().toLowerCase().contains(busca)){
                    //|| servico.getValor().toString().contains(busca))
                    //|| servico.getDescricao().toLowerCase().contains(busca)){
                        resultados.add(servico);
                }
            }

            ObservableList<ServicoVO> resultadosObservable = FXCollections.observableArrayList();
            resultadosObservable.addAll(resultados);
            tabelaServicos.setItems(resultadosObservable);
        }
    }
}
