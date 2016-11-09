<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
    function executeSql() {
        var sql = document.getElementById("sqlTextarea").value;
        console.log(sql);
        if (sql.length == 0) {
            document.getElementById("info").innerHTML = "<h3>请输入sql语句</h3>";
            document.getElementById("fieldName").innerHTML = "";
            document.getElementById("mainbottom").innerHTML = "";
        } else {
            $.ajax({
                url: "/data/executeSql?sql=" + sql,
                type: "get",
                dataType: "json",
                contentType: "application/json",
                success: function (data) {
                    document.getElementById("info").innerHTML = "";
                    var mainbottom = document.getElementById("mainbottom");
                    var html = "";
                    var fieldName = document.getElementById("fieldName");
                    var fieldHtml = "";
                    for (var i = 0; i <= 0; i++) {
                        fieldHtml = fieldHtml + "<tr>";
                        for (innerItem in data[i]) {
                            for (key in data[i][innerItem]) {
                                fieldHtml = fieldHtml + "<td>" + key + "</td>"
                            }

                        }
                        html = html + "</tr>";
                    }
                    fieldName.innerHTML = fieldHtml;

                    for (dataItem in data) {
                        console.log(data[dataItem]);
                        html = html + "<tr>";
                        for (innerItem in data[dataItem]) {
                            console.log(data[dataItem][innerItem]);

                            for (key in data[dataItem][innerItem]) {
                                console.log(key + ":" + data[dataItem][innerItem][key]);
                                html = html + "<td>" + data[dataItem][innerItem][key] + "</td>"
                            }

                        }
                        html = html + "</tr>";
                    }
                    mainbottom.innerHTML = html;
                }

            })
        }
    }

    function showTableName() {
        $.ajax({
            url: "/data/listTableName",
            type: "get",
            dataType: "json",
            contentType: "application/json",
            success: function (data) {
                var mainleft = document.getElementById("mainleft");
                mainleft.innerHTML = "";
                for (tableName in data) {
                    var html = document.getElementById("mainleft").innerHTML;
                    mainleft.innerHTML = html + "<tr><td>" + data[tableName] + "</td></tr>";
                }
            }

        })
    }

</script>
<html>
<style type="text/css">
    body {
        margin: 0;
        padding: 0;
    }

    td {
        width: 50px;
    }

    body {
        font: 12px "微软雅黑";
    }

    #main {
        width: 100%;
        height: 8 ·00px;
    }

    .main_left {
        width: 300px;
        height: 100%;
        background: #ccc;
        float: left;
    }

    .main_right {
        overflow: hidden;
        height: 100%;
        background: #eee;
    }

    .main_top {
        width: 100%;
        height: 50%;
        background: #f66;
    }

    .top_left {
        width: 70%;
        height: 100%;
        background: wheat;
        float: left;
    }

    .top_right {
        width: 30%;
        height: 100%;
        background: #000;
        float: left;
    }

    #sqlTextarea, #execute {
        width: 100%;
        height: 100%;
    }

</style>
<body>
<div id="main">
    <div class="main_left">
        <input type="button" value="查询所有数据表" onclick="showTableName()">
        <table id="mainleft" border="2px">
        </table>
    </div>
    <div class="main_right">
        <div class="main_top">
            <div class="top_left">
                <input id="sqlTextarea" type="text" name="sql"></input>
            </div>
            <div class="top_right">
                <input id="execute" type="button" value="提交" onclick="executeSql()"/>
            </div>
        </div>

        <div class="main_bottom">
            <div id="info">
            </div>

            <table border="2px" id="fieldName">
            </table>

            <table border="2px" id="mainbottom">
            </table>
        </div>
    </div>
</div>


</body>
</html>
