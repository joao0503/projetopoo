package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import model.BO.ClienteBO;
import model.VO.AutomovelVO;
import model.VO.ClienteVO;
import view.Telas;

public class InfoClienteController {
    @FXML
    private TextField campoNomeCliente;
    @FXML
    private TextField campoEndereco;
    @FXML
    private TextField campoCPF;

    @FXML
    private TreeTableView<AutomovelVO> tabelaAutomoveis;

    @FXML
    private TreeTableColumn<AutomovelVO, String> colunaMarca;
    @FXML
    private TreeTableColumn<AutomovelVO, Integer> colunaAno;
    @FXML
    private TreeTableColumn<AutomovelVO, String> colunaPlaca;
    @FXML
    private TreeTableColumn<AutomovelVO, String> colunaCor;
    @FXML
    private TreeTableColumn<AutomovelVO, String> colunaQuilometragem;

    @FXML
    private Button botaoEditarCliente;
    @FXML
    private Button botaoEditarAutomovel;
    @FXML
    private Button botaoExcluirAutomovel;
    @FXML
    private Button botaoNovoRegistro;

    private ClienteVO cliente = new ClienteVO();

    
    public void setCliente(ClienteVO cliente) {
        try {
            this.cliente.setClienteId(cliente.getClienteId());
            this.cliente.setNome(cliente.getNome());
            this.cliente.setEndereco(cliente.getEndereco());
            this.cliente.setCpf(cliente.getCpf());
            
            campoNomeCliente.setText(cliente.getNome());
            campoEndereco.setText(cliente.getEndereco());
            campoCPF.setText(cliente.getCpf());
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

    public void atualizarCliente() {
        if (cliente != null) {
            
            String nomeTexto = campoNomeCliente.getText();
            String enderecoTexto = campoEndereco.getText();
            String cpfTexto = campoCPF.getText();

            try {
                cliente.setNome(nomeTexto);
                cliente.setEndereco(enderecoTexto);
                cliente.setCpf(cpfTexto);

                ClienteBO clienteBO = new ClienteBO();
                clienteBO.atualizar(cliente);

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Sucesso");
                alert.setContentText("O cliente foi atualizado com sucesso.");
                ButtonType ok = new ButtonType("OK", ButtonData.OK_DONE);
                alert.getButtonTypes().setAll(ok);
                alert.showAndWait();
                Telas.telaClientes();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void editarAutomovel() {

    }

    public void excluirAutomovel() {

    }

    public void addRegistro() {
        System.out.println("Novo registro");
    }
}
