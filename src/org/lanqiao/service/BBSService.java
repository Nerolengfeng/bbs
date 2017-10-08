package org.lanqiao.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.lanqiao.dao.BBSServiceImpl;

import model.BBSAuthorInfor;
import model.RelyInfor;
import model.TopicInfor;


public class BBSService {
	
	
	//查询发帖信息
	public ArrayList<TopicInfor> queryAllPostInfor() throws SQLException{
		ArrayList<TopicInfor> list =BBSServiceImpl.getInstance().queryTopicUserInfor();
		return list;
	}
	//查询回帖信息
	public ArrayList<RelyInfor> queryAllRepliesInfor(String id) throws SQLException{
		ArrayList<RelyInfor> list =BBSServiceImpl.getInstance().queryRelyUserInfor(new Object[]{id});
		return list;
	}
	


	
	//查找一个用户是否存在，同时返回数据
/*	public ArrayList<RelyInfor> lookupUser(String username) throws SQLException{
		String sql = "select * from topic where author = ?";
		ArrayList<RelyInfor> list = BBSServiceImpl.getInstance().queryAllUserInfor(sql, new Object[]{username});
		return list;
	}*/

	//查看作者信息
	public BBSAuthorInfor getUserInfor(String author) throws SQLException {
		BBSAuthorInfor user =BBSServiceImpl.getInstance().queryUserInfor(new Object[]{author});
		return user;
	}


}
