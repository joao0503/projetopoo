package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import view.Telas;

public class AdicionarServicoController {
    @FXML private TextField campoDescricao;
    @FXML private TextField campoPreco;

    @FXML private Button botaoAdicionarServico;
    @FXML private Button botaoVoltar;
    

    public void addServico(ActionEvent event){

    }
    public void voltarParaServicos(ActionEvent event) throws Exception {
        Telas.telaServicos();
    }
}
