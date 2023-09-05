import Utils.Constants;
import Utils.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputString {
    private final String validatedInput;

    public InputString(String inputValue) {
        new InputValidator(inputValue);
        this.validatedInput = inputValue;
    }

    public ValidatedTokens splitToTokens() { // numberToken으로 리팩토링 해야 함
        return new ValidatedTokens(validatedInput, Constants.DECLARED_DELIMITER);
    }
}
