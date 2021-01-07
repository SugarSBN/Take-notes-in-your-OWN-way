package application;

import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.view.javafx.BrowserView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The simplest application with the integrated browser component.
 *
 * <p>This example demonstrates:
 *
 * <ol>
 *     <li>Creating an instance of {@link Engine}.
 *     <li>Creating an instance of {@link Browser}.
 *     <li>Embedding the browser into JavaFX via {@link BrowserView}.
 *     <li>Loading the "https://html5test.com" web site.
 * </ol>
 */
public final class Test extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Creating and running Chromium engine
    	System.setProperty("jxbrowser.license.key", "6P830J66YAX23NKQN4N7QMFUHUDLUJ49NABOD0R8UDGUXG2GCIEJ8FGQ55LSZP15NJFK");
        Engine engine = Engine.newInstance(
                EngineOptions.newBuilder(HARDWARE_ACCELERATED).build());

        Browser browser = engine.newBrowser();
        // Loading the required web page
        browser.navigation().loadUrl("http://localhost:81");

        // Creating UI component for rendering web content
        // loaded in the given Browser instance
        BrowserView view = BrowserView.newInstance(browser);
        
        Scene scene = new Scene(new BorderPane(view), 800, 600);
        primaryStage.setTitle("JxBrowser JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Closing the engine when stage is about to close
        primaryStage.setOnCloseRequest(event -> engine.close());
    }
    public static void main(String[] args){
    	launch(args);
    }
}