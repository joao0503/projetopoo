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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.BO.AutomovelBO;
import model.BO.ClienteBO;
import model.VO.AutomovelVO;
import model.VO.ClienteVO;
import view.Telas;

public class InfoClienteController implements Initializable{
    @FXML
    private TextField campoNomeCliente;
    @FXML
    private TextField campoEndereco;
    @FXML
    private TextField campoCPF;

    @FXML
    private TableView<AutomovelVO> tabelaAutomoveis;


    @FXML
    private TableColumn<AutomovelVO, Long> id;
    @FXML
    private TableColumn<AutomovelVO, String> colunaMarca;
    @FXML
    private TableColumn<AutomovelVO, Integer> colunaAno;
    @FXML
    private TableColumn<AutomovelVO, String> colunaPlaca;
    @FXML
    private TableColumn<AutomovelVO, String> colunaCor;
    @FXML
    private TableColumn<AutomovelVO, String> colunaQuilometragem;

    @FXML
    private Button botaoEditarCliente;
    @FXML
    private Button botaoEditarAutomovel;
    @FXML
    private Button botaoExcluirAutomovel;
    @FXML
    private Button botaoNovoRegistro;

    private ClienteVO cliente = new ClienteVO();
    public AutomovelBO automovelBO = new AutomovelBO();

    ObservableList<AutomovelVO> lista = FXCollections.observableArrayList();
    ObservableList<AutomovelVO> todos = FXCollections.observableArrayList();

    @FXML
    public void initialize(URL location, ResourceBundle resources){
        // espero que funcione
    }
    
    public void setCliente(ClienteVO cliente) {
        try {
            id.setCellValueFactory(new PropertyValueFactory<>("automovelId"));
            this.cliente.setNome(cliente.getNome());
            this.cliente.setEndereco(cliente.getEndereco());
            this.cliente.setCpf(cliente.getCpf());
            // o erro era que faltava setar o pessoaId para fazer a consulta
            this.cliente.setPessoaId(cliente.getPessoaId());
            
            campoNomeCliente.setText(cliente.getNome());
            campoEndereco.setText(cliente.getEndereco());
            campoCPF.setText(cliente.getCpf());
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Erro");
            alert.setHeaderText("MORTE");
            alert.setContentText("DOR E SOFRIMENTO");
            ButtonType ok = new ButtonType("OK", ButtonData.OK_DONE);
            alert.getButtonTypes().setAll(ok);
            alert.showAndWait();
        }


        //populando a tabela de automóveis do cliente
        colunaMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colunaCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        colunaAno.setCellValueFactory(new PropertyValueFactory<>("anoDoModelo"));
        colunaCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        colunaPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        colunaQuilometragem.setCellValueFactory(new PropertyValueFactory<>("quilometragem"));
        List<AutomovelVO> automoveis = new ArrayList<>();

        try{

            automoveis = automovelBO.buscarPorCliente(cliente);
        } catch (Exception e){
            e.printStackTrace();
        }
    
        if (automoveis != null){
            lista.addAll(automoveis);
            tabelaAutomoveis.setItems(lista);
            todos.addAll(automoveis);
        }
        else{
            System.out.println("Ocorreu um problema ao popular a tabela");
        }
    }

    public void atualizarCliente() {
    	System.out.println("O pessoaId em infoCliente é: " + cliente.getPessoaId()
    	+"o clienteId é: "+ cliente.getClienteId());
        if (cliente != null) {
            
            String nomeTexto = campoNomeCliente.getText();
            String enderecoTexto = campoEndereco.getText();
            String cpfTexto = campoCPF.getText();

            try {
                cliente.setNome(nomeTexto);
                cliente.setEndereco(enderecoTexto);
                cliente.setCpf(cpfTexto);

                ClienteBO clienteBO = new ClienteBO();
                clienteBO.atualizar(cliente);

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Sucesso");
                alert.setContentText("O cliente foi atualizado com sucesso.");
                ButtonType ok = new ButtonType("OK", ButtonData.OK_DONE);
                alert.getButtonTypes().setAll(ok);
                alert.showAndWait();
                Telas.telaClientes();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void voltarParaClientes(ActionEvent event) throws Exception{
        Telas.telaClientes();
    }

    public void editarAutomovel() {

    }

    public void excluirAutomovel() {

    }

    public void addRegistro() {
        System.out.println("Novo registro");
    }
}
