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
import model.BO.AutomovelBO;
import model.VO.AutomovelVO;
import view.Telas;

public class TelaAutomoveisController extends TelaPrincipalController implements Initializable{
    @FXML private TextField searchBar;
    @FXML private TableView<AutomovelVO> tabelaAutomoveis;

    @FXML private TableColumn<AutomovelVO, Long> id;
    @FXML private TableColumn<AutomovelVO, String> colunaMarca;
    @FXML private TableColumn<AutomovelVO, Integer> colunaAno;
    @FXML private TableColumn<AutomovelVO, String> colunaPlaca;
    @FXML private TableColumn<AutomovelVO, String> colunaCor;
    @FXML private TableColumn<AutomovelVO, Integer> colunaQuilometragem;
    @FXML private TableColumn<AutomovelVO, String> colunaProprietario;

    @FXML private Button botaoDetalhesAutomovel;
    @FXML private Button botaoRemoverAutomovel;
    
    ObservableList<AutomovelVO> lista = FXCollections.observableArrayList();
    ObservableList<AutomovelVO> todos = FXCollections.observableArrayList();

    public AutomovelBO automovelBO = new AutomovelBO();
    
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<>("automovelId"));
        colunaMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colunaAno.setCellValueFactory(new PropertyValueFactory<>("anoDoModelo"));
        colunaPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        colunaCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        colunaQuilometragem.setCellValueFactory(new PropertyValueFactory<>("quilometragem"));
        colunaProprietario.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        List<AutomovelVO> automoveis = new ArrayList<>();

        try {
            automoveis = automovelBO.listarTodos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (automoveis != null) {
            lista.addAll(automoveis);
            tabelaAutomoveis.setItems(lista);
            todos.addAll(automoveis);
        } else {
            System.out.println("Deu erro confia.");
        }
    }

    public void removerAutomovel(ActionEvent event) throws Exception{
        AutomovelVO automovel = tabelaAutomoveis.getSelectionModel().getSelectedItem();
        System.out.println(automovel.getAutomovelId());
        
        try{
            if (automovel != null) {
                 
                
                automovelBO.remover(automovel);
                System.out.println(automovel.getAutomovelId());
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Sucesso");
                alert.setHeaderText("REMOVIDO COM SUCESSO");
                alert.setContentText("O automóvel foi removido com sucesso.");
                ButtonType ok = new ButtonType("OK", ButtonData.OK_DONE);
                alert.getButtonTypes().setAll(ok);
                alert.showAndWait();
            }
        } catch (InserirException iE){
            iE.printStackTrace();
        }
        Telas.telaAutomoveis();
    }

    public void infoAutomovel(ActionEvent event){
        AutomovelVO automovel = tabelaAutomoveis.getSelectionModel().getSelectedItem();
        if (automovel != null){
            try{
                Telas.telaEditarAutomovel(automovel);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void filtrar(KeyEvent event){
        String busca = searchBar.getText().toLowerCase(); // se quiser case sensitive, tirar lowercase
        if (busca.isEmpty()){
            tabelaAutomoveis.setItems(lista);
        }
        else{
            List<AutomovelVO> resultados = new ArrayList<>();

            for (AutomovelVO automovel : lista){
                if (String.valueOf(automovel.getAutomovelId()).contains(busca)
                    //||automovel.getMarca().toLowerCase().contains(busca)
                    //||automovel.getCor().toLowerCase().contains(busca) 
                    ||automovel.getPlaca().toLowerCase().contains(busca)
                    ||automovel.getCliente().getNome().toLowerCase().contains(busca))
                    //||String.valueOf(automovel.getAnoDoModelo()).contains(busca))
                    {
                        resultados.add(automovel);
                }
            }

            ObservableList<AutomovelVO> resultadosObservable = FXCollections.observableArrayList();
            resultadosObservable.addAll(resultados);
            tabelaAutomoveis.setItems(resultadosObservable);
        }
    }
}
