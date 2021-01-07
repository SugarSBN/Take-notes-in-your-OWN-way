package application;

/***********************************************************
 * @author SuBonan
 * 2020Äê12ÔÂ20ÈÕ
 * Management.application.BrowserViewInFxml.java
 ***********************************************************/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * This example demonstrates how to use JavaFX BrowserView in FXML app
 * through the {@link com.teamdev.jxbrowser.view.javafx.FxmlBrowserView} control.
 */
public final class BrowserViewInFxml extends Application {

    public static void main(String[] args) {
        Application.launch(BrowserViewInFxml.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	//System.setProperty("jxbrowser.license.key", "6P830J66YAX23NKQN4N7QMFUHUDLUJ49NABOD0R8UDGUXG2GCIEJ8FGQ55LSZP15NJFK");
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/scenes/Test.fxml")); 
    	Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Change your password");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}