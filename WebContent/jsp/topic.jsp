<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>《豆福传》</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="/lanqiao-bbs/static/css/bootstrap.min.css" rel="stylesheet">
	</head>

	<style type="text/css">
		li a {
			font-size: 20px;
			margin-top: 5px;
		}
		
		th {
			text-align: center;
		}
	</style>

	<body>
				<div class="col-lg-10">
					<div class="text-center" style="margin-right: 30px;">
					
						<h1> 
						<c:choose>
							<c:when test="loginUser">
								
								欢迎登陆
							</c:when>
							<c:otherwise>
								请登录
							</c:otherwise>
						</c:choose>
						
						
						</h1>
						<table class="table table-striped table-bordered table-hover" align="center" style="font-size: 18px; font-family: '微软雅黑';">
							<thead style="text-align: center">
								<tr class="tableHead">
									<th style="vertical-align:middle">编号</th>
									<th style="vertical-align:middle">标题</th>
									<th style="vertical-align:middle">发帖人</th>
									<th style="vertical-align:middle">时间</th>
									<th style="vertical-align:middle">头像</th>
									<th style="vertical-align:middle">详情</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${postInfor}" var="data">
								<tr>
										<td>${data['id']}</td>
										<td>${data['title']}</td>
										<td><a href="/lanqiao-bbs/AuthorInforServlet?author=${data['author']}">  ${data['author']}</a></td>
										<td>${data['createtime']}</td>
										<td>
											<img src="/lanqiao-bbs/static/img/${data['header']}" width="50" height="50"  class="img-circle" />
										</td>
										<td>
											<a href="/lanqiao-bbs/QueryReplyServlet?id=${data['id']}"   > 详情</a>
										</td>
									</tr>
								
								
								</c:forEach>
									
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="/lanqiao-bbs/static/js/jquery.min.js"></script>
	<script type="text/javascript" src="/lanqiao-bbs/static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/lanqiao-bbs/static/js/popover.js"></script>


</html>