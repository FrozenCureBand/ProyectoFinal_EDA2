import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	  public void start(Stage primaryStage) throws IOException {
	    try {
	    	Parent root1 = FXMLLoader.load(getClass().getResource("UneParser.fxml"));
	    	Scene scene = new Scene(root1);
	    	primaryStage.setScene(scene);
	    	primaryStage.show();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
	    
	  }
	public static void main(String[] args) throws IOException {
		launch(args);
		
	}
}