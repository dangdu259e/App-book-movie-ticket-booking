package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.event.IIOReadWarningListener;

import GraphicalUserInterface.CustomerInfo;
import GraphicalUserInterface.Login_S;
import GraphicalUserInterface.SoDoGhe;
import Object.Chairs;
import Object.Customer;
import Database.*;

public class queryprocess {
	private static Connection conn = Connect.getConnect();
	private static ResultSet rs = null;
	private static PreparedStatement pst= null; 
	private static PreparedStatement redChair= null; 
	private static String pass = Login_S.getPassword();
	private static String user = Login_S.getUsername();
	public static String TestConection() {
		try {
			conn = Connect.getConnect();
			return "Kết nối thành công";
		}catch(Exception e) {
			return "kết nối thất bại";
		}
		
	}
	public static boolean createUser (Customer customer) {
		String sql = "insert into thongtincanhan (hoten,sodienthoai, email,username,password,SoCMND)" +"values(?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,customer.getName());
			pst.setInt(2, customer.getPhoneNumber());
			pst.setString(3, customer.getEmail());
			pst.setString(4, customer.getUsername());
			pst.setString(5, customer.getPassword());
			pst.setInt(6, customer.getSoCMND());

			return pst.executeUpdate()>0;
		} catch (SQLException e) {	
			// TODO Auto-generated catch block
			return false;
		}
	}
	public static  boolean redChairs (Chairs chair) throws SQLException {
		int soCMND = getSCMND(pass,user);
		String sql1 = "insert into ghe (hoanh,tung,SoCMND)"+"values(?,?,?)";
		try {
			redChair = conn.prepareStatement(sql1);
			redChair.setInt(1,chair.getTrucHoanh());
			redChair.setInt(2,chair.getTrucTung());
			redChair.setInt(3,soCMND);
			return redChair.executeUpdate()>0;
		} catch (SQLException e) {
			return false;
		}
	}
	public static void setRedChairs () {
		String sql2 = "select hoanh,tung from ghe";
		try {
			Statement st = conn.createStatement(
                    ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery(sql2);
			while(rs.next()) {
				SoDoGhe.setColor(rs.getInt(1), rs.getInt(2));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static int getSCMND(String password,String username) throws SQLException {
		String sql =  "select SoCMND from thongtincanhan where password='"+ password +"' and username='"+ username+"'" ;
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		String CMND = "";
		if(rs.next()) {
			CMND = rs.getString(1);
			return Integer.parseInt(CMND);
		}
		return 0;
	}
}
