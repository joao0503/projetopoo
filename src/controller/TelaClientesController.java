package controller;
import view.Telas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import javafx.scene.control.Button;
import javafx.scene.control.TableView;


public class TelaClientesController extends TelaPrincipalController{

    @FXML private TextField searchBar;
    @FXML private TableView tabelaClientes;
    @FXML private Button botaoNovoCliente;

    public void buscar(ActionEvent event){

    }

    public void addCliente(ActionEvent event){
        // criar popup de adicionar cliente
    }   

    public void infoCliente(ActionEvent event){
        // criar popup de info do cliente
    }   
}
