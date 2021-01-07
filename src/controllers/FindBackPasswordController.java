package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mysql.MainController;

/***********************************************************
 * @author SuBonan
 * 2020��11��11��
 * Management.controllers.FindBackPasswordController.java
 ***********************************************************/

public class FindBackPasswordController {
	@FXML
    private TextField telephoneNumber;

    @FXML
    private Label label;

    @FXML
    private TextField userName;

    @FXML
    void findBackPassword(ActionEvent event) throws SQLException {
    	if (userName.getText().length() == 0){
    		label.setText("�������û�����");
    		return;
    	}
    	ResultSet rs = MainController.stmt.executeQuery("select * from idpasswords where username=\"" + userName.getText() + "\";");
    	if (rs.next()){
    		if (!telephoneNumber.getText().equals(rs.getString("telnumber"))){
    			label.setText("�绰�������");
        		return;
    		}
    		label.setText("���������ǣ�" + rs.getString("password"));
    	}else{
    		label.setText("�û������ڣ�");
    		return;
    	}
    }

}
