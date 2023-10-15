package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import model.BO.ClienteBO;
import model.VO.AutomovelVO;
import model.VO.ClienteVO;
import view.Telas;

public class AdicionarClienteController {
    @FXML private TextField campoNome;
    @FXML private TextField campoEndereco;
    @FXML private TextField campoCPF;

    @FXML private TreeTableView<AutomovelVO> tabelaAutomoveis;

    @FXML private TreeTableColumn<AutomovelVO, String> colunaMarca;
    @FXML private TreeTableColumn<AutomovelVO, String> colunaAno;
    @FXML private TreeTableColumn<AutomovelVO, String> colunaPlaca;
    @FXML private TreeTableColumn<AutomovelVO, String> colunaCor;
    @FXML private TreeTableColumn<AutomovelVO, Integer> colunaQuilometragem;

    @FXML private Button botaoNovoAutomovel;
    @FXML private Button botaoAddCliente;
    @FXML private Button botaoVoltar;

    
    public void salvarCliente(ActionEvent event) throws Exception{
        ClienteBO clienteBO = new ClienteBO();

        String nomeTexto = campoNome.getText();
        String enderecoTexto = campoEndereco.getText();
        String cpfTexto = campoCPF.getText();

        ClienteVO cliente = new ClienteVO();
        cliente.setNome(nomeTexto);
        cliente.setEndereco(enderecoTexto);
        cliente.setCpf(cpfTexto);

        try {
            clienteBO.cadastrar(cliente);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText("METIDO COM SUCESSO");
            alert.setContentText("O cliente foi metido com sucesso.");
            ButtonType ok = new ButtonType("OK", ButtonData.OK_DONE);
            alert.getButtonTypes().setAll(ok);
            alert.showAndWait();
            Telas.telaClientes();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addAutomovel(ActionEvent event){

    }

    public void voltarParaClientes(ActionEvent event) throws Exception {
        Telas.telaClientes();
    }
}
