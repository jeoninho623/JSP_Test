package models.member;

import commons.BadRequestException;
import commons.LengthValidator;
import commons.RequiredValidator;
import commons.Validator;

public class JoinVD extends DuplicateMemberException implements Validator<Member>, RequiredValidator, LengthValidator {
    private MemDao memberDao;

    public void setMemberDao(MemDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public void check(Member member) {
        String userId = member.getUserId();
        String userPw = member.getUserPw();
        String confirmUserPw = member.getCheckUserPw();

        requiredCheck(userId, new BadRequestException("아이디를 입력하세요."));
        requiredCheck(userPw, new BadRequestException("비밀번호를 입력하세요."));
        requiredCheck(confirmUserPw, new BadRequestException("비밀번호를 확인하세요."));
        requiredCheck(member.getUserNm(), new BadRequestException("회원명을 입력하세요."));
        requiredCheck(member.getUserEm(), new BadRequestException("이메일을 입력하세요."));
        requiredTrue(member.isAgree(), new BadRequestException("회원가입 약관에 동의하세요."));

        lengthCheck(userId, 6, new BadRequestException("아이디는 6자리 이상 입력하세요."));
        lengthCheck(userPw, 8, new BadRequestException("비밀번호는 8자리 이상 입력하세요."));


        System.out.printf("userPw=%s, confirmUserPw=%s%n",userPw, confirmUserPw);
        requiredTrue(userPw.equals(confirmUserPw), new BadRequestException("비밀번호가 일치하지 않습니다."));

        requiredTrue(!memberDao.exists(userId), new DuplicateMemberException());

    }
}
