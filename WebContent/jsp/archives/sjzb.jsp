<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<script type="text/javascript">
function do_open_layout(event, treeId, treeNode) {
    if (treeNode.isParent) {
        var zTree = $.fn.zTree.getZTreeObj(treeId)
        
        zTree.expandNode(treeNode)
        return
    }
    $(event.target).bjuiajax('doLoad', {url:treeNode.url, target:treeNode.target})
    
    event.preventDefault()
}
/*  "*/
function ztree_returnjson() {
			
	        return [{id:1,pid:0,name:'紫光软件',children:[{id:10,pid:1,name:'科技档案',url:'jsp/user/userdatagrid.jsp',target:'#layout01'},{id:11,pid:1,name:'文书档案',url:'jsp/user/userdatagrid.jsp',target:'#layout01'}]}]

	    }

</script>

</head>
<body>
<div class="bjui-pageContent">
    <div style="float:left; width:200px;">
        <ul id="layout-tree" 
        	class="ztree" 
        	data-toggle="ztree" 
        	data-expand-all="true"
            data-add-hover-dom="edit" 
            data-remove-hover-dom="edit" 
            data-options="{nodes:'ztree_returnjson'}" 
            data-edit-enable="true"
			data-before-drag="M_BeforeNodeDrag"
			data-before-drop="M_BeforeNodeDrop"
			data-on-drop="M_NodeDrop"
			data-on-click="do_open_layout"
            >
        </ul>
    </div>
    <div style=" height:99.9%; overflow:hidden;">
        <div style="margin-right:10px;height:100%; overflow:hidden;">
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