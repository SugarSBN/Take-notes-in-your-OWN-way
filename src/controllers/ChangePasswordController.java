package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;

/***********************************************************
 * @author SuBonan
 * 2020��11��9��
 * Management.controllers.registerController.java
 ***********************************************************/


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import mysql.Consts;
import mysql.MainController;

public class ChangePasswordController {

	@FXML
    private Button signupButton;

    @FXML
    private PasswordField oldpassword;

    @FXML
    private PasswordField password2;

    @FXML
    private PasswordField password1;

    @FXML
    private Label label;

    @FXML
    void register(ActionEvent event) throws SQLException {
    	if (oldpassword.getText().length() == 0){
    		label.setText("����������룡");
    		return;
    	}
    	if (password1.getText().length() == 0){
    		label.setText("�����������룡");
    		return;
    	}
    	if (password1.getText().length() == 0){
    		label.setText("�����������룡");
    		return;
    	}
    	
    	String ps = password1.getText();
    	boolean pd = false;
    	for (int i = 0;i < ps.length();i++)	if ('a' <= ps.charAt(i) && ps.charAt(i) <= 'z'){
    		pd = true;
    		break;
    	}
    	if (!pd){
    		label.setText("������Ҫ������ĸ��");
    		return;
    	}
    	
    	if (!password1.getText().equals(password2.getText())){
    		label.setText("�����������벻һ�£�");
    		return;
    	}
    	ResultSet rs = MainController.stmt.executeQuery("select * from idpasswords where username=\"" + Consts.userName + "\";");
    	if (rs.next()){
    		if (!oldpassword.getText().equals(rs.getString("password"))){
    			label.setText("���������");
        		return;
    		}
    		label.setText("��������ɹ���");
    		MainController.stmt.execute("UPDATE idpasswords SET password=\"" + password1.getText() + "\" where username=\"" + Consts.userName + "\";");
    	}
    }

}

