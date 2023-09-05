import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomInput {
    private final String validatedCustomInput;

    public CustomInput(String input) {
        new CustomValidator(input);
        this.validatedCustomInput = input;
    }

    public ValidatedTokens splitToTokens() {
        return new ValidatedTokens(validatedCustomInput.substring(4, validatedCustomInput.length()),
                String.valueOf(validatedCustomInput.charAt(2)));
    }

}
