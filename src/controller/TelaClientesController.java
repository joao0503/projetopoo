package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class TelaClientesController extends TelaPrincipalController{

    @FXML private TextField searchBar;
    @FXML private TableView tabelaClientes;
    @FXML private Button botaoNovoCliente;

    public void buscar(ActionEvent event){

    }

    public void addCliente(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/AdicionarCliente.fxml"));
		Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOpacity(1);
        stage.setTitle("Dor e Sofrimento");
		stage.setScene(new Scene(root));
		stage.show();
        // EU VOU CONSEGUIR CRIAR OUTRA JANELA VCS TEM QUE ACREDITAR EM MIM
    }   

    public void infoCliente(ActionEvent event){
        // criar popup de info do cliente
    }   
}
