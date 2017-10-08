package org.lanqiao.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lanqiao.service.BBSService;

import model.TopicInfor;


@WebServlet("/QueryPostServlet")
public class QueryPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public QueryPostServlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BBSService bbs = new BBSService();
		ArrayList<TopicInfor> list = null;
		try {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", new String("wangxue"));
			list =bbs.queryAllPostInfor();
			if(list.size()>0){
				request.setAttribute("postInfor", list);
				request.getRequestDispatcher("/jsp/topic.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
