package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.VO.PecaVO;
import view.Telas;

public class TelaPecasController extends TelaPrincipalController{

    @FXML private TextField searchBar;
    @FXML private TableView<PecaVO> tabelaPecas;
    @FXML private TableColumn<PecaVO, Integer> colunaQuantidade; // no PecaVO ta como int, ver se dá problema de compatibilidade
    @FXML private TableColumn<PecaVO, String> colunaNome;
    @FXML private TableColumn<PecaVO, String> colunaFabricante;
    @FXML private TableColumn<PecaVO, Double> colunaPreco;

    @FXML private Button botaoDetalhes;
    @FXML private Button botaoRemoverPeca;
    @FXML private Button botaoAddPeca;

    public void detalharPeca(ActionEvent event){
        System.out.println("detalhar peca");
    }

    public void addPeca(ActionEvent event) throws Exception{
        Telas.telaAdicionarPeca();

    }
    public void removerPeca(ActionEvent event){
        
    }
}
