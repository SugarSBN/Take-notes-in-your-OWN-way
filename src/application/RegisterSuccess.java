package application;


import controllers.RegisterSuccessController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/***********************************************************
 * @author SuBonan
 * 2020Äê11ÔÂ8ÈÕ
 * HelloJavaFx.application.LoginSuccess.java
 ***********************************************************/

public class RegisterSuccess extends Application{
	Stage stage=new Stage();
	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/scenes/RegisterSuccess.fxml"));
	RegisterSuccessController registerSuccessController;
	boolean inited = false;
	@Override
    public void start(Stage primaryStage){
		inited = true;
        try {
            // Read file fxml and draw interface.
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            primaryStage.setResizable(false);
            primaryStage.setTitle("Register success!");
            primaryStage.setScene(scene);
            primaryStage.show();
            registerSuccessController = fxmlLoader.getController();
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