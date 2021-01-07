package controllers;

import application.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sceneset.SceneSets;

/***********************************************************
 * @author SuBonan
 * 2020Äê11ÔÂ8ÈÕ
 * HelloJavaFx.controllers.LoginSuccessController.java
 ***********************************************************/

public class RegisterSuccessController {
	
	@FXML
	private Button confirmButton;

	@FXML
	void confirm(ActionEvent event) throws Exception {
		SceneSets.register().closeStage();
		SceneSets.registerSuccess().closeStage();
		SceneSets.login().closeStage();
		SceneSets.login().showWindow();
	}
}
