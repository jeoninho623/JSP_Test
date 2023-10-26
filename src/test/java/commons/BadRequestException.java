package commons;

// BadRequestException 클래스 정의
public class BadRequestException extends RuntimeException {
    // BadRequestException 생성자: 문자열 메시지를 받아 예외 객체를 생성
    public BadRequestException(String message) {
        // 부모 클래스(RuntimeException)의 생성자를 호출하여 예외 메시지를 설정
        super(message);
    }
}

