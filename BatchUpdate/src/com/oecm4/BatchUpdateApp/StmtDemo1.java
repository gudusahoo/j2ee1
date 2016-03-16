package com.oecm4.BatchUpdateApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StmtDemo1 {
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		String qry1="delete from oecm4.student1 where dept=?";
		String qry2="delete from saumya.j2ee where id=1";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=abc@123");
			pstmt1=con.prepareStatement(qry1);
			pstmt2=con.prepareStatement(qry2);
			pstmt1.setString(1, "ise");
			pstmt1.addBatch();
			pstmt2.addBatch();
			
			int[] arr1=pstmt1.executeBatch();
			for(int i:arr1)
			{
				System.out.println(i);
			}
			int[] arr2=pstmt2.executeBatch();
			for(int i:arr2)
			{
				System.out.println(i);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(pstmt2!=null)
			{
				try {
					pstmt2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt1!=null)
			{
				try {
					pstmt1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		

	}

}
