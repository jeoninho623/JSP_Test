package models.member;

public class ServiceManager {

    private static ServiceManager instance;

    private ServiceManager() {}

    public static ServiceManager getInstance() {
        if (instance == null) {
            instance = new ServiceManager();
        }

        return instance;
    }

    public MemDao memberDao() {
        return new MemDao();
    }

    public JoinVD joinValidator() {
        JoinVD validator = new JoinVD();
        validator.setMemberDao(memberDao());

        return validator;
    }

    public JoinService joinService() {
        return new JoinService(joinValidator(), memberDao());
    }

    public LoginValidator loginValidator() {
        return new LoginValidator(memberDao());
    }

    public LoginService longinService() {
        return new LoginService(loginValidator(), memberDao());
    }
}