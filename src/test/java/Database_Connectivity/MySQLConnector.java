package Database_Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class MySQLConnector {
	public static void main(String args[]) throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://" + "localhost" + ":" + "3306" + "/qadbt", "root","root@123");
		
		Statement st= con.createStatement();
		ResultSet rs= st.executeQuery("select * from Employeeinfo");
		while(rs.next())
		{
			System.out.println("//*****************************//");
			System.out.println("Name: "+ rs.getString("name"));
			System.out.println("ID: "+ rs.getString("id"));
			System.out.println("Location: "+ rs.getString("location"));
			System.out.println("Age: "+ rs.getString("age"));
			System.out.println("*******************");
		}
	}
}
