package controllers;

import java.sql.ResultSet;
import java.util.logging.Logger;

import application.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import mysql.Consts;
import mysql.MainController;
import sceneset.SceneSets;

public class LoginController{

    @FXML
    private Button loginButton = new Button();
    @FXML
    private PasswordField passwordField = new PasswordField();
    @FXML
    private Button registerButton;
    @FXML
    private TextField userName;
    @FXML
    private Label label;
   
    private static final Logger logger = Logger.getLogger(LoginController.class.getName());
	private Login main;
	
    @FXML
    void login(ActionEvent event) throws Exception {
    	if (userName.getText().length() == 0){
    		label.setText("用户名不能为空！");
    		return;
    	}
    	ResultSet rs = MainController.stmt.executeQuery("select * from idpasswords where username=\"" + userName.getText() + "\";");
    	if (!rs.next()){
    		label.setText("用户不存在！");
    		return;
    	}
    	if (!rs.getString("password").equals(passwordField.getText())){
    		label.setText("密码错误！");
    		return;
    	}
    	Consts.userName = userName.getText();
    	SceneSets.loginSuccess().showWindow();
    }
    @FXML
    void register(ActionEvent event) throws Exception {
    	SceneSets.register().showWindow();
    }
    @FXML
    void findBackPassword(ActionEvent event) throws Exception {
    	SceneSets.findBackPassword().showWindow();
    }
    public void initialize(){
    	
    }
}
