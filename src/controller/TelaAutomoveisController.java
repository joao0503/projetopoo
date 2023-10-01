package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TelaAutomoveisController extends TelaPrincipalController{
    @FXML TextField SearchBar;
    @FXML TableView tabelaAutomoveis;
    
    public void buscar(ActionEvent event){
        System.out.println("Chegou legal");
    }

    public void infoAutomovel(ActionEvent event){
        
    }
}
