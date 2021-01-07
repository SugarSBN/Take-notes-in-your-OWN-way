package application;

import controllers.RegisterController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/***********************************************************
 * @author SuBonan
 * 2020Äê11ÔÂ9ÈÕ
 * Management.application.Register.java
 ***********************************************************/

public class Register extends Application {
	Stage stage =new Stage();
	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/scenes/Register.fxml"));
	RegisterController registerController;
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
            primaryStage.setTitle("Register");
            primaryStage.setScene(scene);
            primaryStage.show();
            registerController = fxmlLoader.getController();
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
    public void  showWindow() throws Exception {
    	if (!inited)	start(stage);
    	else stage.show();
	}
}
