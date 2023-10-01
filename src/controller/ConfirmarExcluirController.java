package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ConfirmarExcluirController {

    @FXML private PasswordField senhaAdm;
    @FXML private Label labelErro;
    @FXML private Pane pane;  // tentativa de fechar a tela
    @FXML private Stage stage;

    
    
    public void excluir(ActionEvent event){

        // método de exclusão genérica?
            String sA = senhaAdm.getText();
            if (sA.equals("senha")){
                System.out.println("Excluído.");
                Info();
            }
            else{
                labelErro.setVisible(true);
                senhaAdm.clear();
                System.out.println("erro");
            }
            
    }

    public void fecharTela(){
        stage = (Stage) pane.getScene().getWindow(); // esse "pane" ta dando problema
        stage.close();
    }

    private void Info(){
        Alert popup = new Alert(Alert.AlertType.INFORMATION);
        popup.setTitle("Exclusão concluída");
        popup.setHeaderText("Exclusão bem sucedida!");
        popup.showAndWait();
    }
}
