package SpecialCalculator;

public class ExpressionCalculator {
    public int calculate(ValidatedTokens validatedCustomTokens) {
        if (validatedCustomTokens.hasNothing()) {
            return 0;
        }
        return validatedCustomTokens.getNumberTokens()
                .stream().reduce(0, (numA, numB) -> numA + numB);
    }
}
