import java.util.Arrays;
import java.util.Optional;

public class NameValidator {
    private final String names;

    public NameValidator(String s) {
        this.names = s;
        validateName();
    }

    public void validateName() {
        isNullOrEmpty();
        hasNoComma();
        hasWhiteSpace();
        longerThanFive();
        duplicatedNames();
    }

    private void isNullOrEmpty() {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("아무것도 입력하지 않았습니다. 다시 입력해주세요");
        }
    }

    private void hasWhiteSpace() {
        if (names.contains(" ")) {
            throw new IllegalArgumentException("공백이 포함되어 있습니다. 다시 입력해주세요");
        }
    }

    private void hasNoComma() {
        if (!names.contains(",") && names.length() > 5) {
            throw new IllegalArgumentException("','없이 입력했습니다. 다시 입력해주세요");
        }
    }

    private void longerThanFive() {
        String[] splitNames = names.split(",");
        if( Arrays.stream(splitNames).anyMatch((name) -> name.length() > 5) ) {
            throw new IllegalArgumentException("5자를 초과한 이름이 존재합니다. 다시 입력해주세요");
        }
    }

    private void duplicatedNames() {
        String[] splitNames = names.split(",");
        if (splitNames.length != Arrays.stream(splitNames).distinct().count()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다. 다시 입력해주세요");
        }
    }
}
