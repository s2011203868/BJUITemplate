<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userdatagrid.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">

$('#j_datagrid').datagrid({
    height: '100%',
    //gridTitle : 'datagrid 完整示例 - JS API',
    showToolbar: true,
    //toolbarItem: 'all',
    local: 'remote',
    columnLock:false,
    delPK:'id',
    dataUrl: 'UserServlet?method=getUserList',
    columns: [
    	{
            name: 'id',
            label: '编号',
            align: 'center',
            width: 70,
            hide:true
        },
        {
            name: 'username',
            label: '姓名',
            align: 'center',
            width: 70,
            
        },
        {
           name: 'age',
           label: '年龄',
           align: 'center',
           width: 50 
        },
        {
           name: 'sex',
           label: '性别',
           align: 'center',
           width: 40,
           render: function(value) {
               return String(value) == '1' ? '男' : '女'
           }
        },
        {
           name:'birthday',
           label:'生日',
           align:'center',
           type: 'date',
           pattern: 'yyyy-MM-dd',
           
        },
        {
            name: 'city',
            label: '城市',
            align: 'center',
            render: function(value) {
	            if(value==1){
	            	return '北京市'
	              }
	            if(value==2){
	          		return '上海市'
	            }
                if(value==3){
	          		return '杭州市'
	            }
	            if(value==4){
	          		return '广州市'
	            }
           }
        },
        {
            name: 'salary',
            label: '薪水',
            align: 'center',
        },
        {
            name: 'starttime',
            label: '入职时间',
            align: 'center',
            type: 'date',
            pattern: 'yyyy-MM-dd'
        },
        {
            name: 'endtime',
            label: '离职时间',
            align: 'center',
            type: 'date',
            pattern: 'yyyy-MM-dd'
        },
        {
            name: 'description',
            label: '个人描述',
            align: 'center',
        }
    ],
    editUrl: 'UserServlet?method=save',
    delUrl:'UserServlet?method=del',
    paging:{pageSize:10,selectPageSize:'20,30', showPagenum:5},
    linenumberAll: true,
    tableWidth:'100%',
    contextMenuB:true,
    noremove: false,
    showCheckboxcol:true,
    toolbarItem:'add,edit,cancel,save,|,del,|,refresh,|,import, export',
    importOption:{type:"dialog", options:{url:'jsp/user/import.jsp', width:500, height:300,title:'导入数据'}},
    exportOption: {type:'file', options:{url:'UserServlet?method=export', loadingmask:true}},
    afterDelete:function(){
    	$('#j_datagrid').datagrid('refresh',true);
    },
    afterSave:function(){
    	$('#j_datagrid').datagrid('refresh',true);
    }
});
</script>
  </head>
  
  <body>
     <div class="bjui-pageContent">
    	<table id="j_datagrid" class="table table-bordered">
	    </table>
	  </div>
  </body>
</html>
