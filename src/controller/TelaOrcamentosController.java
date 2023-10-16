package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import model.VO.OrcamentoVO;

public class TelaOrcamentosController extends TelaPrincipalController{

    // essa tabela ta pegando info de outros VO, então tem que mudar tudo aq dps
    @FXML private TextField searchBar;
    @FXML private TableView<OrcamentoVO> tabelaOrcamentos;
    @FXML private TableColumn<OrcamentoVO, String> colunaAutomovel;
    @FXML private TableColumn<OrcamentoVO, String> colunaPlaca;
    @FXML private TableColumn<OrcamentoVO, String> colunaCliente;
    //@FXML private TableColumn<OrcamentoVO, String> colunaData;
    

    @FXML private Button botaoDetalhesOrcamento;

    public void infoOrcamento(ActionEvent event){
        
    }

    public void filtrar(KeyEvent event){
        String busca = searchBar.getText().toLowerCase(); // se quiser case sensitive, tirar lowercase

        // dependente do initializer, que depende do sql dessa tabela
    }
}
