package controllers;

import java.sql.ResultSet;

import application.Register;
import application.RegisterSuccess;
import javafx.event.ActionEvent;

/***********************************************************
 * @author SuBonan
 * 2020年11月9日
 * Management.controllers.registerController.java
 ***********************************************************/


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import mysql.MainController;
import sceneset.SceneSets;

public class RegisterController {

    @FXML
    private Button signupButton;

    @FXML
    private PasswordField password2;

    @FXML
    private PasswordField password1;

    @FXML
    private Label label;

    @FXML
    private TextField userName;
    
    @FXML
    private TextField telephoneNumber;

    @FXML
    void register(ActionEvent event) throws Exception {
    	if (userName.getText().length() == 0){
    		label.setText("用户名不能为空！");
    		return;
    	}
    	if (password1.getText().length() == 0){
        	label.setText("密码不能为空！");
        	return;	
    	}
    	String ps = password1.getText();
    	boolean pd = false;
    	for (int i = 0;i < ps.length();i++)	if ('a' <= ps.charAt(i) && ps.charAt(i) <= 'z'){
    		pd = true;
    		break;
    	}
    	if (!pd){
    		label.setText("密码需要含有字母！");
    		return;
    	}
		if (!password1.getText().equals(password2.getText())){
    		label.setText("两次密码输入不一致！");
    		return;
		}
		if (telephoneNumber.getText().length() == 0){
			label.setText("手机号码不能为空！");
    		return;
		}
		ResultSet rs = MainController.stmt.executeQuery("select * from idpasswords where username=\"" + userName.getText() + "\";");
		if (rs.next()){
    		label.setText("用户名已被占用！");
    		return;
		}
		SceneSets.registerSuccess().showWindow();
		MainController.stmt.execute("insert into idpasswords (username,password,telnumber) VALUES (\"" + userName.getText() + "\",\"" + password1.getText() + "\",\"" + telephoneNumber.getText() + "\");");
    }

}

