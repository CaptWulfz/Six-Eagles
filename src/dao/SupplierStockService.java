package dao;

import java.util.ArrayList;

import model.SupplierStock;

import java.sql.*;

public class SupplierStockService {
	
	public static void addSupplierStock(int supplierID, int ingredientID) {
		Connection c = dbconnect.getDBConnection();
		String sql = "INSERT INTO eagle.supplierstock(supplierID, ingredientID) VALUES (?, ?);";
		
		try {
			PreparedStatement p = c.prepareStatement(sql);
			p.setInt(1,  supplierID);
			p.setInt(2, ingredientID);
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static ArrayList<SupplierStock> getAllSupplierStock() {
		Connection c = dbconnect.getDBConnection();
		String sql = "SELECT * FROM eagle.supplierstock;";
		ArrayList<SupplierStock> stockList = new ArrayList<SupplierStock>();
		try {
			PreparedStatement p = c.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				stockList.add(new SupplierStock(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (stockList.isEmpty())
			return null;
		else
			return stockList;
		
	}
	
	public static ArrayList<SupplierStock> getSupplierStockBySupplierID(int supplierID) {
		Connection c = dbconnect.getDBConnection();
		String sql = "SELECT * FROM eagle.supplierstock WHERE supplierID = ?;";
		ArrayList<SupplierStock> stockList = new ArrayList<SupplierStock>();
		try {
			PreparedStatement p = c.prepareStatement(sql);
			p.setInt(1, supplierID);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				stockList.add(new SupplierStock(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (stockList.isEmpty())
			return null;
		else
			return stockList;
		
	}

}
