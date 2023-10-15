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


public class InfoPecaController {
    @FXML
    private TextField campoNomePeca;
    @FXML
    private TextField campoQuantidade;
    @FXML
    private TextField campoFabricante;
    @FXML
    private TextField campoPreco;

    @FXML
    private Button botaoAtualizarPeca;
    @FXML
    private Button botaoVoltar;

    private PecaVO peca = new PecaVO();

    public void setPeca(PecaVO peca) {
        try {
            this.peca.setPecaId(peca.getPecaId());
            this.peca.setNome(peca.getNome());
            this.peca.setFabricante(peca.getFabricante());
            this.peca.setQuantidadePeca(peca.getQuantidadePeca());
            this.peca.setPreco(peca.getPreco());
            
            campoNomePeca.setText(peca.getNome());
            campoFabricante.setText(peca.getFabricante());
            campoQuantidade.setText(String.valueOf(peca.getQuantidadePeca()));
            campoPreco.setText(String.valueOf(peca.getPreco()));

        } catch (Exception e) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Erro");
            alert.setHeaderText("MORTE");
            alert.setContentText("DOR E SOFRIMENTO");
            ButtonType ok = new ButtonType("OK", ButtonData.OK_DONE);
            alert.getButtonTypes().setAll(ok);
            alert.showAndWait();
        }
    }

    public void atualizarPeca() {
        if (peca != null) {
            String nomeTexto = campoNomePeca.getText();
            String fabricanteTexto = campoFabricante.getText();
            String quantidadeTexto = campoQuantidade.getText();
            String precoTexto = campoPreco.getText();

            try {
                peca.setNome(nomeTexto);
                peca.setFabricante(fabricanteTexto);
                peca.setQuantidadePeca(Integer.parseInt(quantidadeTexto));
                peca.setPreco(Double.parseDouble(precoTexto));

                PecaBO pecaBO = new PecaBO();
                pecaBO.atualizar(peca);

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Sucesso");
                alert.setContentText("As informações da peça foram atualizadas com sucesso.");
                ButtonType ok = new ButtonType("OK", ButtonData.OK_DONE);
                alert.getButtonTypes().setAll(ok);
                alert.showAndWait();
                Telas.telaClientes();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void voltarTela(ActionEvent event) throws Exception{
        Telas.telaPecas();
    }
}
