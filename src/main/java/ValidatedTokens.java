import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ValidatedTokens {
    private final List<String> tokens;

    public ValidatedTokens(String validatedInput, String declaredDelimiter) {
        if (validatedInput.isEmpty()) {
            tokens = new ArrayList<>();
            return;
        }
        this.tokens = Arrays.stream(validatedInput.split(declaredDelimiter))
                .collect(Collectors.toList());
    }

    public List<Integer> getNumberTokens() {
        return new ArrayList<>(tokens).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public boolean hasNothing() {
        return tokens.isEmpty();
    }
}
