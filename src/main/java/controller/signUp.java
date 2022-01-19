package controller;
import service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/signUp.do")
public class signUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        MemberService service = new MemberService();
        boolean result = service.encryptedSignUp(
                req.getParameter("ID"),
                req.getParameter("PW"),
                req.getParameter("name"));

        if (result) {
            out.println("<script>alert('회원가입에 성공했습니다.'); window.location.href='index.jsp'</script>");
        } else {
            out.println("<script>alert('회원가입에 실패했습니다. 아이디가 중복되었습니다.'); window.location.href='index.jsp'</script>");
        }
    }
}
