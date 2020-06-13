package Database;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Connect {
    public static Connection getConnect() {
	Connection con = null;
	String url = "jdbc:mysql://localhost:3306/thongtinkhachhang";
	String user = "root";
	String password = "";
	try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Success");
	} catch (Exception er) {
            System.out.println("False");
            er.printStackTrace();
	}
	return con;
    }
    public static void main(String[] args){
        getConnect();
    }

    static Object getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
