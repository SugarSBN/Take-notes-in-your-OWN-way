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
 * 2020Äê12ÔÂ3ÈÕ
 * Management.controllers.FinishReviewController.java
 ***********************************************************/

public class FinishReviewController {
    @FXML
    private Button confirmButton;

    @FXML
    void confirm(ActionEvent event) throws SQLException {
    	SceneSets.finishReview().closeStage();
    	MainController.stmt.execute("insert into count" + Consts.nowbook + Consts.userName + " (time) values (\"" + Consts.curDate + "\");");
    	SceneSets.mainScene().mainSceneController.flesh();
    }
}
