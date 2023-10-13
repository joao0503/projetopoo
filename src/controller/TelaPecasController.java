package controller;

import javafx.event.ActionEvent;
import view.Telas;

public class TelaPecasController extends TelaPrincipalController{
    public void detalharPeca(ActionEvent event){
        System.out.println("detalhar peca");
    }

    public void addPeca(ActionEvent event) throws Exception{
        Telas.telaAdicionarPeca();

    }
    public void removerPeca(ActionEvent event){
        
    }
}
