package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

import cards.Card;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;
import mysql.Consts;
import mysql.MainController;
import sceneset.SceneSets;

/***********************************************************
 * @author SuBonan
 * 2020年11月23日
 * Management.controllers.ReviewController.java
 ***********************************************************/

public class ReviewController {
	 @FXML
	 private Button fButton;

	 @FXML
	 private Group front;

	 @FXML
	 private Label label;

	 @FXML
	 private Button vButton;

	 @FXML
	 private Button tButton;
	 
	 @FXML
	 private WebView mainText;
    
    private ResultSet rs;
    private TreeSet<Card>	s = new TreeSet<>();
    private Card nowCard;
    
    public void initialize() throws SQLException{
    	front.setVisible(true);
    	fButton.setVisible(false);
    	vButton.setVisible(false);
    	tButton.setVisible(false);
    	MainController.stmt.execute("UPDATE books set lastEditedTime=\"" + Consts.curDate + "\" where name=\"" + Consts.nowbook + "\" and owner=\"" + Consts.userName + "\";");
    	
    	rs = MainController.stmt.executeQuery("select * from " + Consts.nowbook + Consts.userName + ";");
    	s.clear();
    	while(rs.next() && s.size() < Consts.rev)	s.add(new Card(rs.getString("lastEditedTime") == null ? "1950-01-01" : rs.getString("lastEditedTime"), rs.getString("front"), rs.getString("back"), rs.getString("brief"), rs.getInt("familiar"), rs.getInt("vague"), rs.getInt("forgotten")));
    	label.setText("还剩下：" + s.size() + "张卡片待复习");
    	nowCard = s.pollFirst();
    	mainText.getEngine().loadContent(nowCard.front);
    }
    
    @FXML
    void check(ActionEvent event) {
    	mainText.getEngine().loadContent(nowCard.back);
    	front.setVisible(false);
    	fButton.setVisible(true);
    	vButton.setVisible(true);
    	tButton.setVisible(true);
    }

    @FXML
    void familiar(ActionEvent event) throws SQLException {
    	nowCard.times--;
    	nowCard.familiar++;
    	if (nowCard.times <= 0){
    		nowCard.lastEditedTime = Consts.curDate;
    		nowCard.modify();
    		if (s.size() == 0){
    			SceneSets.finishReview().showWindow();
    			SceneSets.review().closeStage();
    			return;
    		}else	{
    	    	label.setText("还剩下：" + s.size() + "张卡片待复习");
    			nowCard = s.pollFirst();
    		}
    	}else{
    		s.add(nowCard);
    		nowCard = s.pollFirst();
    	}
    	front.setVisible(true);
    	fButton.setVisible(false);
    	vButton.setVisible(false);
    	tButton.setVisible(false);
    	mainText.getEngine().loadContent(nowCard.front);
    }

    @FXML
    void vague(ActionEvent event) {
    	nowCard.times++;
    	nowCard.vague++;
    	s.add(nowCard);
    	nowCard = s.pollFirst();
    	front.setVisible(true);
    	fButton.setVisible(false);
    	vButton.setVisible(false);
    	tButton.setVisible(false);
    	mainText.getEngine().loadContent(nowCard.front);
    }

    @FXML
    void forgotten(ActionEvent event) {
    	nowCard.times++;
    	nowCard.vague++;
    	s.add(nowCard);
    	nowCard = s.pollFirst();
    	front.setVisible(true);
    	fButton.setVisible(false);
    	vButton.setVisible(false);
    	tButton.setVisible(false);
    	mainText.getEngine().loadContent(nowCard.front);
    }

}
