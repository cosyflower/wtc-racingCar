import Utils.Constants;
import Utils.Util;

import java.util.regex.Pattern;

public class InputValidator {
    private final String inputValue;

    public InputValidator(String input) {
        this.inputValue = input;
        validateInput(inputValue);
    }


    private void validateInput(String inputValue) {
        isNull(inputValue);
        if (Util.hasOnlyNumbersOrEmpty(inputValue)) {
            return;
        }
        hasWrongInput(inputValue);

    }

    private void hasWrongInput(String s) {
        if (!Constants.NORMAL_INPUT_PATTERN.matcher(s).matches()) {
            throw new IllegalArgumentException("잘못된 입력입니다. 숫자, 콤마(,), 콜론(:) 만 입력할 수 있습니다");
        }
    }

    private void isNull(String s) {
        if (s == null) {
            throw new IllegalArgumentException("아무것도 입력하지 않았습니다. 다시 입력해주세요");
        }
    }
}
