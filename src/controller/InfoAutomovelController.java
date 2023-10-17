package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import model.BO.AutomovelBO;
import model.VO.AutomovelVO;
import model.VO.ServicoVO;
import view.Telas;

public class InfoAutomovelController {
    @FXML private TextField campoMarca;
    @FXML private TextField campoAno;
    @FXML private TextField campoCor;
    @FXML private TextField campoQuilometragem;
    @FXML private TextField campoProprietario;
    @FXML private TextField campoPlaca;
    @FXML private TableView<ServicoVO> tabelaServicos;

    @FXML private TableColumn<ServicoVO, String> colunaDescricao;
    @FXML private TableColumn<ServicoVO, Double> colunaValor;
    @FXML private TableColumn<ServicoVO, String> colunaStatus;
    @FXML private TableColumn<ServicoVO, String> colunaEncarregado;
    @FXML private TableColumn<ServicoVO, String> colunaPeca;

    @FXML private Button botaoEditarAuto;
    @FXML private Button botaoVoltar;
    @FXML private Button botaoEditarServico;
    @FXML private Button botaoExcluirServico;
    @FXML private Button botaoAddServico;
    
    public AutomovelVO automovel = new AutomovelVO();

    public void setAutomovel(AutomovelVO automovel){
        try{
            this.automovel.setAutomovelId(automovel.getAutomovelId());
            this.automovel.setMarca(automovel.getMarca());
            this.automovel.setAnoDoModelo(automovel.getAnoDoModelo());
            this.automovel.setCor(automovel.getCor());
            this.automovel.setQuilometragem(automovel.getQuilometragem());
            this.automovel.setPlaca(automovel.getPlaca());
            this.automovel.setCliente(automovel.getCliente());

            campoMarca.setText(automovel.getMarca());
            campoAno.setText(String.valueOf(automovel.getAnoDoModelo()));
            campoCor.setText(automovel.getCor());
            campoQuilometragem.setText(String.valueOf(automovel.getQuilometragem()));
            campoPlaca.setText(automovel.getPlaca());
            campoProprietario.setText(automovel.getCliente().getNome());

        } catch (Exception e){
            e.printStackTrace();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Erro");
            alert.setHeaderText("MORTE");
            alert.setContentText("DOR E SOFRIMENTO");
            ButtonType ok = new ButtonType("OK", ButtonData.OK_DONE);
            alert.getButtonTypes().setAll(ok);
            alert.showAndWait();
        }
    }

    public void atualizarAutomovel() throws Exception{
        if(automovel != null){

            String marcaText = campoMarca.getText();
            String anoText = campoAno.getText();
            String corText = campoCor.getText();
            String quilometragemText = campoQuilometragem.getText();
            String placaText = campoPlaca.getText();

            try{
                automovel.setMarca(marcaText);
                automovel.setAnoDoModelo(Integer.parseInt(anoText));
                automovel.setCor(corText);
                automovel.setQuilometragem(Integer.parseInt(quilometragemText));
                automovel.setPlaca(placaText);

                AutomovelBO autoBO = new AutomovelBO();
                autoBO.atualizar(automovel);
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Sucesso");
                alert.setContentText("O automovel foi atualizado com sucesso.");
                ButtonType ok = new ButtonType("OK", ButtonData.OK_DONE);
                alert.getButtonTypes().setAll(ok);
                alert.showAndWait();
                Telas.telaAutomoveis();
            }  catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    
    
    public void voltarParaAutomoveis(ActionEvent event) throws Exception{
        Telas.telaAutomoveis();
    }

    public void novoServico(ActionEvent event) throws Exception{
        Telas.telaAdicionarServico();
    }

    public void excluirServico(ActionEvent event) throws Exception{

    }
}
