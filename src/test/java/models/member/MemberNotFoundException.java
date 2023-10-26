package models.member;

public class MemberNotFoundException extends RuntimeException{
    public MemberNotFoundException() {
        super("가입하지 않은 회원");
    }
}
