package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import fxml.FxmlBrowserView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

/**
 * Represents FXML controller with the address bar and browser view area that
 * displays the URL entered in the address bar.
 */
public final class FxmlBrowserViewController implements Initializable {

    @FXML
    private FxmlBrowserView browserView = new FxmlBrowserView();
    @FXML
    private FxmlBrowserView browserView1 = new FxmlBrowserView();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        browserView.browser().navigation().loadUrl("http://www.baidu.com");
        browserView1.browser().navigation().loadUrl("http://www.baidu.com");
    }
}
