<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>B-JUI 前端管理框架</title>
<meta name="Keywords" content="B-JUI,Bootstrap,jquery,ui,前端,框架,开源,OSC,开源框架,knaan"/>
<meta name="Description" content="B-JUI(Best jQuery UI)前端管理框架。轻松开发，专注您的业务，从B-JUI开始！"/> 

</head>
<body>
 <jsp:include flush="true" page="jsp/index/index.html"></jsp:include>
</body>
</html>
