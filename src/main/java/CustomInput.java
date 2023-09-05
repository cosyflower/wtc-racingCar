import SpecialCalculator.CustomValidator;
import SpecialCalculator.ValidatedTokens;

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
