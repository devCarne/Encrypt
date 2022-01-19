package dao;

import dto.MemberDTO;
import service.MemberService;

import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {

    public Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            return DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "1234");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean signUp(MemberDTO member) {

        String sql = "INSERT INTO TBL_ENCRYPTED_MEMBER VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
            pstmt.setString(1, member.getID());
            pstmt.setString(2, member.getPW());
            pstmt.setString(3, member.getName());
            pstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<MemberDTO> getList() {

        ArrayList<MemberDTO> memberList = new ArrayList<>();

        String sql = "SELECT * FROM TBL_ENCRYPTED_MEMBER";
        try (Statement statement = getConnection().createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                MemberDTO member = new MemberDTO(
                        rs.getString("ID"),
                        rs.getString("PW"),
                        rs.getString("NAME"));
                memberList.add(member);
            }
            return memberList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public MemberDTO getMember(String ID) {
        String sql = "SELECT * FROM TBL_ENCRYPTED_MEMBER WHERE ID = '" + ID + "'";
        try (Statement stmt = getConnection().createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            rs.next();
            return new MemberDTO(
                    rs.getString("ID"),
                    rs.getString("PW"),
                    rs.getString("NAME")
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
