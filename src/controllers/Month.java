package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import mysql.Consts;
import mysql.MainController;

/***********************************************************
 * @author SuBonan
 * 2020Äê11ÔÂ9ÈÕ
 * ProgrammingHomework.problems.PrintCalender.java
 ***********************************************************/

public class Month{
	int[][] table = new int[7][7];
	
	boolean check(int year){
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
	boolean[] pd = new boolean[40];
	
	Month(int year, int month) throws SQLException{
		for (int i = 0;i < 7;i++)	for(int j = 0;j < 7;j++)	table[i][j] = 0;
		LocalDate d1 = LocalDate.of(2020, 11, 9);
		LocalDate d2 = LocalDate.of(year, month, 1);
		int firstDay = (int)((ChronoUnit.DAYS.between(d1, d2) % 7 + 7) % 7) + 1;
		int days = 0;
		switch (month){
		case 1:
			days = 31; break;
		case 2:
			days = check(year) ? 29 : 28;break;
		case 3:
			days = 31;break;
		case 4:
			days = 30;break;
		case 5:
			days = 31;break;
		case 6:
			days = 30;break;
		case 7:
			days = 31;break;
		case 8:
			days = 31;break;
		case 9:
			days = 30;break;
		case 10:
			days = 31;break;
		case 11:
			days = 30;break;
		case 12:
			days = 31;break;
	}
		for (int i = 1;i <= days;i++)	pd[i] = false;
		ResultSet rs = MainController.stmt.executeQuery("select * from count" + Consts.nowbook + Consts.userName + ";");
		while(rs.next()){
			String da = rs.getString("time");
			if (da.substring(0, 7).equals(Consts.curDate.substring(0, 7))){
				pd[Integer.valueOf(da.substring(8, 10))] = true;
			}
		}
		int x = 0, y = firstDay;
		if (y == 7)	y = 0;
		for (int i = 1;i <= days;i++) if (!pd[i]){
			table[x][y] = i;
			y++;
			if (y == 7){
				y = 0;x++;
			}
		}else{
			table[x][y] = -1;
			y++;
			if (y == 7){
				y = 0;x++;
			}
		}
	}
}
