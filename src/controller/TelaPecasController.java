package controller;

import javafx.event.ActionEvent;
import view.Telas;

public class TelaPecasController extends TelaPrincipalController{
    public void buscar(ActionEvent event){
        System.out.println("buscou");
    }

    public void addPeca(ActionEvent event) throws Exception{
        Telas.telaAdicionarPeca();

    }
    public void removerPeca(ActionEvent event){
        
    }
}
