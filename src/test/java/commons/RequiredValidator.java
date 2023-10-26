package commons;

// RequiredValidator 인터페이스 정의
public interface RequiredValidator {
    // 문자열이 필수 요소이며 비어 있거나 null인 경우 예외를 던지는 디폴트 메서드
    default void requiredCheck(String str, RuntimeException e) {
        // 문자열이 null이거나 공백 문자로만 이루어져 있으면 예외를 던집니다.
        if (str == null || str.isBlank()) {
            throw e;
        }
    }

    // Boolean 결과가 필수적으로 true여야 하며 그렇지 않을 경우 예외를 던지는 디폴트 메서드
    default void requiredTrue(Boolean result, RuntimeException e) {
        // 결과가 false인 경우에만 예외를 던집니다.
        if (!result) {
            throw e;
        }
    }
}
