package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import model.BO.AutomovelBO;
import model.VO.AutomovelVO;
import model.VO.ClienteVO;
import view.Telas;

public class AdicionarAutomovelController {
    @FXML private TextField campoMarca;
    @FXML private TextField campoAno;
    @FXML private TextField campoCor;
    @FXML private TextField campoQuilometragem;
    @FXML private TextField campoProprietario;
    @FXML private TextField campoPlaca;

    @FXML private Button botaoAdicionar;
    @FXML private Button botaoVoltar;

    private ClienteVO proprietario;

    public ClienteVO setProprietario(ClienteVO prop){
        if (prop != null){
            proprietario = prop;
            campoProprietario.setText(proprietario.getNome());
            return prop;
        }
        else{
            System.out.println("ID do proprietário nulo, adição cancelada.");
        }
        return null;
    }

    public void adicionarAutomovel(ActionEvent event){
        AutomovelBO autoBO = new AutomovelBO();

        String marcaText = campoMarca.getText();
        String anoText = campoAno.getText();
        String corText = campoCor.getText();
        String quilometragemText = campoQuilometragem.getText();
        String placaText = campoPlaca.getText();

        AutomovelVO automovel = new AutomovelVO();
        automovel.setMarca(marcaText);
        automovel.setAnoDoModelo(Integer.parseInt(anoText));
        automovel.setCor(corText);
        automovel.setQuilometragem(Integer.parseInt(quilometragemText));
        automovel.setPlaca(placaText);
        automovel.setCliente(proprietario);
        
        try{
            autoBO.cadastrar(automovel);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText("ADICIONADO COM SUCESSO");
            alert.setContentText("O automóvel foi adicionado com sucesso.");
            ButtonType ok = new ButtonType("OK", ButtonData.OK_DONE);
            alert.getButtonTypes().setAll(ok);
            alert.showAndWait();
            Telas.telaClientes();

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void voltarParaClientes(ActionEvent event) throws Exception{
        Telas.telaClientes();
    }
}
