package com.db;

import java.sql.*;

public class DBHelper {	
	private String dbUrl="jdbc:mysql://localhost:3306/sushe";
	private String dbUser="root";
	private String dbPassword="root";
	private String jdbcName="com.mysql.jdbc.Driver";
	
	//�������ݿ�
	public Connection getConn(){
		Connection conn = null;
		try{
			Class.forName(jdbcName);
		}
		catch(Exception e){}
		try{
			conn=DriverManager.getConnection(dbUrl,dbUser,dbPassword);
			if(!conn.isClosed()){
				System.out.println("success");
				Statement statement = conn.createStatement();
				//要执行的SQL语句

				String sql="select * from Student where Student_Username='"+2+"' and Student_Password='"+123+"'";
				//3.ResultSet类，用来存放获取的结果集！！
				ResultSet rs = statement.executeQuery(sql);
				String job = null;
				String id = null;
                while (rs.next()) {
                    id = rs.getString("Student_ID");
					System.out.println(id);
				}
			}
		}
		catch(SQLException ex){

			System.out.println(ex);
		}
		return conn;		
	}
	
//    ����
	public static void main(String[] args)
	{
		System.out.println(new DBHelper().getConn());
		
	}
	
}
