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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import model.BO.ClienteBO;
import model.VO.ClienteVO;
import view.Telas;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TelaClientesController extends TelaPrincipalController implements Initializable {

    @FXML
    private TextField searchBar;
    @FXML
    private TableView<ClienteVO> tabelaClientes;
    @FXML
    private TableColumn<ClienteVO, Long> id;
    @FXML
    private TableColumn<ClienteVO, String> nome;
    @FXML
    private TableColumn<ClienteVO, String> endereco;
    @FXML
    private TableColumn<ClienteVO, String> cpf;

    @FXML
    private Button botaoNovoCliente;
    @FXML
    private Button botaoDetalhesCliente;
    @FXML
    private Button botaoRemoverCliente;

    public ClienteBO clienteBO = new ClienteBO();

    ObservableList<ClienteVO> lista = FXCollections.observableArrayList();
    ObservableList<ClienteVO> todos = FXCollections.observableArrayList();

    public void initialize(URL location, ResourceBundle resources) {
        // id.setCellValueFactory(new PropertyValueFactory<>("clienteId"));
        id.setCellValueFactory(new PropertyValueFactory<>("pessoaId"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        List<ClienteVO> clientes = new ArrayList<>();

        try {
            clientes = clienteBO.listarTodos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (clientes != null) {
            lista.addAll(clientes);
            tabelaClientes.setItems(lista);
            todos.addAll(clientes);
        } else {
            System.out.println("Deu erro confia.");
        }
    }

    public void addCliente(ActionEvent event) throws Exception {
        Telas.telaAdicionarCliente();
    }

    public void infoCliente(ActionEvent event) throws Exception {
        ClienteVO cliente = tabelaClientes.getSelectionModel().getSelectedItem();
        if (cliente != null) {
            try {
                System.out.println(cliente.getClienteId());
                Telas.telaEditarCliente(cliente);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void removerCliente(ActionEvent event) throws Exception {
        ClienteVO cliente = tabelaClientes.getSelectionModel().getSelectedItem();
        
        // consertar o banco de dados pra deletar os automoveis em cascade
        try{
            if (cliente != null) {
                clienteBO.remover(cliente);
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Sucesso");
                alert.setHeaderText("REMOVIDO COM SUCESSO");
                alert.setContentText("O cliente foi removido com sucesso.");
                ButtonType ok = new ButtonType("OK", ButtonData.OK_DONE);
                alert.getButtonTypes().setAll(ok);
                alert.showAndWait();
                
            }
        } catch (InserirException iE){
            iE.printStackTrace();
        }
        Telas.telaClientes();
    }

    @FXML
    private void filtrar(KeyEvent event){
        String busca = searchBar.getText().toLowerCase(); // se quiser case sensitive, tirar lowercase

        if (busca.isEmpty()){
            tabelaClientes.setItems(lista);
        }
        else{
            List<ClienteVO> resultados = new ArrayList<>();

            for (ClienteVO cliente : lista){
                if (String.valueOf(cliente.getPessoaId()).contains(busca)
                    || cliente.getNome().toLowerCase().contains(busca)
                    || cliente.getEndereco().toLowerCase().contains(busca)
                    || cliente.getCpf().contains(busca)){
                        resultados.add(cliente);
                }
            }

            ObservableList<ClienteVO> resultadosObservable = FXCollections.observableArrayList();
            resultadosObservable.addAll(resultados);
            tabelaClientes.setItems(resultadosObservable);
        }
    }
}
