package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/***********************************************************
 * @author SuBonan
 * 2020Äê11ÔÂ9ÈÕ
 * Management.mysql.MainController.java
 ***********************************************************/

public class MainController {
 	private static Connection connect;
    public static Statement stmt;
    public static void generate(){
    	try{
    		Class.forName("com.mysql.cj.jdbc.Driver"); 
    		System.out.println("Success loading Mysql Driver!");
    	}
    	catch (Exception e){
    	    System.out.print("Error loading Mysql Driver!");
    	    e.printStackTrace();
    	}
    	try {
    	    connect = DriverManager.getConnection(
    	    "jdbc:mysql://localhost:3306/maindatabase?serverTimezone=Asia/Shanghai", "root", "root");
    	    System.out.println("Success connect Mysql server!"
    	);
    	    stmt = connect.createStatement();
    	}
    	catch (Exception e) {
    	    System.out.print("get data error!");
    	    e.printStackTrace();
    	}
    }
	public static void main(String[] args){
		
	}
}
