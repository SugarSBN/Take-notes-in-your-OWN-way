package application;

import controllers.ChangePasswordController;
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

public class ChangePassword extends Application {
	Stage stage =new Stage();
	ChangePasswordController changePasswordController;
	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/scenes/PasswordChange.fxml")); 
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
            primaryStage.setTitle("Change your password");
            primaryStage.setScene(scene);
            primaryStage.show();
            changePasswordController = fxmlLoader.getController();
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
