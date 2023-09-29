package view;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Teste extends Application{
    public void start(Stage pS) throws Exception{
        Label msg = new Label();
        msg.setText("Hello World em JavaFX");

        Scene cena = new Scene(msg, 500, 300);

        pS.setTitle("Primeira tela");
        pS.setScene(cena);
        pS.show();
    }

    public static void main (String args[]){
        launch();
        System.out.println("pikaspikaspikas");
    }
}
