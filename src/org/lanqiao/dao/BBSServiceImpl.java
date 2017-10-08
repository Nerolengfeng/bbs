package org.lanqiao.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.lanqiao.util.OjdbcUtil;


import model.BBSAuthorInfor;
import model.RelyInfor;
import model.TopicInfor;


public class BBSServiceImpl {
	//--------------------单例模式
	private static BBSServiceImpl employeeServiceImpl = null;
	private BBSServiceImpl(){
		
	}
	public static BBSServiceImpl getInstance(){
		if(employeeServiceImpl==null){
			employeeServiceImpl=new BBSServiceImpl();
		}
		return employeeServiceImpl;
	}
	//------------------单例模式
	
	
	
	//查询帖子回复的信息
	public ArrayList<RelyInfor> queryRelyUserInfor(Object[] params) throws SQLException{
		String sql = "select t.title,r.* from topic t,reply r where t.id=r.topic_id and t.id=? ";
		List<HashMap<String,Object>> list = OjdbcUtil.executeQuery(sql, params);
		ArrayList<RelyInfor> arr = new ArrayList<>();
		if(list.size()>0){
			for(int i = 0;i<list.size();i++){
				String title	 	 = String.valueOf(list.get(i).get("TITLE"));
				String id			 = String.valueOf(list.get(i).get("ID"));
				String reply_author	 = String.valueOf(list.get(i).get("REPLY_AUTHOR"));
				String reply_content = String.valueOf(list.get(i).get("REPLY_CONTENT"));
				String reply_date  	 = String.valueOf(list.get(i).get("REPLY_DATE"));
				String topic_id		 = String.valueOf(list.get(i).get("TOPIC_ID"));
				RelyInfor user		 = new RelyInfor(title,id,reply_author,reply_content,reply_date,topic_id);
				arr.add(user);
			}
		}
		OjdbcUtil.close();
		return arr;
	}

	
	//增加用户，不用ID，id用自动增加,删除用户，修改用户
	public int updateUser(String sql,Object[] params) throws SQLException{
		int result = OjdbcUtil.executeUpdate(sql, params);
		OjdbcUtil.close();
		return result;
	}
	//查看用户详细信息
	public BBSAuthorInfor queryUserInfor(Object[] params) throws SQLException{
		String sql = "select t.header,b.* from bbs_user b,topic t where  b.nickname = t.author and b.nickname=?  ";
		BBSAuthorInfor user = null;
		List<HashMap<String,Object>> list = OjdbcUtil.executeQuery(sql, params);
		if(list.size()>0){
			String id = String.valueOf(list.get(0).get("ID"));
			String username = String.valueOf(list.get(0).get("USERNAME"));
			String nickname = String.valueOf(list.get(0).get("NICKNAME"));
			String password = String.valueOf(list.get(0).get("PASSWORD"));
			String email 	= String.valueOf(list.get(0).get("EAMIL"));
			String idcard   = String.valueOf(list.get(0).get("IDCARD"));
			String sex 		= String.valueOf(list.get(0).get("SEX"));
			String telphone = String.valueOf(list.get(0).get("TELEPHONE"));
			String qq 		= String.valueOf(list.get(0).get("QQ"));
			String img		= String.valueOf(list.get(0).get("HEADER"));
			user = new BBSAuthorInfor(id,username,nickname,password,email,idcard,sex,telphone,qq,img);
		}
		OjdbcUtil.close();
		return user;
	}
	//这是查看帖子的；
	public ArrayList<TopicInfor> queryTopicUserInfor() throws SQLException {
		String sql = "select * from topic ";
		List<HashMap<String,Object>> list = OjdbcUtil.executeQuery(sql, null);
		ArrayList<TopicInfor> arr = new ArrayList<>();
		if(list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				String id = String.valueOf(list.get(i).get("ID"));
				String title = String.valueOf(list.get(i).get("TITLE"));
				String author = String.valueOf(list.get(i).get("AUTHOR"));
				String createtime = String.valueOf(list.get(i).get("CREATETIME"));
				String header = String.valueOf(list.get(i).get("HEADER"));
				TopicInfor top = new TopicInfor(id,title,author,createtime,header);
				arr.add(top);
			}
		}
		return arr;
	}
	
	
	
	
}
