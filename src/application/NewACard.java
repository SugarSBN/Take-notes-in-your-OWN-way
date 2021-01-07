package application;

import controllers.NewACardController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/***********************************************************
 * @author SuBonan
 * 2020Äê11ÔÂ13ÈÕ
 * Management.application.NewABook.java
 ***********************************************************/

public class NewACard extends Application{
	Stage stage =new Stage();
	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/scenes/NewACard.fxml"));
	public NewACardController newACardController;
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
            primaryStage.setTitle("New a card");
            primaryStage.setScene(scene);
            primaryStage.show();
            newACardController = fxmlLoader.getController();
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
