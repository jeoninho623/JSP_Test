package models.member;

import commons.Validator;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Objects;

// JoinService 클래스 정의
public class JoinService {
    private Validator validator; // 유효성 검사를 수행하는 Validator 객체
    private MemDao memberDao; // 회원 정보를 저장하고 관리하는 MemDao 객체

    // 생성자: Validator와 MemDao 객체를 초기화
    public JoinService(Validator validator, MemDao memberDao) {
        this.validator = validator;
        this.memberDao = memberDao;
    }

    // Member 객체를 받아서 회원 가입을 처리하는 메서드
    public void join(Member member) {
        // 받아온 Member 객체의 유효성을 검사
        validator.check(member);

        // 검사가 통과되면 회원 정보를 MemDao를 통해 등록
        memberDao.register(member);
    }

    // HttpServletRequest 객체를 받아서 회원 가입을 처리하는 메서드
    public void join(HttpServletRequest request) {
        // agree 파라미터 값을 가져와서 boolean 값으로 변환
        String _agree = Objects.requireNonNullElse(request.getParameter("agree"), "false");
        boolean agree = _agree.equals("true") ? true : false;

        // 사용자가 입력한 정보로 Member 객체를 생성
        Member member = Member.builder()
                .userId(request.getParameter("userId"))
                .userPw(request.getParameter("userPw"))
                .checkUserPw(request.getParameter("checkUserPw"))
                .userEm(request.getParameter("userEm"))
                .agree(agree)
                .build();

        // 생성된 Member 객체를 join(Member) 메서드로 전달하여 회원 가입 처리
        join(member);
    }
}
