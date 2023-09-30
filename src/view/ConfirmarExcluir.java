package view;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
public class ConfirmarExcluir extends Application{

    public static void main (String args[]){
        launch();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("VE/ConfirmarExcluir.fxml"));
        
        Scene cena = new Scene(root);

        primaryStage.setTitle("Confirmar Exclusão");
        primaryStage.setScene(cena);
        primaryStage.show();
    }
    
}
