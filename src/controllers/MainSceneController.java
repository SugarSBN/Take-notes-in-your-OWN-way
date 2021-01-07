package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import mysql.Consts;
import mysql.MainController;
import sceneset.SceneSets;

/***********************************************************
 * @author SuBonan
 * 2020年11月10日
 * Management.controllers.MainSceneController.java
 ***********************************************************/

public class MainSceneController{
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
	
	@FXML
	private Label calendar1, calendar2, calendar3, calendar4, calendar5, calendar6;
	
	@FXML
	private TextField num;
	
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
	    	 book1.setText(rs.getString("name") + "\n" + rs.getString("tot") + "张\n" + rs.getString("lastEditedTime").substring(5));
	     }
	     if (rs.next()){
	    	 book2.setVisible(true);
	    	 book2.setText(rs.getString("name") + "\n" + rs.getString("tot") + "张\n" + rs.getString("lastEditedTime").substring(5));
	     }
	     if (rs.next()){
	    	 book3.setVisible(true);
	    	 book3.setText(rs.getString("name") + "\n" + rs.getString("tot") + "张\n" + rs.getString("lastEditedTime").substring(5));
	     }
	     if (rs.next()){
	    	 book4.setVisible(true);
	    	 book4.setText(rs.getString("name") + "\n" + rs.getString("tot") + "张\n" + rs.getString("lastEditedTime").substring(5));
	     }
	     if (rs.next()){
	    	 book5.setVisible(true);
	    	 book5.setText(rs.getString("name") + "\n" + rs.getString("tot") + "张\n" + rs.getString("lastEditedTime").substring(5));
	     }
	     if (rs.next()){
	    	 book6.setVisible(true);
	    	 book6.setText(rs.getString("name") + "\n" + rs.getString("tot") + "张\n" + rs.getString("lastEditedTime").substring(5));
	     }
	     if (rs.next()){
	    	 book7.setVisible(true);
	    	 book7.setText(rs.getString("name") + "\n" + rs.getString("tot") + "张\n" + rs.getString("lastEditedTime").substring(5));
	     }
	     if (rs.next()){
	    	 book8.setVisible(true);
	    	 book8.setText(rs.getString("name") + "\n" + rs.getString("tot") + "张\n" + rs.getString("lastEditedTime").substring(5));
	     }
	     if (rs.next()){
	    	 book9.setVisible(true);
	    	 book9.setText(rs.getString("name") + "\n" + rs.getString("tot") + "张\n" + rs.getString("lastEditedTime").substring(5));
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
	  //  tot.setText(Integer.toString(rs.getInt("tot")) + "张");
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
	   // tot.setText(Integer.toString(rs.getInt("tot")) + "张");
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
	   // tot.setText(Integer.toString(rs.getInt("tot")) + "张");
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
	    //tot.setText(Integer.toString(rs.getInt("tot")) + "张");
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
	    //tot.setText(Integer.toString(rs.getInt("tot")) + "张");
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
	   // tot.setText(Integer.toString(rs.getInt("tot")) + "张");
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
	    //tot.setText(Integer.toString(rs.getInt("tot")) + "张");
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
	   // tot.setText(Integer.toString(rs.getInt("tot")) + "张");
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
	    //tot.setText(Integer.toString(rs.getInt("tot")) + "张");
	    //lastEditedTime.setText(rs.getString("lasteditedtime"));
    }
	
	
    Series<String, Number> series1 = new XYChart.Series<>();
    
    private String emoji(){
    	int tp = (int)(Math.random()*10);
    	tp %= 5;
    	if (tp == 0)	return "^_^";
    	else 
    	if (tp == 1)	return "^w^";
    	else
    	if (tp == 2)	return ">w<";
    	else
    	if (tp == 3)	return "QwQ";
    	else
    	if (tp == 4)	return "-w-";
    	else	return ">_<";
    }
    
	void flesh() throws SQLException{
		
		ResultSet rs = MainController.stmt.executeQuery("select * from books where owner=\"" + Consts.userName + "\";");
		while(rs.next()){
			if (rs.getString("name").equals(Consts.nowbook)) break;
		}
	    tot.setText(Integer.toString(rs.getInt("tot")) + "张");
	    lastEditedTime.setText(rs.getString("lasteditedtime"));
	    
	    series1 = new XYChart.Series<>();
	    XAxis = chart.getXAxis();
	    YAxis = chart.getYAxis();
	    series1.setName("遗忘曲线");
	    XAxis.setLabel("记忆牢固度");
	    YAxis.setLabel("卡片数量");
	    
	    series1.getData().add(new XYChart.Data<>("0", 0));
	    rs = MainController.stmt.executeQuery("select * from " + Consts.nowbook + Consts.userName + ";");
	    List<Double> lsh = new ArrayList<>();
	    while(rs.next()){
	    	Card c = new Card(rs.getString("lastEditedTime"), rs.getInt("familiar"), rs.getInt("vague"), rs.getInt("forgotten"));
	    	lsh.add(c.rem());
	    }
	    for (int i = 0;i < lsh.size();i++){
	    	int cnt = 0;
	    	for (int j = 0;j < lsh.size();j++){
	    		int id = 0;
	    		for (int k = 0;k < lsh.size();k++)	if (lsh.get(k) < lsh.get(j))	id++;
	    		if (id == i)	cnt++;
	    	}
	    	series1.getData().add(new XYChart.Data<>(Integer.toString(i), cnt));
	    }
	    chart.getData().clear();
	    chart.getData().add(series1);
	    
	    Month mon = new Month(Integer.valueOf(Consts.curDate.substring(0, 4)), Integer.valueOf(Consts.curDate.substring(5, 7)));
	    String line = "  ";
	    
	    line = "  ";
	    for (int i = 0;i < 7;i++)	if (mon.table[0][i] == 0)	line = line + "     ";
	    else if (mon.table[0][i] == -1)	line = line + emoji() + "  ";
	    else if (mon.table[0][i] < 10)	line = line + " " + mon.table[0][i] + "   ";
	    else line = line + " " + mon.table[0][i] + "  ";
	    calendar1.setText(line);
	    
	    line = "  ";
	    for (int i = 0;i < 7;i++)	if (mon.table[1][i] == 0)	line = line + "     ";
	    else if (mon.table[1][i] == -1)	line = line + emoji() + "  ";
	    else if (mon.table[1][i] < 10)	line = line + " " + mon.table[1][i] + "   ";
	    else line = line + " " + mon.table[1][i] + "  ";
	    calendar2.setText(line);
	    
	    line = "  ";
	    for (int i = 0;i < 7;i++)	if (mon.table[2][i] == 0)	line = line + "     ";
	    else if (mon.table[2][i] == -1)	line = line + emoji() + "  ";
	    else if (mon.table[2][i] < 10)	line = line + " " + mon.table[2][i] + "   ";
	    else line = line + " " + mon.table[2][i] + "  ";
	    calendar3.setText(line);
	    
	    line = "  ";
	    for (int i = 0;i < 7;i++)	if (mon.table[3][i] == 0)	line = line + "     ";
	    else if (mon.table[3][i] == -1)	line = line + emoji() + "  ";
	    else if (mon.table[3][i] < 10)	line = line + " " + mon.table[3][i] + "   ";
	    else line = line + " " + mon.table[3][i] + "  ";
	    calendar4.setText(line);
	    
	    line = "  ";
	    for (int i = 0;i < 7;i++)	if (mon.table[4][i] == 0)	line = line + "     ";
	    else if (mon.table[4][i] == -1)	line = line + emoji() + "  ";
	    else if (mon.table[4][i] < 10)	line = line + " " + mon.table[4][i] + "   ";
	    else line = line + " " + mon.table[4][i] + "  ";
	    calendar5.setText(line);
	
	    line = "  ";
	    for (int i = 0;i < 7;i++)	if (mon.table[5][i] == 0)	line = line + "     ";
	    else if (mon.table[5][i] == -1)	line = line + emoji() + "  ";
	    else if (mon.table[5][i] < 10)	line = line + " " + mon.table[5][i] + "   ";
	    else line = line + " " + mon.table[5][i] + "  ";
	    calendar6.setText(line);
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
    	if (num.getText().length() == 0)	Consts.rev = 100;
    	else
    	Consts.rev = Math.max(0, Integer.valueOf(num.getText()));
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
