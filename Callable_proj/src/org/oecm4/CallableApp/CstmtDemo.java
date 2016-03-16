package org.oecm4.CallableApp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CstmtDemo {
	public static void main(String[] args) {
		Connection con=null;
		CallableStatement cstmt=null;
		ResultSet rs=null;
		String proc="{call oecm4.getStudent(?)}";
		Scanner scn=new Scanner(System.in);
		System.out.println("enter id");
		int id=scn.nextInt();
		scn.close();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=abc@123");
			cstmt=con.prepareCall(proc);
			cstmt.setInt(1, id);
			cstmt.execute();
			rs=cstmt.getResultSet();
			if(rs.next())
			{
				String name=
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
