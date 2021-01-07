package controllers;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import mysql.Consts;
import mysql.MainController;
import sceneset.SceneSets;

/***********************************************************
 * @author SuBonan
 * 2020Äê11ÔÂ15ÈÕ
 * Management.controllers.DeleteConfirmController.java
 ***********************************************************/

public class DeleteConfirmController {
	@FXML
    private Button confirmButton;

    @FXML
    void confirm(ActionEvent event) throws SQLException,Exception {
    	MainController.stmt.execute("delete from books where name=\"" + Consts.nowbook + "\" and owner=\"" + Consts.userName + "\";");
    	MainController.stmt.execute("drop table " + Consts.nowbook + Consts.userName + ";");
    	MainController.stmt.execute("drop table count" + Consts.nowbook + Consts.userName + ";");
    	
    	SceneSets.deleteConfirm().closeStage();
    	SceneSets.mainScene().mainSceneController.initialize();
    }

    @FXML
    void cancel(ActionEvent event) {
    	SceneSets.deleteConfirm().closeStage();
    }
}
