<%@ page import="service.MemberService" %>
<%@ page import="dto.MemberDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberService service = new MemberService();
    MemberDTO member = service.getDecryptedMember(request.getParameter("ID"));
    pageContext.setAttribute("member", member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>회원 상세정보</h2>
<table border="1">
    <tr>
        <th>아이디</th><th>비밀번호</th><th>이름</th>
    </tr>
    <tr>
        <td>${member.ID}</td><td>${member.PW}</td><td>${member.name}</td>
    </tr>
</table>
<a href="index.jsp">홈으로</a>
</body>
</html>
