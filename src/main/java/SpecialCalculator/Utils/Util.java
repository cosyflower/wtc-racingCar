package SpecialCalculator.Utils;

public class Util {
    public static boolean hasOnlyNumbersOrEmpty(String inputValue) {
        return Constants.ONLY_NUMBER_PATTERN.matcher(inputValue).matches()
                || inputValue.isEmpty();
    }
}
