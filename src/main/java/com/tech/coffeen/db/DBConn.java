package com.tech.coffeen.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {

	static Connection connectt;
	public static Connection getConnection() {
        try {
			String driver="oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="coffeen";
			String pw="123456";
			Class.forName(driver);
			connectt=DriverManager.getConnection(url,user,pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return connectt;
	}
}
