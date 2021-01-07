package application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mysql.MainController;

public class Login extends Application {
	public Stage stage = new Stage();
	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/scenes/LoginScene.fxml"));
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
            primaryStage.setTitle("Log in scene");
            primaryStage.setScene(scene);
            primaryStage.show();
            MainController.generate();
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
    	else	stage.show();
    }
}
