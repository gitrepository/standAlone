package com.swing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String sqlDriver = "net.sourceforge.jtds.jdbc.Driver";
	private static final String oracleDriver = "oracle.jdbc.OracleDriver";
	
	private static final String sqlUrl = "jdbc:jtds:sqlserver://gdot-govsql01:1932;DatabaseName=contract_ledger";
	//private static final String oraclelUrl = "jdbc:oracle:thin:@db-cmis-prod1:1522:cmis1";
	private static final String oraclelUrl = "jdbc:oracle:thin:@db-edw-dev:1523:edw_dev";

	public static Connection getSQLServerConnection(){
        try {
			Class.forName(sqlDriver);
	        Connection con = DriverManager.getConnection(sqlUrl, "ledger_user", "ledgeruser01");
	        System.out.println("SQL Server Connected");
	        return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Connection getOrcaleServerConnection(){
        try {
			Class.forName(oracleDriver);
	        //Connection con = DriverManager.getConnection(oraclelUrl, "cmis_app", "cmis_app01");
	        Connection con = DriverManager.getConnection(oraclelUrl, "user_cmis_link", "kImQBN74");
	        System.out.println("Orcale Connected");
	        return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void closeConnection(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
