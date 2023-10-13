package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import view.Telas;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;



public class TelaClientesController extends TelaPrincipalController{

    @FXML private TextField searchBar;
    @FXML private TableView tabelaClientes;
    @FXML private Button botaoNovoCliente;

    public void buscar(ActionEvent event){

    }

    @FXML
    public void addCliente(ActionEvent event) throws Exception{
        Telas.telaAdicionarCliente();
    }   

    public void infoCliente(ActionEvent event){
        // criar popup de info do cliente
    }   
}
