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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.BO.ClienteBO;
import model.VO.ClienteVO;
import view.Telas;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TelaClientesController extends TelaPrincipalController implements Initializable{
    public ClienteBO clienteBO = new ClienteBO();

    @FXML private TextField searchBar;
    @FXML private TableView<ClienteVO> tabelaClientes;
    @FXML private TableColumn<ClienteVO, String> nome;
    @FXML private TableColumn<ClienteVO, String> endereco;
    @FXML private TableColumn<ClienteVO, String> cpf;

    @FXML private Button botaoNovoCliente;
    @FXML private Button botaoDetalhesCliente;
    @FXML private Button botaoRemoverCliente;

    ObservableList<ClienteVO> lista = FXCollections.observableArrayList();
    ObservableList<ClienteVO> todos = FXCollections.observableArrayList();

    public void initialize(URL location, ResourceBundle resources) {
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        System.out.println("pica2");
        List<ClienteVO> clientes = new ArrayList<>();

        try {
            clientes = clienteBO.listarTodos();
            for (ClienteVO cliente : clientes){
                System.out.println(cliente.getNome() + cliente.getDesconto());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (clientes != null) {
            lista.addAll(clientes);
            tabelaClientes.setItems(lista);
            todos.addAll(clientes);
        } else {
            System.out.println("pica3");
        }
    }

    public void addCliente(ActionEvent event) throws Exception{
        Telas.telaAdicionarCliente();
    }

    public void infoCliente(ActionEvent event){
        System.out.println("Info do cliente");
    }   

    public void removerCliente(ActionEvent event) {
        
    }   
}
