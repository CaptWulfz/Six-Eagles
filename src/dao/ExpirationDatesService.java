package dao;

import java.sql.*;
import java.util.ArrayList;

import model.ExpirationDates;

public class ExpirationDatesService {
	
	public static ArrayList<ExpirationDates> getExpirationDatesListByProductID(int id) throws SQLException {
		Connection c = dbconnect.getDBConnection();
		String sql = "SELECT * FROM eagle.expirationdates WHERE productID = ? ORDER BY manufactureDate ASC;";
		ArrayList<ExpirationDates> list = new ArrayList<ExpirationDates>();
		
		PreparedStatement p = c.prepareStatement(sql);
		p.setInt(1, id);
		ResultSet rs = p.executeQuery();
		while (rs.next()) {
			list.add(new ExpirationDates(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
		}
		
		c.close();
		
		return list;
	}
	
	public static void removeProduct(int id) throws SQLException {
		Connection c = dbconnect.getDBConnection();
		String sql = "DELETE FROM eagle.expirationdates WHERE entryID = ?;";
		
		PreparedStatement p = c.prepareStatement(sql);
		p.setInt(1, id);
		p.executeUpdate();
		
		c.close();
	}
	
}
