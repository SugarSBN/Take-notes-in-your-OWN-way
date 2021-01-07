package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.web.WebView;
import mysql.Consts;
import mysql.MainController;
import sceneset.SceneSets;

/***********************************************************
 * @author SuBonan
 * 2020Äê11ÔÂ18ÈÕ
 * Management.controllers.ViewCardsController.java
 ***********************************************************/

public class ViewCardsController {
	@FXML
    private ListView<String> cards;

    @FXML
    void newACard(ActionEvent event) {
    	
    	SceneSets.newACard().showWindow();
    	SceneSets.newACard().newACardController.newCard = true;
    	SceneSets.newACard().newACardController.init2();
    }
    @FXML
    void details(ActionEvent event) throws SQLException {
    	ObservableList<String> list = cards.getSelectionModel().getSelectedItems();
    	if (list.size()== 0 || list.size() > 1)	return;
    	Consts.nowCard = list.get(0);
    	SceneSets.newACard().showWindow();
    	SceneSets.newACard().newACardController.newCard = false;
    	SceneSets.newACard().newACardController.init();
    }
    @FXML
    void deleteCards(ActionEvent event) throws Exception {
    	ObservableList<String> list = cards.getSelectionModel().getSelectedItems();
    	for (int i = 0;i < list.size();i++){
    		String brief = list.get(i);
    		MainController.stmt.execute("delete from " + Consts.nowbook + Consts.userName + " where brief=\"" + brief + "\";"); 		
    	}	
    	ResultSet rs = MainController.stmt.executeQuery("select * from books where name=\"" + Consts.nowbook + "\" and owner=\"" + Consts.userName + "\";");
    	rs.next();
    	MainController.stmt.execute("update books set tot=" + Integer.toString(rs.getInt("tot") - list.size()) + " where name=\"" + Consts.nowbook + "\" and owner=\"" + Consts.userName + "\";");
    	SceneSets.mainScene().mainSceneController.flesh();
    	SceneSets.viewCards().viewCardsController.initialize();
    }
    public void initialize() throws SQLException{
    	cards.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	ObservableList<String> list = FXCollections.observableArrayList();
    	ResultSet rs = MainController.stmt.executeQuery("select * from " + Consts.nowbook + Consts.userName + ";");
    	while(rs.next())	list.add(rs.getString("brief"));
    	cards.setItems(list);
    }
}
