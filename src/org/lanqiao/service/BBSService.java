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
	
	
	//��ѯ������Ϣ
	public ArrayList<TopicInfor> queryAllPostInfor() throws SQLException{
		ArrayList<TopicInfor> list =BBSServiceImpl.getInstance().queryTopicUserInfor();
		return list;
	}
	//��ѯ������Ϣ
	public ArrayList<RelyInfor> queryAllRepliesInfor(String id) throws SQLException{
		ArrayList<RelyInfor> list =BBSServiceImpl.getInstance().queryRelyUserInfor(new Object[]{id});
		return list;
	}
	


	
	//����һ���û��Ƿ���ڣ�ͬʱ��������
/*	public ArrayList<RelyInfor> lookupUser(String username) throws SQLException{
		String sql = "select * from topic where author = ?";
		ArrayList<RelyInfor> list = BBSServiceImpl.getInstance().queryAllUserInfor(sql, new Object[]{username});
		return list;
	}*/

	//�鿴������Ϣ
	public BBSAuthorInfor getUserInfor(String author) throws SQLException {
		BBSAuthorInfor user =BBSServiceImpl.getInstance().queryUserInfor(new Object[]{author});
		return user;
	}


}
