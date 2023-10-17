package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import model.BO.PecaBO;
import model.VO.PecaVO;
import view.Telas;

public class AdicionarPecaController {
    @FXML private TextField campoNomePeca;
    @FXML private TextField campoQuantidade;
    @FXML private TextField campoFabricante;
    @FXML private TextField campoPreco;

    @FXML private Button botaoAdicionarPeca;
    @FXML private Button botaoVoltar;

    public void salvarPeca(ActionEvent event) {
        PecaBO pecaBO = new PecaBO();

        String nomeTexto = campoNomePeca.getText();
        String fabricanteTexto = campoFabricante.getText();
        String quantidadeTexto = campoQuantidade.getText();
        String precoTexto = campoPreco.getText();

        PecaVO peca = new PecaVO();
        peca.setNome(nomeTexto);
        peca.setFabricante(fabricanteTexto);
        peca.setQuantidadePeca(Integer.parseInt(quantidadeTexto));
        peca.setPreco(Double.parseDouble(precoTexto));

        try {
            pecaBO.cadastrar(peca);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setContentText("A peça foi adicionada com sucesso.");
            ButtonType ok = new ButtonType("OK", ButtonData.OK_DONE);
            alert.getButtonTypes().setAll(ok);
            alert.showAndWait();
            Telas.telaClientes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void voltarParaPecas(ActionEvent event) throws Exception {
        Telas.telaPecas();
    }
}
