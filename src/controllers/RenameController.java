package controllers;

import java.sql.ResultSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mysql.Consts;
import mysql.MainController;
import sceneset.SceneSets;

/***********************************************************
 * @author SuBonan
 * 2020年11月18日
 * Management.controllers.RenameController.java
 ***********************************************************/

public class RenameController {
	@FXML
	 private TextField name;

	 @FXML
	 private Button confirmButton;
	 
	 @FXML
	 private Label label;

	 @FXML
	 void confirm(ActionEvent event) throws Exception {
		 ResultSet rs = MainController.stmt.executeQuery("select * from books where name=\"" + name.getText() + "\" and owner=\"" + Consts.userName + "\";");
		 if (rs.next()){
			 label.setText("同名笔记本已经存在！");
			 return;
		 }
		 MainController.stmt.execute("update books set name = \"" + name.getText() + "\" where name = \"" + Consts.nowbook + "\" and owner=\"" + Consts.userName + "\";");
		 MainController.stmt.execute("alter table " + Consts.nowbook + Consts.userName + " rename to " + name.getText() + Consts.userName + ";");
		 Consts.nowbook = name.getText();
		 
		 SceneSets.rename().closeStage();
		 SceneSets.mainScene().mainSceneController.initialize();
		 SceneSets.mainScene().showWindow();
	 }
}
