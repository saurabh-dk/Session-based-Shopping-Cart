package Model;

import java.io.File;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;

public class ShoppingDBConnection {
	
	private static DataSource datasource;
   
	public static DataSource getDataSource(){
		
		HikariDataSource ds=null;
		if(datasource==null){
			
			/*File file = new File("resources/config.properties");
			String absolutePath = file.getAbsolutePath();
			absolutePath =absolutePath.replace("\\", "/");
			*/
			HikariConfig config = new HikariConfig("/config.properties");
			
			ds = new HikariDataSource(config);
			
		}
		
		return ds;
	}

}
