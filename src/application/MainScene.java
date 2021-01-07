package application;

import java.sql.SQLException;

import controllers.MainSceneController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/***********************************************************
 * @author SuBonan
 * 2020Äê11ÔÂ8ÈÕ
 * HelloJavaFx.application.MainScene.java
 ***********************************************************/


public class MainScene extends Application{
		Stage stage=new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/scenes/MainScene.fxml")); 
		public MainSceneController mainSceneController;
		boolean inited = false;
		@Override
		public void init() throws SQLException{
			mainSceneController.initialize();
		}
		@Override
	    public void start(Stage primaryStage) throws SQLException{
			inited = true;
			try {
	            // Read file fxml and draw interface.
				Parent root = fxmlLoader.load();
				Scene scene = new Scene(root);
	            stage = primaryStage;
	            primaryStage.setResizable(false);
	            primaryStage.setTitle("Welcome!");
	            primaryStage.setScene(scene);
	            primaryStage.show();
	            mainSceneController = fxmlLoader.getController();
	     } catch(Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
	    public void  showWindow() throws Exception {
	    	if (!inited)	start(stage);
	    	else{
	    		mainSceneController.initialize();
	    		stage.show();
	    	}
		}
	    public void closeStage(){
	    	stage.close();
	    }
}
