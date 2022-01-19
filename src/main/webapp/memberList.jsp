<%@ page import="service.MemberService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    MemberService service = new MemberService();
    pageContext.setAttribute("memberList", service.getList());
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<hr>
<h2>회원리스트</h2>
<table>
    <tr>
        <th>아이디</th><th>비밀번호(상세페이지에서 확인)</th><th>이름</th>
    </tr>
    <c:forEach var="m" items="${memberList}">
        <tr>
            <td><a href="memberInfo.jsp?ID=${m.ID}">${m.ID}</a></td><td>****</td><td>${m.name}</td>
        </tr>
    </c:forEach>
</table>
<hr>
<div>아이디 클릭시 상세정보 보기가 가능합니다.</div>
</body>
</html>
