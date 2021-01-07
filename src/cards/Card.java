package cards;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

import mysql.Consts;
import mysql.MainController;

/***********************************************************
 * @author SuBonan
 * 2020Äê11ÔÂ23ÈÕ
 * Management.cards.Card.java
 ***********************************************************/

public class Card implements Comparable<Card>{
	public String lastEditedTime, front, back, brief;
	public int familiar, vague, forgotten, times;
	public Card(String lastEditedTime, String front, String back, String brief, int familiar, int vague,int forgotten){
		this.lastEditedTime = lastEditedTime;
		this.front = front;
		this.back = back;
		this.familiar = familiar;
		this.vague = vague;
		this.forgotten = forgotten;
		this.brief = brief;
		this.times = 1;
	}
	public Card(String lastEditedTime, int familiar, int vague,int forgotten){
		this.lastEditedTime = lastEditedTime;
		this.familiar = familiar;
		this.vague = vague;
		this.forgotten = forgotten;
		this.times = 1;
	}
	public double rem(){
        LocalDate no = LocalDate.parse(Consts.curDate);
        String s = lastEditedTime == null ? "2020-01-01" : lastEditedTime;
		LocalDate ls = LocalDate.parse(s);
		int daysBetween = (int) ChronoUnit.DAYS.between(ls, no);
		
		double re = 1.0 - 0.56 * Math.pow(daysBetween * 24.0, 0.06);
		if (familiar + vague + forgotten != 0)	re *= (0.8 * familiar + 0.5 * vague) / (familiar + vague + forgotten);
		
		return re;
	}
	public void modify() throws SQLException{
		String bm = Consts.nowbook + Consts.userName;
		MainController.stmt.execute("UPDATE " + bm + " set lastEditedTime=\"" + lastEditedTime + "\" where brief=\"" + brief + "\";");
		MainController.stmt.execute("UPDATE " + bm + " set familiar=" + familiar + " where brief=\"" + brief + "\";");
		MainController.stmt.execute("UPDATE " + bm + " set vague=" + vague + " where brief=\"" + brief + "\";");
		MainController.stmt.execute("UPDATE " + bm + " set forgotten=" + forgotten + " where brief=\"" + brief + "\";");
	}
	@Override
	public int compareTo(Card o) {
		double r1 = rem();
		double r2 = o.rem();
		if (Math.abs(r1 - r2) <= 1e-9)	return 0;
		return r1 < r2 ? 1 : -1;
	}
}
