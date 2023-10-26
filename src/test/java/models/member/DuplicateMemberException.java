package models.member;

// DuplicateMemberException 클래스 정의
public class DuplicateMemberException extends RuntimeException {
    // 생성자: "이미 가입된 회원"이라는 메시지를 포함하는 예외 객체를 생성
    public DuplicateMemberException() {
        super("이미 가입된 회원");
    }
}
