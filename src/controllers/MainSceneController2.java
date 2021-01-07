package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import cards.Card;
import fxml.FxmlBrowserView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.Axis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import mysql.Consts;
import mysql.MainController;
import sceneset.SceneSets;

/***********************************************************
 * @author SuBonan
 * 2020��11��10��
 * Management.controllers.MainSceneController.java
 ***********************************************************/

public class MainSceneController2{
	@FXML
    private Text time;
	
	@FXML
	private Text poetry, cardfront, cardback;
	
	@FXML
	private Button book1, book2, book3, book4, book5, book6, book7 ,book8, book9;
	
	@FXML
	private Button newButton;
	 
	@FXML
	private Pane pane;
	
	@FXML
	private Pane specificPane;
	
	@FXML
	private Button backButton;
	 
	@FXML
	private Label name, tot, lastEditedTime;
	
	@FXML
	private Axis<String> XAxis = new CategoryAxis();
	
	@FXML
    private Axis<Number> YAxis = new NumberAxis();

	@FXML
    private LineChart<String, Number> chart = new LineChart(XAxis, YAxis);
	
	@FXML
    private FxmlBrowserView browserView = new FxmlBrowserView();
	
	@FXML
	private Button logout;
	public void initialize() throws SQLException{
		Calendar now = Calendar.getInstance();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String curDate = s.format(now.getTime()); 
        Consts.curDate = curDate;
        
        time.setText(curDate);
        paneInitialize();
        pane.setVisible(true);
        newButton.setVisible(true);
        specificPane.setVisible(false);
        
        System.setProperty("jxbrowser.license.key", "6P830J66YAX23NKQN4N7QMFUHUDLUJ49NABOD0R8UDGUXG2GCIEJ8FGQ55LSZP15NJFK");
        browserView.browser().navigation().loadUrl("http://localhost:777");
    }
	public void paneInitialize() throws SQLException{
		 ResultSet rs1 =MainController.stmt.executeQuery("SELECT count(*) FROM poetry;");
	     int rows = 0;
	     if (rs1.next())	rows = rs1.getInt(1);
	     Random random = new Random();
	     rs1 = MainController.stmt.executeQuery("select * from poetry where id=" + Integer.toString(random.nextInt(rows) + 1) + ";");
	     
	     if(rs1.next())	poetry.setText(rs1.getString(2));
	     ResultSet rs = MainController.stmt.executeQuery("select * from books where owner=\"" + Consts.userName + "\";");
	     book1.setVisible(false);
	     book2.setVisible(false);
	     book3.setVisible(false);
	     book4.setVisible(false);
	     book5.setVisible(false);
	     book6.setVisible(false);
	     book7.setVisible(false);
	     book8.setVisible(false);
	     book9.setVisible(false);
	     if (rs.next()){
	    	 book1.setVisible(true);
	    	 book1.setText(rs.getString("name") + "\n" + rs.getString("tot") + "��\n" + rs.getString("lastEditedTime").substring(5));
	     }
	     if (rs.next()){
	    	 book2.setVisible(true);
	    	 book2.setText(rs.getString("name") + "\n" + rs.getString("tot") + "��\n" + rs.getString("lastEditedTime").substring(5));
	     }
	     if (rs.next()){
	    	 book3.setVisible(true);
	    	 book3.setText(rs.getString("name") + "\n" + rs.getString("tot") + "��\n" + rs.getString("lastEditedTime").substring(5));
	     }
	     if (rs.next()){
	    	 book4.setVisible(true);
	    	 book4.setText(rs.getString("name") + "\n" + rs.getString("tot") + "��\n" + rs.getString("lastEditedTime").substring(5));
	     }
	     if (rs.next()){
	    	 book5.setVisible(true);
	    	 book5.setText(rs.getString("name") + "\n" + rs.getString("tot") + "��\n" + rs.getString("lastEditedTime").substring(5));
	     }
	     if (rs.next()){
	    	 book6.setVisible(true);
	    	 book6.setText(rs.getString("name") + "\n" + rs.getString("tot") + "��\n" + rs.getString("lastEditedTime").substring(5));
	     }
	     if (rs.next()){
	    	 book7.setVisible(true);
	    	 book7.setText(rs.getString("name") + "\n" + rs.getString("tot") + "��\n" + rs.getString("lastEditedTime").substring(5));
	     }
	     if (rs.next()){
	    	 book8.setVisible(true);
	    	 book8.setText(rs.getString("name") + "\n" + rs.getString("tot") + "��\n" + rs.getString("lastEditedTime").substring(5));
	     }
	     if (rs.next()){
	    	 book9.setVisible(true);
	    	 book9.setText(rs.getString("name") + "\n" + rs.getString("tot") + "��\n" + rs.getString("lastEditedTime").substring(5));
	     }
	}
	@FXML
    void logout(ActionEvent event){
		SceneSets.mainScene().closeStage();
		SceneSets.login().showWindow();
    }
	@FXML
    void changePassword(ActionEvent event) throws Exception {
		SceneSets.changePassword().showWindow();
    }
	@FXML
    void book1(ActionEvent event) throws SQLException {
		pane.setVisible(false);
		newButton.setVisible(false);
		specificPane.setVisible(true);
		ResultSet rs = MainController.stmt.executeQuery("select * from books where owner=\"" + Consts.userName + "\";");
	    for (int i = 1;i <= 1;i++)	rs.next();
	    name.setText(rs.getString("name"));
	    Consts.nowbook = rs.getString("name");
	    flesh();
	  //  tot.setText(Integer.toString(rs.getInt("tot")) + "��");
	    //lastEditedTime.setText(rs.getString("lasteditedtime"));
    }
	@FXML
    void book2(ActionEvent event) throws SQLException {
		pane.setVisible(false);
		newButton.setVisible(false);
		specificPane.setVisible(true);
		ResultSet rs = MainController.stmt.executeQuery("select * from books where owner=\"" + Consts.userName + "\";");
	    for (int i = 1;i <= 2;i++)	rs.next();
	    name.setText(rs.getString("name"));
	    Consts.nowbook = rs.getString("name");
	    flesh();
	   // tot.setText(Integer.toString(rs.getInt("tot")) + "��");
	   // lastEditedTime.setText(rs.getString("lasteditedtime"));
    }
	@FXML
    void book3(ActionEvent event) throws SQLException {
		pane.setVisible(false);
		newButton.setVisible(false);
		specificPane.setVisible(true);
		ResultSet rs = MainController.stmt.executeQuery("select * from books where owner=\"" + Consts.userName + "\";");
	    for (int i = 1;i <= 3;i++)	rs.next();
	    name.setText(rs.getString("name"));
	    Consts.nowbook = rs.getString("name");
	    flesh();
	   // tot.setText(Integer.toString(rs.getInt("tot")) + "��");
	   // lastEditedTime.setText(rs.getString("lasteditedtime"));
    }
	@FXML
    void book4(ActionEvent event) throws SQLException {
		pane.setVisible(false);
		newButton.setVisible(false);
		specificPane.setVisible(true);
		ResultSet rs = MainController.stmt.executeQuery("select * from books where owner=\"" + Consts.userName + "\";");
	    for (int i = 1;i <= 4;i++)	rs.next();
	    name.setText(rs.getString("name"));
	    Consts.nowbook = rs.getString("name");
	    flesh();
	    //tot.setText(Integer.toString(rs.getInt("tot")) + "��");
	    //lastEditedTime.setText(rs.getString("lasteditedtime"));
    }
	@FXML
    void book5(ActionEvent event) throws SQLException {
		pane.setVisible(false);
		newButton.setVisible(false);
		specificPane.setVisible(true);
		ResultSet rs = MainController.stmt.executeQuery("select * from books where owner=\"" + Consts.userName + "\";");
	    for (int i = 1;i <= 5;i++)	rs.next();
	    name.setText(rs.getString("name"));
	    Consts.nowbook = rs.getString("name");
	    flesh();
	    //tot.setText(Integer.toString(rs.getInt("tot")) + "��");
	    //lastEditedTime.setText(rs.getString("lasteditedtime"));
    }
	@FXML
    void book6(ActionEvent event) throws SQLException {
		pane.setVisible(false);
		newButton.setVisible(false);
		specificPane.setVisible(true);
		ResultSet rs = MainController.stmt.executeQuery("select * from books where owner=\"" + Consts.userName + "\";");
	    for (int i = 1;i <= 6;i++)	rs.next();
	    name.setText(rs.getString("name"));
	    Consts.nowbook = rs.getString("name");
	    flesh();
	   // tot.setText(Integer.toString(rs.getInt("tot")) + "��");
	    //lastEditedTime.setText(rs.getString("lasteditedtime"));
    }
	@FXML
    void book7(ActionEvent event) throws SQLException {
		pane.setVisible(false);
		newButton.setVisible(false);
		specificPane.setVisible(true);
		ResultSet rs = MainController.stmt.executeQuery("select * from books where owner=\"" + Consts.userName + "\";");
	    for (int i = 1;i <= 7;i++)	rs.next();
	    name.setText(rs.getString("name"));
	    Consts.nowbook = rs.getString("name");
	    flesh();
	    //tot.setText(Integer.toString(rs.getInt("tot")) + "��");
	    //lastEditedTime.setText(rs.getString("lasteditedtime"));
    }
	@FXML
    void book8(ActionEvent event) throws SQLException {
		pane.setVisible(false);
		newButton.setVisible(false);
		specificPane.setVisible(true);
		ResultSet rs = MainController.stmt.executeQuery("select * from books where owner=\"" + Consts.userName + "\";");
	    for (int i = 1;i <= 8;i++)	rs.next();
	    name.setText(rs.getString("name"));
	    Consts.nowbook = rs.getString("name");
	    flesh();
	   // tot.setText(Integer.toString(rs.getInt("tot")) + "��");
	   // lastEditedTime.setText(rs.getString("lasteditedtime"));
    }
	@FXML
    void book9(ActionEvent event) throws SQLException {
		pane.setVisible(false);
		newButton.setVisible(false);
		specificPane.setVisible(true);
		ResultSet rs = MainController.stmt.executeQuery("select * from books where owner=\"" + Consts.userName + "\";");
	    for (int i = 1;i <= 9;i++)	rs.next();
	    name.setText(rs.getString("name"));
	    Consts.nowbook = rs.getString("name");
	    flesh();
	    //tot.setText(Integer.toString(rs.getInt("tot")) + "��");
	    //lastEditedTime.setText(rs.getString("lasteditedtime"));
    }
	
	
    XYChart.Series<String, Number> series1 = new XYChart.Series<>();
    
	void flesh() throws SQLException{
		
		ResultSet rs = MainController.stmt.executeQuery("select * from books where owner=\"" + Consts.userName + "\";");
		while(rs.next()){
			if (rs.getString("name").equals(Consts.nowbook)) break;
		}
	    tot.setText(Integer.toString(rs.getInt("tot")) + "��");
	    lastEditedTime.setText(rs.getString("lasteditedtime"));
	    series1 = new XYChart.Series<>();
	    XAxis = chart.getXAxis();
	    YAxis = chart.getYAxis();
	    series1.setName("��������");
	    XAxis.setLabel("�����ι̶�");
	    YAxis.setLabel("��Ƭ����");
	    
	    series1.getData().add(new XYChart.Data<>("A", 23));
	    rs = MainController.stmt.executeQuery("select * from " + Consts.nowbook + Consts.userName + ";");
	    int[] count = new int[11];
	    while(rs.next()){
	    	Card c = new Card(rs.getString("lastEditedTime"), rs.getInt("familiar"), rs.getInt("vague"), rs.getInt("forgotten"));
	    	count[(int) Math.floor(c.rem()) * 10]++;
	    }
	    for (int i = 0;i < 11;i++)	series1.getData().add(new XYChart.Data<>("", count[i]));
	    chart.getData().clear();
	    chart.getData().add(series1);
	}
	
	@FXML
    void newABook(ActionEvent event) throws SQLException {
		SceneSets.newABook().showWindow();
    }
	@FXML
	void backToMenu(ActionEvent event) throws SQLException {
		specificPane.setVisible(false);
		initialize();
		pane.setVisible(true);
		newButton.setVisible(true);
	}
	@FXML
    void viewCards(ActionEvent event) throws Exception {
		SceneSets.viewCards().showWindow();
		SceneSets.viewCards().viewCardsController.initialize();
    }
    @FXML
    void startReview(ActionEvent event) throws Exception {
    	SceneSets.review().showWindow();
    }
    @FXML
    void rename(ActionEvent event){
    	SceneSets.rename().showWindow();
    }
    @FXML
    void delete(ActionEvent event) throws Exception{
    	SceneSets.deleteConfirm().showWindow();
    }
}
