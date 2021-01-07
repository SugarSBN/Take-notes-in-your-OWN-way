package controllers;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
 * 2020年11月15日
 * Management.controllers.NewABookController.java
 ***********************************************************/

public class NewABookController {
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
		 Calendar now = Calendar.getInstance();
		 SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
	     String curDate = s.format(now.getTime()); 
		 MainController.stmt.execute("insert into books (name,owner,lastEditedTime,tot) VALUES (" + "\"" + name.getText() + "\"," + "\"" + Consts.userName + "\"," + "\"" + curDate + "\",0);");
	     MainController.stmt.execute("create table " + name.getText() + Consts.userName + " (front text,back text,lasteditedtime varchar(20),familiar int,vague int,forgotten int,brief varchar(500));");
	     MainController.stmt.execute("create table count" + name.getText() + Consts.userName + " (time varchar(100));");
	     
		 SceneSets.newABook().closeStage();
		 SceneSets.mainScene().mainSceneController.initialize();
		 SceneSets.mainScene().showWindow();
	 }
}
