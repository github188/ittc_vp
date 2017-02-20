/**
 * <p>Title: PropertyUitls.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年3月24日
 * @version 1.0.0
 */
package cn.sh.ittc.uitls;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;




/**
 * <p>Title: PropertyUitls</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年3月24日
 */
public class PropertyUitls {
	
	public static String getProperty(String key) throws Exception {
		Properties prop = new Properties();
		InputStream fis = PropertyUitls.class.getClassLoader()
				.getResourceAsStream("datasource/sql_conn_jdbc.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}

	public static String getInitPwd(){
		Properties prop = new Properties();
		InputStream fis = PropertyUitls.class.getClassLoader()
				.getResourceAsStream("datasource/sql_conn_jdbc.properties");
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty("sh.ittc.init.pwd");
	}
}
