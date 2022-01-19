package service;

import dao.MemberDAO;
import dto.MemberDTO;

import java.util.ArrayList;

public class MemberService {

    MemberDAO dao = new MemberDAO();

    public boolean encryptedSignUp(String ID, String PW, String name) {

        String encryptedPW = encryption(PW, 3);
        MemberDTO member = new MemberDTO(ID, encryptedPW, name);

        return dao.signUp(member);
    }

    public ArrayList<MemberDTO> getList() {
        return dao.getList();
    }

    public MemberDTO getDecryptedMember(String ID) {
        MemberDTO member = dao.getMember(ID);
        member.setPW(decryption(member.getPW(), 3));
        return member;
    }

    public static String encryption(String message, int key) {
        char[] charMessage = message.toCharArray();
        for(int i = 0; i < message.length(); i++) {
            charMessage[i] += key;
        }
        return String.valueOf(charMessage);
    }

    public static String decryption(String message, int key) {
        char[] charMessage = message.toCharArray();
        for(int i = 0; i < message.length(); i++) {
            charMessage[i] -= key;
        }

        return String.valueOf(charMessage);
    }
}
