<%@page import="model.BBSAuthorInfor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
						<h1>用户信息</h1>
						<table class="table table-striped table-bordered table-hover" align="center" style="font-size: 18px; font-family: '微软雅黑';">
							<thead style="text-align: center">
								<tr class="tableHead">
								</tr>
							</thead>
							<tbody>
							
						
							
							
								<tr>
									<th style="vertical-align:middle">用户姓名</th>
									<td>${requestScope.authorInfo.username }</td>
								</tr>

								<tr>
									<th style="vertical-align:middle">昵称</th>
									<td>${requestScope.authorInfo.nickname }</td>
								</tr>

								<tr>
									<th style="vertical-align:middle">密码</th>
									<td>${requestScope.authorInfo.password }</td>
								</tr>
								<tr>
								<th style="vertical-align:middle">身份证号</th>
								<td>${requestScope.authorInfo.idcard }</td>
								</tr>
								<tr>
									<th style="vertical-align:middle">性别</th>
									<td>${requestScope.authorInfo.sex }</td>
								</tr>
								<tr>
									<th style="vertical-align:middle">电话</th>
									<td>${requestScope.authorInfo.telephone }</td>
								</tr>
									<tr>
									<th style="vertical-align:middle">头像</th>
									<td><img src="/lanqiao-bbs/static/img/${requestScope.authorInfo.img }" width="50" height="50" class="img-circle" /></td>
								</tr>
								<tr>
									<th style="vertical-align:middle">上传头像</th>
									
									<td><input type="file"/></td>
								</tr>
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