<%--
  Created by 蓝鸥科技有限公司  www.lanou3g.com.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>home</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <link href="../../css/demo.css" rel="stylesheet" type="text/css"/>
    <script src="../../scripts/boot.js" type="text/javascript"></script>


</head>
<body>

<h1>activiti演示</h1>

<div id="datagrid1" class="mini-datagrid" style="width:700px;height:280px;"
     url="/requestAllTask"
     multiSelect="false"
     idField="id"
     sizeList="[5,10,20,50]" pageSize="10">

    <div property="columns">
        <div field="taskName" width="120" headerAlign="center" align="center" allowSort="true">任务名称</div>
        <div field="assiginee" width="120" headerAlign="center" align="center" allowSort="true">办理人</div>
        <div field="createTime" width="100" allowSort="true" headerAlign="center" align="center">创建时间</div>
        <div name="action" width="120" headerAlign="center"
             align="center" renderer="onActionRenderer"
             cellStyle="padding:0;">#
        </div>
    </div>
</div>

<script type="text/javascript">
    mini.parse();

    var grid = mini.get("datagrid1");
    grid.load();

    /*搜索*/
    function search() {
        var key = document.getElementById("key").value;
        grid.load({key: key});
    }
    $("#key").bind("keydown", function (e) {
        if (e.keyCode == 13) {
            search();
        }
    });

    /*提交选中行到后台*/
    function onActionRenderer(e) {
        var grid = e.sender;
        var record = e.record;
        var uid = record._uid;
        var rowIndex = e.rowIndex;

        var s = '<a class="Edit_Button" href="javascript:submitRow(\'' + uid + '\')">办理任务</a> ';

        return s;
    }

    function submitRow() {
        var rows = grid.getSelecteds();
        var json = mini.encode(rows);
        $.ajax({
            url: "/submitData",
            data: {
                data: json
            },
            success: function (text) {
                grid.reload();
            }
        });
    }

</script>

</body>
</html>
