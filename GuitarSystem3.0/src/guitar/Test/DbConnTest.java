package guitar.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import guitar.Conn.DbConn;
import guitar.Conn.DbFactory;

public class DbConnTest {

	public static void main(String[] args) throws SQLException {
		DbConn connif=DbFactory.getcon("guitar.Conn.SqliteDao");
		PreparedStatement pstmt = null;
		Connection conn=null;
		conn=connif.getconn();
		String sql1 = "INSERT INTO guitar(serialNumber,price,builder,model,type,backWood,topWood) VALUES (?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, "112389");
			pstmt.setDouble(2, 3999.95);
			pstmt.setString(3, "COLLINGS");
			pstmt.setString(4, "CJ");
			pstmt.setString(5, "ACOUSTIC");
			pstmt.setString(6, "SITKA");
			pstmt.setString(7, "MAPLE");
			if (pstmt.executeUpdate() > 0) {
				System.out.print("sql1 yeah");
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql2 = "INSERT INTO guitar(serialNumber,price,builder,model,type,backWood,topWood) VALUES (?,?,?,?,?,?,?)";

		pstmt = conn.prepareStatement(sql2);
		pstmt.setString(1, "V95323");
		pstmt.setDouble(2, 1499.95);
		pstmt.setString(3, "FENDER");
		pstmt.setString(4, "STRATOCASTOR");
		pstmt.setString(5, "ELECTRIC");
		pstmt.setString(6, "ALDER");
		pstmt.setString(7, "ALDER");
		if (pstmt.executeUpdate() > 0) {
			System.out.print("sql2 yeah");
		}
		String sql3 = "INSERT INTO guitar(serialNumber,price,builder,model,type,backWood,topWood) VALUES (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql3);
		pstmt.setString(1, "V35843");
		pstmt.setDouble(2,  1549.95);
		pstmt.setString(3, "ALDER");
		pstmt.setString(4, "STRATOCASTOR");
		pstmt.setString(5, "ELECTRIC");
		pstmt.setString(6, "MAHOGANY");
		pstmt.setString(7, "MAPLE");
		if (pstmt.executeUpdate() > 0) {
			System.out.print("sql3 yeah");
		}
	}

}
