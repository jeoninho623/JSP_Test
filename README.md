# JSP 테스트



### TDD를 통한 구현

---------------------------------------------

- 프로젝트 설정
1. junit5
2. mockito
3. maven-sure-fire plugin
4. servlet-api
5. servlet.jsp-api
6. jstl api
7. jstl implementation
8. lombok

---------------------------------------------

- 톰캣 10 서버 설정

  -smart tomcat


- 회원가입 기능 구현

   - models/member/JoinService.java
   - 필수항목 정의 (userID, userPw, checkUserPw, userNm, userEm, agree)
   - 아이디, 비밀번호 자릿수 체크 (ID : 첫 글자 영어, PW : 8자리 이상) - 정규식
   - 비밀번호, 비밀번호 확인 데이터 일치 확인
   - 아이디 중복체크 - 중복 시 가입불가
   - 회원정보 저장 (Session)
    

- 로그인 기능 구현

  - models/member/LoginService.java
  - 필수 항목 (ID, Password)
  - 아이디에 해당하는 회원 정보가 있는지 체크
  - 로그인처리(세션에 정보 저장)


   



