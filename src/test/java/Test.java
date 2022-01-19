import dao.MemberDAO;
import dto.MemberDTO;
import service.MemberService;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        MemberDAO dao = new MemberDAO();

        MemberDTO dto = new MemberDTO("Super", "abcd", "super");
        dao.signUp(dto);

        MemberService service = new MemberService();
        service.encryptedSignUp("Hong", "1234", "홍길동");

        ArrayList<MemberDTO> list = service.getList();
        for (MemberDTO m : list) {
            System.out.println(m.toString());
        }

        MemberDTO hong = service.getDecryptedMember("Hong");
        System.out.println(hong.getPW());

    }
}
