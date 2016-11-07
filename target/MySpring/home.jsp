<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>home</h1>
<div>
    <table>
        <c:forEach items="${tableNameList}" var="tableName">
            <tr>
                <td>${tableName}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
