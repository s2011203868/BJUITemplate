<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'import.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	<div class="bjui-pageContent">
		<div class="bs-example">
			<form action="UserServlet?method=upload" enctype="multipart/form-data"
				data-toggle="validate" data-close-current="true">
				<div class="bjui-row col-1">
					<label class="row-label">导入模板</label>
					<div class="row-input">
						<a href="UserServlet?method=downloadTemplate" data-toggle="ajaxdownload">导入模板文件下载</a>
					</div>
					<label class="row-label">上传导入文件</label>
					<div class="row-input">
						<input type="file" name="upfile"
							accept="application/vnd.ms-excel,.xlsx" data-rule="">
					</div>
					<label class="row-label">数据开始行号</label>
					<div class="row-input required">
						<input type="text" name="first" value="2" size="8"
							class="form-control" data-rule="required;digits">
					</div>
				</div>
			</form>
		</div>
		
	</div>
	<div class="bjui-pageFooter">
		<ul>
			<li><button type="button" class="btn-close" data-icon="close">取消</button></li>
			<li><button type="submit" class="btn-default" data-icon="save">导入</button></li>
		</ul>
	</div>
</body>
</html>
