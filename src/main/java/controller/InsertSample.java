package controller;

import service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/insertSampleData.do")
public class InsertSample extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        MemberService service = new MemberService();
        service.encryptedSignUp("Hong", "abcd", "홍길동");
        service.encryptedSignUp("Lee", "1234", "이순신");
        service.encryptedSignUp("Tom", "PWD", "토마스");
        service.encryptedSignUp("June", "ab123", "준 롱");
        service.encryptedSignUp("Ann", "42kk", "안나");

        out.println("<script>alert('샘플데이터 입력에 성공했습니다.'); window.location.href='index.jsp'</script>");

    }
}
