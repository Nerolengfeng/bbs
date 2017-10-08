package org.lanqiao.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.service.BBSService;

import model.BBSAuthorInfor;


@WebServlet("/AuthorInforServlet")
public class AuthorInforServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AuthorInforServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BBSService bbs = new BBSService();
		request.setCharacterEncoding("UTF-8");
		//使用枪支转码解决中文get方式乱码
		String author = request.getParameter("author");
		System.out.println(author);
		BBSAuthorInfor user = null;
		try {
			user = bbs.getUserInfor(author);
			request.setAttribute("authorInfo", user);
			request.getRequestDispatcher("/jsp/author.jsp").forward(request, response);
		} catch (SQLException e) {
			System.out.println("没锟叫查到锟斤拷锟斤拷没锟�"+e.getMessage());
			System.out.println("閮芥槸鍨冨溇");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}



