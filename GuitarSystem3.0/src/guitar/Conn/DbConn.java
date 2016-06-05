package guitar.Conn;
import java.sql.*;

public interface DbConn {
	 public Connection getconn();
     public void closed(ResultSet set, PreparedStatement pre, Connection conn);

}
