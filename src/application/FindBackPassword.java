package application;

import controllers.FindBackPasswordController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/***********************************************************
 * @author SuBonan
 * 2020Äê11ÔÂ11ÈÕ
 * Management.application.FindBackPassword.java
 ***********************************************************/

public class FindBackPassword extends Application{
	Stage stage=new Stage();
	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/scenes/findBackPassword.fxml"));
	FindBackPasswordController findBackPasswordController;
	boolean inited = false;
	@Override
    public void start(Stage primaryStage){
		inited = true;
		try {
            // Read file fxml and draw interface.
			Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage = primaryStage;
            primaryStage.setResizable(false);
            primaryStage.setTitle("Find back your password");
            primaryStage.setScene(scene);
            primaryStage.show();
            findBackPasswordController = fxmlLoader.getController();
     } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    public void  showWindow() throws Exception {
    	if (!inited)	start(stage);
    	else stage.show();
	}
    public void closeStage(){
    	stage.close();
    }
}
