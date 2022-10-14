package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DungChung {
	public Connection cn;
	public void KetNoi() throws Exception{
		//B1: Xac dinh HQTCSDl
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	System.out.println("Da xac dinh HQLCSDL");
    	//B2: Ket Noi
    	String url="jdbc:sqlserver://DESKTOP-RELDF1S\\SQLEXPRESS:1433;databaseName=QLProject;user=sa; password=123";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
}
	public static void main(String[] args) throws Exception{
		DungChung dc = new DungChung();
		dc.KetNoi();
		
	}
}