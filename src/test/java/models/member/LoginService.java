package models.member;

import commons.Validator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginService {

    private Validator<HttpServletRequest> validator;

    private MemDao memDao;

    public LoginService(Validator<HttpServletRequest> validator, MemDao memDao) {
        this.validator = validator;
        this.memDao = memDao;
    }

    public void login(HttpServletRequest request) {

        validator.check(request);

        // 로그인 처리
        String userId = request.getParameter("userId");
        Member member = memDao.get(userId);
        HttpSession session = request.getSession();
        session.setAttribute("member",member);
    }
}