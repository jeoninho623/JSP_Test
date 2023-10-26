package commons;

// LengthValidator 인터페이스 정의
public interface LengthValidator {
    // 문자열의 길이를 검사하고 예외를 던지는 디폴트 메서드
    default void lengthCheck(String str, int min, int max, RuntimeException e) {
        // 만약 최소 길이(min)가 0보다 크고 문자열 길이가 최소 길이보다 작으면 예외를 던집니다.
        if (min > 0 && str.length() < min) {
            throw e;
        }

        // 만약 최대 길이(max)가 0보다 크고 문자열 길이가 최대 길이보다 크면 예외처리
        if (max > 0 && str.length() > max) {
            throw e;
        }
    }

    // 문자열의 최소 길이만 검사하고 예외를 던지는 디폴트 메서드
    default void lengthCheck(String str, int min, RuntimeException e) {
        // 문자열 길이가 최소 길이보다 작으면 예외를 던집니다.
        lengthCheck(str, min, 0, e);
    }
}
