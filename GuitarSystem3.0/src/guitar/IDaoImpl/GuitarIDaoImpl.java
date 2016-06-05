package guitar.IDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import guitar.Conn.DbConn;
import guitar.Conn.DbFactory;
import guitar.IDao.GuitarIDao;
import guitar.Model.Guitar;
import guitar.Model.Builder;
import guitar.Model.GuitarSpec;
import guitar.Model.Type;
import guitar.Model.Wood;

public class GuitarIDaoImpl implements GuitarIDao{
	 DbConn connif=DbFactory.getcon("guitar.Conn.SqliteDao"); 
	 //DbConn connif=DbFactory.getcon("guitar.Conn.MysqlDao"); 
	 Connection conn=connif.getconn();
	 PreparedStatement pstmt = null;
	 
	@Override
	public  List<Guitar> findAll() throws Exception {
		  String sql="select * from guitar";
			PreparedStatement stmt=conn.prepareStatement(sql);
			ResultSet rs= stmt.executeQuery();
			List guitars = new ArrayList();
			while (rs.next()) {
				Guitar guitar2 = new Guitar();
				GuitarSpec spec2= new GuitarSpec();
				spec2.setBuilder(Builder.valueOf(rs.getString("builder").toUpperCase()));
				spec2.setBackWood(Wood.valueOf(rs.getString("backWood").toUpperCase()));
				spec2.setTopWood(Wood.valueOf(rs.getString("topWood").toUpperCase()));
				spec2.setModel(rs.getString("model").toUpperCase());
				spec2.setType(Type.valueOf(rs.getString("type").toUpperCase()));
				guitar2.setPrice(rs.getDouble("price"));
				guitar2.setSerialNumber(rs.getString("serialNumber"));
				guitar2.setGuitarSpec(spec2);
				guitars.add(guitar2);
				System.out.println(guitar2);
			}
			stmt.close();
		
			return guitars;
	}

	@Override
	public boolean doCreate(Guitar guitar) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO Guitar(serialNumber,price,builder,model,type,backWood,topWood) VALUES (?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, guitar.getSerialNumber());
		this.pstmt.setDouble(2, guitar.getPrice());
		this.pstmt.setString(3, guitar.getSpec().getBuilder().toString().toUpperCase());
		this.pstmt.setString(4, guitar.getSpec().getModel().toString().toUpperCase());
		this.pstmt.setString(5, guitar.getSpec().getType().toString().toUpperCase());
		this.pstmt.setString(6, guitar.getSpec().getBackWood().toString().toUpperCase());
		this.pstmt.setString(7, guitar.getSpec().getTopWood().toString().toUpperCase());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;

	}

	@Override
	public boolean doDelete(String serialNumber) throws Exception {
		boolean flag = false;
		String sql = "delete from guitar where serialNumber=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, serialNumber);
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

}
