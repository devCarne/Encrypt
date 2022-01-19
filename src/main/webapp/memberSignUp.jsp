<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <table border="1">
        <tr>
            <th colspan="2">회원가입</th><th rowspan="4"><input type="submit" onclick="return nullCheck()" value="가입하기" formaction="signUp.do"></th>
        </tr>
        <tr>
            <td>아이디</td><td><input type="text" name="ID" id="ID"></td>
        </tr>
        <tr>
            <td>비밀번호</td><td><input type="password" name="PW" id="PW"></td>
        </tr>
        <tr>
            <td>이름</td><td><input type="text" name="name" id="name"></td>
        </tr>
    </table>
</form>
</body>
<script>
    function nullCheck() {
        if (document.getElementById("ID") === null) {
            alert("아이디를 입력해주세요.")
            document.getElementById("ID").focus();
            return false;
        } else if (document.getElementById("PW") === null) {
            alert("비밀번호를 입력해주세요.")
            document.getElementById("PW").focus();
            return false;
        } else if (document.getElementById("name") === null) {
            alert("비밀번호를 입력해주세요.")
            document.getElementById("name").focus();
            return false;
        }
    }
</script>
</html>
