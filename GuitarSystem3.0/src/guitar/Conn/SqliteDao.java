package guitar.Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqliteDao implements DbConn {
	private static final String DBDRIVER = "org.sqlite.JDBC";
	private static final String DBURL = "jdbc:sqlite://e:/sqlitedata/instrument2.db";

	public Connection getconn() {
		Connection conn=null;
		try{
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL);
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		} 
		catch (SQLException e) {
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
