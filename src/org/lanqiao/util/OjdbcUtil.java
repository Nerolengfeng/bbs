package org.lanqiao.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;


/**
 * 这是odbc的连接，封装好的 
 * @author Nero
 *
 */
public class OjdbcUtil {
	//定义所有的静态常量
	static Properties proper =new Properties();

	private static final String DRIVER="driver";
	private static final String URL="url";
	private static final String USERNAME="username";
	private static final String PASSWORD="password";
	

	//本地变量，或者线程变量
	static ThreadLocal<Connection> container = new ThreadLocal<>();
	//本地变量，加载
	static{
		try {
			proper.load(OjdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	//1加载驱动
	static{
		try {
			Class.forName(proper.getProperty(DRIVER));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//2获取连接
	public static Connection getConnection(){
		Connection conn = container.get();
		try{
			if(conn==null || conn.isClosed()){
				conn = DriverManager.getConnection(proper.getProperty(URL),proper.getProperty(USERNAME),proper.getProperty(PASSWORD));
				System.out.println(new Date()+"连接数据库成功");
				container.set(conn);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
	
	//
	public static ArrayList<HashMap<String,Object>> executeQuery(String sql,Object[] params) throws SQLException{
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		Connection conn = getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		pst = conn.prepareStatement(sql);
		if(params!=null){
			for (int i = 0; i < params.length; i++) {
				pst.setObject(i+1, params[i]);
			}
		}
		rs = pst.executeQuery();
		int count = rs.getMetaData().getColumnCount();
		while(rs.next()){
			HashMap<String,Object> row = new HashMap<String, Object>();
			for (int i = 0; i < count; i++) {
				String key = rs.getMetaData().getColumnLabel(i+1);
				Object value = rs.getObject(key);
				row.put(key, value);
			}
			list.add(row);
		}
		if(rs!=null){
			rs.close();
			rs=null;
		}
		if(pst!=null){
			pst.close();
			pst=null;
		}
		
		
		return list;
	}
	
	
	public static int executeUpdate(String sql,Object[] params) throws SQLException{
		Connection conn = getConnection();
		PreparedStatement pst = null;
		int row = 0;
		pst = conn.prepareStatement(sql);
		if(params!=null){
			for (int i = 0; i < params.length; i++) {
				pst.setObject(i+1,params[i]);
			}
		}
		row = pst.executeUpdate();
		
		
		if(pst!=null){
			pst.close();
			pst=null;
		}
		
		return row;
		
	}
	
	public static void close(){
		if(container.get()!=null){
			try {
				container.get().close();
				System.out.println("数据库连接关闭");
				container.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	
}
