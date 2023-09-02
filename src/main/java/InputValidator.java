import java.util.regex.Pattern;

public class InputValidator {
    private final String inputValue;

    public InputValidator(String input) {
        this.inputValue = input;
        validateInput(inputValue);
    }


    private void validateInput(String inputValue) {
        hasWrongInput(inputValue);
    }

    private void hasWrongInput(String s) {
        if (!Pattern.compile(Constants.NORMAL_INPUT_REGEX).matcher(s).matches()) {
            throw new IllegalArgumentException("잘못된 입력입니다. 숫자, 콤마(,), 콜론(:) 만 입력할 수 있습니다");
        }
    }
}
