<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    function showTableName() {
        window.location.href = "/data/listTableName";
    }
</script>
<html>
<style type="text/css">
    body {
        margin: 0;
        padding: 0;
    }

    body {
        font: 12px "微软雅黑";
    }

    a {
        text-decoration: none;
    }

    form, button {
        border: 0;
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
        <a href="/data/listTableName" onmouseover="showTableName()">查询所有数据表</a>
        <table border="2px">
            <c:forEach items="${tableNameList }" var="tableName">
                <tr>
                    <td style="width: 50px">${tableName }</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="main_right">
        <form action="/data/executeSql">
            <div class="main_top">
                <div class="top_left">
                    <input id="sqlTextarea" name="sql"></input>
                </div>
                <div class="top_right">
                    <input id="execute" type="submit" value="提交"/>
                </div>
            </div>
        </form>

        <div class="main_bottom">
            <c:if test="${not empty info}">${info}</c:if>
            <table border="2px">
                <c:forEach var="tableData" items="${tableDatas}" begin="0" end="0">
                    <tr>
                        <c:forEach var="dataItem" items="${tableData.data}">
                            <td style="width: 50px">${dataItem.key}</td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
            <table border="2px">
                <c:forEach var="tableData" items="${tableDatas}">
                    <tr style="width:auto;">
                        <c:forEach var="dataItem" items="${tableData.data}">
                            <td style="width: 50px">${dataItem.value}</td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>


</body>
</html>
