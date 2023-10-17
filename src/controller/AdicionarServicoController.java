package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.BO.ServicoBO;
import model.VO.PecaVO;
import model.VO.ServicoVO;
import view.Telas;

public class AdicionarServicoController {
    @FXML private TextField campoNome;
    @FXML private TextField campoDescricao;
    @FXML private TextField campoValor;
    @FXML private ComboBox<String> menuPeca;

    @FXML private Button botaoAdicionarServico;
    @FXML private Button botaoVoltar;
    
    public void addServico(ActionEvent event){
        ServicoBO servicoBO = new ServicoBO();

        // fazer aparecer as peças no combobox e pegar o ID
        String nomeTexto = campoNome.getText();
        String descricaoTexto = campoDescricao.getText();
        String precoTexto = campoValor.getText();
        
        ServicoVO servico = new ServicoVO();
        servico.setNome(nomeTexto);
        servico.setDescricao(descricaoTexto);
        servico.setValor(Double.parseDouble(precoTexto));

        try {
            servicoBO.cadastrar(servico);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setContentText("O serviço foi adicionado com sucesso.");
            ButtonType ok = new ButtonType("OK", ButtonData.OK_DONE);
            alert.getButtonTypes().setAll(ok);
            alert.showAndWait();
            Telas.telaServicos(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void voltarParaServicos(ActionEvent event) throws Exception {
        Telas.telaServicos(1);
    }
}
