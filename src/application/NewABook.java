package application;

import controllers.NewABookController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/***********************************************************
 * @author SuBonan
 * 2020��11��15��
 * Management.application.NewABook.java
 ***********************************************************/

public class NewABook extends Application{
	Stage stage =new Stage();
	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/scenes/NewABook.fxml"));
	NewABookController newABookController;
	boolean inited = false;
	@Override
    public void start(Stage primaryStage) {
		inited = true;
        try {
            // Read file fxml and draw interface.
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage = primaryStage;
            primaryStage.setResizable(false);
            primaryStage.setTitle("New a book");
            primaryStage.setScene(scene);
            primaryStage.show();
            newABookController = fxmlLoader.getController();
       } catch(Exception e) {
            e.printStackTrace();
       }
    }
    public static void main(String[] args) {
        launch(args);
    }
    public void closeStage(){
    	stage.close();
    }
    public void showWindow(){
    	if (!inited)	start(stage);
    	else stage.show();
    }
}
