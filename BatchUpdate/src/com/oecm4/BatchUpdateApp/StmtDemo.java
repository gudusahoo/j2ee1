package com.oecm4.BatchUpdateApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StmtDemo {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		String qry1="update oecm4.student1 set name='munni' where id=4";
		String qry2="insert into saumya.j2ee values(1,'sunny')";
		String qry3="delete from oecm4.student where dept='ece'";
		String qry4="insert into saumya.j2ee values(2,'bharath')";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=abc@123");
			stmt=con.createStatement();
			stmt.addBatch(qry1);
			stmt.addBatch(qry2);
			stmt.addBatch(qry3);
			stmt.addBatch(qry4);
			int[] arr=stmt.executeBatch();
			for(int i:arr)
			{
				System.out.println(i);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		
		}
		

	}

}
