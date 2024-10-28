package Database_Connectivity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import BaseTest.Base_Test;

public class MySQLConnector extends Base_Test {
	public MySQLConnector() throws IOException, FileNotFoundException {
		super();
	}

	public static void main(String args[]) throws SQLException, FileNotFoundException, IOException {
		MySQLConnector connector = new MySQLConnector();

		String db_name = connector.pr.getProperty("database_name");
		String db_user = connector.pr.getProperty("database_username");
		String db_pass = connector.pr.getProperty("database_password");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, db_user, db_pass);

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from Employeeinfo");
		while (rs.next()) {
			System.out.println("//*****************************//");
			System.out.println("Name: " + rs.getString("name"));
			System.out.println("ID: " + rs.getString("id"));
			System.out.println("Location: " + rs.getString("location"));
			System.out.println("Age: " + rs.getString("age"));
			System.out.println("*******************");
		}
	}
}
