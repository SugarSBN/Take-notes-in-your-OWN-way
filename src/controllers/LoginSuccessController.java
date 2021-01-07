package controllers;

import application.MainScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sceneset.SceneSets;

/***********************************************************
 * @author SuBonan
 * 2020Äê11ÔÂ8ÈÕ
 * HelloJavaFx.controllers.LoginSuccessController.java
 ***********************************************************/

public class LoginSuccessController {
	
	@FXML
	private Button confirmButton;

	@FXML
	void confirm(ActionEvent event) throws Exception {
		SceneSets.mainScene().showWindow();
		SceneSets.loginSuccess().closeStage();
		SceneSets.login().closeStage();
	}
}
