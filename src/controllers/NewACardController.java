package controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import mysql.Consts;
import mysql.MainController;
import sceneset.SceneSets;

/***********************************************************
 * @author SuBonan
 * 2020年11月13日
 * Management.controllers.NewABookController.java
 ***********************************************************/

public class NewACardController {
	 @FXML
	 private Button confirm;

	 @FXML
	 private Group back;

	 @FXML
	 private ImageView cardFront;

	 @FXML
	 private Group front;

	 @FXML
	 private HTMLEditor frontText;

	 @FXML
	 private HTMLEditor backText;

	 @FXML
	 private ImageView cardBack;
	 
	 @FXML
	 private TextField brief;
	 
	 @FXML
	 private TextField size;
	FileChooser fileChooser = new FileChooser();
    
    boolean newCard = false;
    
    boolean isFront = true;
    
    public void initialize(){
    }
    @FXML
    void cardBack(ActionEvent event) {
    	front.setVisible(false);
    	cardFront.setVisible(false);
    	back.setVisible(true);
    	cardBack.setVisible(true);
    	isFront = false;
    }
    
    @FXML
    void insertPic(ActionEvent event) throws IOException {
    	File file = fileChooser.showOpenDialog(new Stage());
    	InputStream from = new FileInputStream(file);
    	BufferedImage sourceImg = ImageIO.read(new FileInputStream(file)); 
    	double width = sourceImg.getWidth();
    	double height = sourceImg.getHeight();
    	
    	File cnt = new File("D:\\dev\\JavaProjects\\Management\\src\\htmlPics");
    	File[] files = cnt.listFiles();
    	int num = (int) files.length;
    	cnt = new File("D:\\dev\\JavaProjects\\Management\\src\\htmlPics\\" + num + ".jpg");
    	
    	OutputStream to = new FileOutputStream(cnt);
    	byte[] buf = new byte[1024];        
        int bytesRead;        
    	try {
			while ((bytesRead = from.read(buf)) != -1) {
				to.write(buf, 0, bytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    	double rate = Double.valueOf(size.getText());
    	rate /= 100.0;
    	rate = Math.max(0, Math.min(rate, 1));
    	
    	if (isFront){
    		frontText.setHtmlText(frontText.getHtmlText() + "<img src=\"file:///D://dev//JavaProjects//Management//src//htmlPics//" + num + ".jpg\" width=\"" + width * rate + "\" height=\"" + height * rate + "\"/>");
    	}else{
    		backText.setHtmlText(backText.getHtmlText() + "<img src=\"file:///D://dev//JavaProjects//Management//src//htmlPics//" + num + ".jpg\" width=\"" + width * rate + "\" height=\"" + height * rate + "\"/>");
        }
    }
    
    @FXML
    void confirm(ActionEvent event) throws SQLException {
        String bri = brief.getText();
        if (bri.length() == 0 || bri.equals("请输入卡片名字！！！！") || bri.equals("卡片重名了！！！！")){
        	brief.setText("请输入卡片名字！！！！");
        	return;
        }
        ResultSet rs1 = MainController.stmt.executeQuery("select * from " + Consts.nowbook + Consts.userName + " where brief=\"" + bri + "\";");
    	if (rs1.next()){
    		brief.setText("卡片重名了！！！！");
        	return;
    	}
        Calendar now = Calendar.getInstance();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String curDate = s.format(now.getTime());
        String f = frontText.getHtmlText();
        String b = backText.getHtmlText();
        for (int i = 0;i < f.length();i++)	if (f.charAt(i) == '"')	 {
			f = f.substring(0, i) + '"' + f.substring(i);
			i++;
		}
		for (int i = 0;i < b.length();i++)	if (b.charAt(i) == '"')	 {
			b = b.substring(0, i) + '"' + b.substring(i);
			i++;
		}
		for (int i = 0;i < bri.length();i++)	if (bri.charAt(i) == '"')	 {
			bri = bri.substring(0, i) + '"' + bri.substring(i);
			i++;
		}
    	if (newCard)	{	
    		MainController.stmt.execute("insert into " + Consts.nowbook + Consts.userName + " (front,back,familiar,vague,forgotten,brief) values (\"" + f + "\",\"" + b + "\",0,0,0,\"" + bri + "\");");
    		ResultSet rs = MainController.stmt.executeQuery("select * from books where name=\"" + Consts.nowbook + "\" and owner=\"" + Consts.userName + "\";");
    		rs.next();
    		MainController.stmt.execute("update books set tot=" + Integer.toString(rs.getInt("tot") + 1) + " where name=\"" + Consts.nowbook + "\" and owner=\"" + Consts.userName + "\";");
    	}else {
    		String f1 = Consts.nowCard;
        	for (int i = 0;i < f1.length();i++)	if (f1.charAt(i) == '"')	 {
    			f1 = f1.substring(0, i) + '"' + f1.substring(i);
    			i++;
    		}
    		MainController.stmt.execute("update " + Consts.nowbook + Consts.userName + " set back=\"" + b + "\" where brief=\"" + f1 + "\";");
    		MainController.stmt.execute("update " + Consts.nowbook + Consts.userName + " set front=\"" + f + "\" where brief=\"" + f1 + "\";"); 
    		MainController.stmt.execute("update " + Consts.nowbook + Consts.userName + " set brief=\"" + bri + "\" where brief=\"" + f1 + "\";");      		
    	}
    	SceneSets.viewCards().viewCardsController.initialize();
    	SceneSets.mainScene().mainSceneController.flesh();
    	SceneSets.newACard().closeStage();
    }
    
    void init() throws SQLException{
    	String f = Consts.nowCard;
    	for (int i = 0;i < f.length();i++)	if (f.charAt(i) == '"')	 {
			f = f.substring(0, i) + '"' + f.substring(i);
			i++;
		}
    	ResultSet rs = MainController.stmt.executeQuery("select * from " + Consts.nowbook + Consts.userName + " where brief=\"" + f + "\";");
    	rs.next();
    	frontText.setHtmlText(rs.getString("front"));
    	backText.setHtmlText(rs.getString("back"));
    	front.setVisible(true);
    	back.setVisible(false);
    	isFront = true;
    }
    
    void init2(){
    	front.setVisible(true);
    	back.setVisible(false);
    	frontText.setHtmlText("");
    	backText.setHtmlText("");
    	isFront = true;
    }
}
