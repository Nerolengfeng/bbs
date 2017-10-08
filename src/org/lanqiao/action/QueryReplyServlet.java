package org.lanqiao.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.service.BBSService;

import model.RelyInfor;


@WebServlet("/QueryReplyServlet")
public class QueryReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public QueryReplyServlet() {
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		BBSService bbs = new BBSService();
		System.out.println(id);
		try {
			ArrayList<RelyInfor> list = bbs.queryAllRepliesInfor(id);
			if(list.size()>0){
				request.setAttribute("repliesInfor", list);
				request.setAttribute("repliesTitle", list.get(0));
				
				request.getRequestDispatcher("/jsp/role.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("连的人太多了"+e.getMessage());
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
