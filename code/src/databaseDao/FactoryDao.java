package databaseDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FactoryDao {
	
	// 存放Connection对象的数组，数组被看成连接池
	static ArrayList<Connection> list = new ArrayList<Connection>();
	
	
	/**
	 * @discription 获得链接
	 * @return Connection对象
	 */
	public synchronized static Connection getConnection() {
		
		Connection con = null;
		
		//驱动程序
        String driver = "com.mysql.jdbc.Driver";
        
        //URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://localhost:3306/wordbook";
        
        //MySQL配置时的用户
       String user = "root";
       
        //MySQL配置时的密码
       String password = "root";
		
		//如果连接池中有对象
		if (list.size() > 0) {
			
			return list.remove(0);
			
		} else { // 连接池没有对象创建连接放到连接池中
			
			for (int i = 0; i < 5; i++) {
				
				try {
					
					Class.forName(driver);
					
				} catch(ClassNotFoundException e) {
					
					e.printStackTrace();
					
				}

				try { // 创建连接
					
					con = DriverManager.getConnection(url, user, password);
					list.add(con);
					
				} catch (SQLException e) {
					
					e.printStackTrace();
					
				}
				
			}
			
		}
		
		return list.remove(0);
		
	}
	
	
	/**
	 * @discription 关闭结果集合
	 * @param rs 结果集对象
	 */
	public static void close(ResultSet rs) {
		
		if (rs != null) {
			
			try {
				
				rs.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	
	/**
	 * @discription 关闭预处理
	 * @param pst 预处理对理
	 */
	public static void close(PreparedStatement pst) {
		
		if (pst != null) {
			
			try {
				
				pst.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	
	/**
	 * @discription 关闭连接
	 * @param con 连接对象
	 */
	public synchronized static void close(Connection con) {
		
		if (con != null) {
			
			list.add(con);
			
		}
		
	}
	
	
	/**
	 * @discription 关闭
	 * @param rs 结果集对象
	 * @param ps 预处理对象
	 * @param con 连接对象
	 */
	public static void close(ResultSet rs, PreparedStatement ps, Connection con ) {
		
		close(rs);
		close(ps);
		close(con);
		
	}
	
	
	/**
	 * @discription 新增、修改、删除处理
	 * @param sql SQL语句
	 * @param param SQL语句中的通配符对应的值，如果SQL语句无�?�配符，该数组为null
	 * @return boolean
	 */
	public boolean upadateByParams(String sql, Object param[]) {
		
		boolean flag = false;
		Connection con = getConnection();
		PreparedStatement ps = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			
			if (param != null) {
				
				for (int i = 1; i <= param.length; i++) {
			    		
				   ps.setObject(i, param[i - 1]);
				
				}
				
			}
			
			int n = ps.executeUpdate();
			
			if (n > 0) {
				
				flag = true;
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
        } finally {
			
			close(null, ps, con);
			
		}
		
		return flag;
		
	}
	
	
	/**
	 * @discription 新增、修改、删除 多条记录（批量处理）
	 * @param sql SQL语句
	 * @param param SQL语句中的通配符对应的值，
	 * 数组的长度代表处理的记录数，
	 * {{X,X,X},{X,X,X},{X,X,X}}
	 * 其中{X, X, X}每个SQL语句中的参数名
	 * @return boolean
	 */
	public boolean BatchUpadateByParams(String sql, Object param[][]){
		
		Connection con = getConnection();
		PreparedStatement ps = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			
			if ( param != null) {
				
				for ( int i = 0; i < param.length; i++) {                   //多条记录
					
					for ( int j = 1; j <= param[i].length; j++) {           //每条记录里的参数替换
						
						ps.setObject(j, param[i][j - 1]);
						
					}
					
					ps.addBatch();
					
				}
				
				ps.executeBatch();
				
			}
			
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			return false;
			
		} finally {
			
			close(null, ps, con);
			
		}	
		
	}
	
	
	/**
	 * @discription 查询
	 * @param sql SQL语句
	 * @param param SQL语句中的通配符对应的值
	 * @return List<Map<String, Object>>
	 */
	public static List<Map<String,Object>> select (String sql, Object[] param){
		
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		try {
			
			ps = con.prepareStatement(sql);
			
			if ( param != null ) {
				
				for ( int i = 1; i <= param.length; i++ ) {
					
					ps.setObject(i, param[i - 1]);
					
				}
				
			}
			
			rs = ps.executeQuery();
			ResultSetMetaData rm = rs.getMetaData();
			
			// 列数
			int count = rm.getColumnCount();
			while (rs.next()) {
				
				Map<String,Object> map = new HashMap<String, Object>();
				for ( int i = 1; i <= count; i++) {
					
					//key为列名，value为列�?
					map.put(rm.getColumnName(i).toLowerCase(), rs.getObject(rm.getColumnName(i)));
					
				}
				
				list.add(map);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		} finally {
			
			close(rs, ps, con);
		
		}
		return list;
	}
	
	
	/**
	 * @discription 获取时间串
	 * @return String
	 */
	public static String getStringID() {
		
		String id = null;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		id = sdf.format(date);
		
		return id;
		
	}
	
}
