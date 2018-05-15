<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="js/zTree_v3/css/metroStyle/metroStyle.css" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
 function do_open_tree(treeId, treeNode, clickFlag) {
	
   if (treeNode.isParent) {
        var zTree = $.fn.zTree.getZTreeObj(treeId)
        
        zTree.expandNode(treeNode)
        return
    } ;
   
   $(this).bjuiajax('doLoad', {
	   url:treeNode.uri,
	   target:treeNode.target,
	   });
}; 

   var setting = {    
           data: {    
               simpleData: {    
                   enable: true  
               }    
           }    
           ,async: {    
               enable: true,    
               url:"SjzbServlet?method=getTree",    
               autoParam:["id", "name", "level=level"],    
               otherParam:{"otherParam":"zTreeAsyncTest"},    
               dataFilter: filter  //异步返回后经过Filter  
           },
         //页面上的显示效果  
           view: {  
               addHoverDom: addHoverDom, //当鼠标移动到节点上时，显示用户自定义控件  
               removeHoverDom: removeHoverDom //离开节点时的操作  
               
           },  
           edit: {  
               enable: true, //单独设置为true时，可加载修改、删除图标  
               editNameSelectAll: true,  
               showRemoveBtn: showRemoveBtn,
			   showRenameBtn: showRenameBtn,
			   
           }, 
            callback:{     
               asyncSuccess: zTreeOnAsyncSuccess,//异步加载成功的fun    
               asyncError: zTreeOnAsyncError,   //加载错误的fun    
               beforeClick: do_open_tree ,	//点击node的fun
               onRemove: onRemove, //移除事件  
               onRename: onRename, //修改事件  
               beforeRename: beforeRename, //修改确认事件
               beforeRemove: beforeRemove, //删除确认事件
           }  
       };    
         
   
   function addHoverDom(treeId, treeNode) {  
	    var sObj = $("#" + treeNode.tId + "_span"); //获取节点信息  
	    if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;  
	  
	    var addStr = "<span class='button add' id='addBtn_" + treeNode.tId + "' title='add node' onfocus='this.blur();'></span>"; //定义添加按钮  
	    sObj.after(addStr); //加载添加按钮  
	    var btn = $("#addBtn_"+treeNode.tId);  
	  
	    //绑定添加事件，并定义添加操作  
	    if (btn) btn.bind("click", function(){  
	        var zTree = $.fn.zTree.getZTreeObj("sjzbtree");  
	        //将新节点添加到数据库中  
	        var name='NewNode';
	        var formdata;
	        
	        BJUI.dialog({
	            id:'formdata',
	            url:'jsp/archives/node.jsp',
	            /* html:'<div style="margin:15px auto; padding:15px; width:98%;height:98%; border:1px #ff6600 solid;"></div>', */
	            title:'选择隐藏列',
	            width:600,
	            height:350,
	            onLoad:function(){
	            	
	            	$('.btn-default').click(function(){
	            		formdata = $('.datagrid-edit-form').serialize();//获取form表单值
	            		BJUI.dialog('closeCurrent');//关闭当前dialog
	            		
            		 $.post('SjzbServlet?method=addtree&'+formdata+'&pid='+treeNode.id+'&name='+name,function (data) {  
         	            var newID = data; //获取新添加的节点Id  
         	            zTree.addNodes(treeNode, {id:newID, pId:treeNode.id, name:name}); //页面上添加节点  
         	            var node = zTree.getNodeByParam("id", newID, null); //根据新的id找到新添加的节点  
         	            treeNode.isParent = true;//把属性变成true，让这个节点被认为是父节点  
         	            zTree.reAsyncChildNodes(treeNode, "refresh", false); 
         	            zTree.selectNode(node); //让新添加的节点处于选中状态  
         	        }); 
        		  });
	            } 
	        });
	    });  
	};
	
    function removeHoverDom(treeId, treeNode) {  
        $("#addBtn_"+treeNode.tId).unbind().remove();  
    };  
	
    
    function onRename(e, treeId, treeNode, isCancel) {  
        //需要对名字做判定的，可以来这里写~~  
        $.post('SjzbServlet?method=modifyname&id='+treeNode.id+'&name='+treeNode.name);  
    };
    
    function beforeRename(treeId, treeNode, newName, isCancel) {  
        if (newName.length == 0) {  
        	BJUI.alertmsg('info', '节点名称不可为空！',{})
        	
            return false;  
        }  
        return true;  
    }  ;
    
    function onRemove(e, treeId, treeNode) {  
        //需要对删除做判定或者其它操作，在这里写~~  
        $.post('SjzbServlet?method=delTree&id='+treeNode.id);  
    };
    
    
    function beforeRemove(treeId, treeNode) {  
        var zTree = $.fn.zTree.getZTreeObj("sjzbtree");  
        zTree.selectNode(treeNode);  
        return  confirm("确认删除 节点 -- " + treeNode.name + " 吗？"); 
        
    }; 
    
    function showRemoveBtn(treeId, treeNode) {
		
		
		if(treeNode.noEditBtn != undefined && treeNode.noEditBtn){
			return false;
		}else{
			return true;
		}
		
	};
	function showRenameBtn(treeId, treeNode) {
		
		if(treeNode.noRemoveBtn != undefined && treeNode.noRemoveBtn){
			return false;
		}else{
			return true;
		}
	};
    
       function filter(treeId, parentNode, childNodes) {    
           if (!childNodes) return null;    
           for (var i=0, l=childNodes.length; i<l; i++) {    
               childNodes[i].name = childNodes[i].name.replace('','');    
           }    
           return childNodes;    
       };    

       function zTreeOnAsyncError(event, treeId, treeNode){    
           alert("异步加载失败!");    
       } ;   
         
       function zTreeOnAsyncSuccess(event, treeId, treeNode, msg){    
             
       } ; 
       
       var zNodes=[];  
       $(document).ready(function(){    
           $.fn.zTree.init($("#sjzbtree"), setting, zNodes);    
       }); 
</script>

</head>
<body>
<div class="bjui-pageContent">
    <div style="float:left; width:200px;">
        <ul id="sjzbtree" class="ztree"  ></ul>
    </div>
    <div style=" height:99.9%; overflow:hidden;">
        <div style="margin-right:20px;height:100%; overflow:hidden;">
            <fieldset style="height:100%;">
                <legend>收集整编</legend>
                <div id="layout01" style="height:94%; overflow:hidden;">
                    
                </div>
            </fieldset>
        </div>
    </div>
</div>
</body>
</html>