package controllers;

import java.sql.ResultSet;

import application.Register;
import application.RegisterSuccess;
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
    		label.setText("�û�������Ϊ�գ�");
    		return;
    	}
    	if (password1.getText().length() == 0){
        	label.setText("���벻��Ϊ�գ�");
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
		if (telephoneNumber.getText().length() == 0){
			label.setText("�ֻ����벻��Ϊ�գ�");
    		return;
		}
		ResultSet rs = MainController.stmt.executeQuery("select * from idpasswords where username=\"" + userName.getText() + "\";");
		if (rs.next()){
    		label.setText("�û����ѱ�ռ�ã�");
    		return;
		}
		SceneSets.registerSuccess().showWindow();
		MainController.stmt.execute("insert into idpasswords (username,password,telnumber) VALUES (\"" + userName.getText() + "\",\"" + password1.getText() + "\",\"" + telephoneNumber.getText() + "\");");
    }

}

