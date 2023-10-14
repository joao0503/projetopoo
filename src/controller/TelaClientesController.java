package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import view.Telas;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;



public class TelaClientesController extends TelaPrincipalController{

    @FXML private TextField searchBar;
    @FXML private TableView tabelaClientes;
    @FXML private TableColumn Nome;
    @FXML private TableColumn Endereco;
    @FXML private TableColumn CPF;

    @FXML private Button botaoNovoCliente;
    @FXML private Button botaoDetalhesCliente;
    @FXML private Button botaoRemoverCliente;

    public void infoCliente(ActionEvent event){
        System.out.println("Info do cliente");
    }   

    public void removerCliente(ActionEvent event) {
        
    }   

    public void addCliente(ActionEvent event){

    }
}
