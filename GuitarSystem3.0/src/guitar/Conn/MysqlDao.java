package guitar.Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlDao implements DbConn {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/instrument?characterEncoding=UTF-8";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "123456";
	
	public Connection getconn() {
		Connection conn=null;
		try{
			Class.forName(DBDRIVER);
			conn=DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);	
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	return conn;
	}

	public void closed(ResultSet set, PreparedStatement pre, Connection conn) {
	    try{
	    	if(set!=null){
	    		set.close();
	    	}
	    	if(pre!=null){
	    		pre.close();
	    	}
	    	if(conn!=null){
	    		conn.close();
	    	}
	    }
	    catch (SQLException e){
	    	e.printStackTrace();
	    }

	}

	
}
