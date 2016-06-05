package guitar.IDao;

import java.util.List;
import guitar.Model.Guitar;

public interface GuitarIDao {
	public List<Guitar> findAll() throws Exception;
	
	public boolean doCreate(Guitar guitar) throws Exception;
	
	public boolean doDelete(String serialNumber ) throws Exception;
	
}
