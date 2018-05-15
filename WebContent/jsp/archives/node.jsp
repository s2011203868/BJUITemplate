<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="bjui-pageContent">
    <div class="bs-example">
        <form class="datagrid-edit-form" data-toggle="validate" data-data-type="jsonp">
            <div class="bjui-row col-2">
                <label class="row-label">姓名</label>
                <div class="row-input ">
                    <input name="username" id="username" value="username" data-toggle="icheck"  type="checkbox">
                </div>
                <label class="row-label">性别</label>
                <div class="row-input">
                    <input name="sex" id="sex" value="sex" data-toggle="icheck"  type="checkbox">
                </div>
                <label class="row-label">年龄</label>
                <div class="row-input ">
                   <input name="age" id=age value="age" data-toggle="icheck" type="checkbox">
                </div>
                <label class="row-label">生日</label>
                <div class="row-input">
                    <input name="birthday" id="birthday" value="birthday" data-toggle="icheck"  type="checkbox">
                </div>
                <label class="row-label">城市</label>
                <div class="row-input ">
                   <input name="city" id="city" value="city" data-toggle="icheck" type="checkbox">
                </div>
                <label class="row-label">薪水</label>
                <div class="row-input ">
                    <input name="salary" id="salary" value="salary" data-toggle="icheck" type="checkbox">
                </div>
                <label class="row-label">离职时间</label>
                <div class="row-input ">
                     <input name="endtime" id="endtime" value="endtime" data-toggle="icheck"  type="checkbox">
                </div>
                <label class="row-label">入职时间</label>
                <div class="row-input ">
                     <input name="starttime" id="starttime" value="starttime" data-toggle="icheck"  type="checkbox">
                </div>
                <label class="row-label">个人描述</label>
                <div class="row-input">
                     <input name="description" id="description" value="description" data-toggle="icheck"  type="checkbox">
                </div>
            </div>
        </form>
    </div>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">取消</button></li>
        <li><button type="submit" class="btn-default" data-icon="save">保存</button></li>
    </ul>
</div>
</body>
</html>