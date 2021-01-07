package application;


import java.sql.SQLException;

import controllers.ReviewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mysql.Consts;
import mysql.MainController;

public class Review extends Application {
	Stage stage=new Stage();
	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/scenes/Review.fxml")); 
	public ReviewController reviewController;
	boolean inited = false;
	@Override
    public void start(Stage primaryStage) throws SQLException{
		inited = true;
		try {
            // Read file fxml and draw interface.
			Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage = primaryStage;
            primaryStage.setResizable(false);
            primaryStage.setTitle("Reviewing");
            primaryStage.setScene(scene);
            primaryStage.show();
            reviewController = fxmlLoader.getController();
     } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    public void  showWindow() throws Exception {
    	if (!inited)	start(stage);
    	else	{
    		reviewController.initialize();
    		stage.show();
    	}
	}
    public void closeStage(){
    	stage.close();
    }
}
