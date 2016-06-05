package guitar.Conn;

public class DbFactory {
	public static DbConn getcon(String name){
		DbConn con=null;
		try{
			Class c=Class.forName(name);
			con=(DbConn) c.newInstance();
		}
		catch(ClassNotFoundException | InstantiationException | IllegalAccessException e){
			e.printStackTrace();
		}
		return con;
	}
}
