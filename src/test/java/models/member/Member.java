package models.member;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Member {
    private String userId;      // 아이디
    private String userPw;      // 비밀번호
    private String checkUserPw;       // 비밀번호 확인
    private String userNm;      // 이름
    private String userEm;      // 이메일
    private boolean agree;      // 약관 동의
}

