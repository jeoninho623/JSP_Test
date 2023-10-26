package models.member;

import org.mindrot.jbcrypt.BCrypt;

import java.util.HashMap;
import java.util.Map;

public class MemDao {
    // 데이터베이스 대용으로 사용되는 Map
    private static Map<String, Member> members = new HashMap<>();

    // 새 회원 등록
    public void register(Member member) {
        // 사용자 아이디와 비밀번호 유효성 검사
        if (isValidUsername(member.getUserId()) && isValidPassword(member.getUserPw())) {
            // 사용자 비밀번호를 안전하게 해싱하여 저장
            String userPw = BCrypt.hashpw(member.getUserPw(), BCrypt.gensalt(12));
            member.setUserPw(userPw); // 해싱된 비밀번호 설정
            members.put(member.getUserId(), member); // 회원을 데이터베이스에 추가
        } else {
            throw new IllegalArgumentException("아이디와 비밀번호의 형식을 확인하세요.");
        }
    }

    // 아이디 유효성 검사
    private boolean isValidUsername(String username) {
        return username.matches("^[A-Z][a-zA-Z0-9]{5,}$"); // 첫 글자 대문자, 6글자 이상
    }

    // 비밀번호 유효성 검사
    private boolean isValidPassword(String password) {
        return password.length() >= 8; // 8자리 이상
    }


    // 특정 사용자 아이디로 회원 정보 검색
    public Member get(String userId) {
        return members.get(userId);
    }

    // 아이디 중복 여부 확인
    public boolean exists(String userId) {
        return members.containsKey(userId);
    }

    // 데이터베이스 초기화 (테스트용 메서드)
    public static void clearData() {
        members = new HashMap<>(); // 데이터베이스 내용을 지움
    }
}
