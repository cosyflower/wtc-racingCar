package SpecialCalculator;

import SpecialCalculator.Utils.Constants;

import java.util.stream.Collectors;

public class CustomValidator {
    private final String customInput;

    public CustomValidator(String inputValue) {
        this.customInput = inputValue;
        validateCustomInput(inputValue.charAt(Constants.CUSTOM_DELIMITER_INDEX));
    }

    private void validateCustomInput(char customDelimiter) {
        hasDelimiter(); // 커스텀 구분자가 제대로 명시되지 않은 상황
        hasCorrectInput(customDelimiter); // custom구분자 그리고 수만 존재하는 상황
        isDelimiterLast(customDelimiter); // hasCorrect 내부에 모두 포함되어 있기는 하다

    }

    private void hasDelimiter() {
        if (!Constants.CUSTOM_INPUT_PATTERN.matcher(customInput).matches()) {
            throw new IllegalArgumentException(Constants.ERROR_STARTED_WITH_SLASH);
        }
    }

    private void hasCorrectInput(char customDelimiter) {
        // 커스텀 구분자가 제대로 포함되어 있는지 확인합니다
        // 구분자가 아닌 애들을 추출합니다
        // 모두 수로 구성되어 있는지 확인합니다 (= 특정 구분자 그리고 수로만 이뤄져있다)
//        System.out.println("customDelimiter = " + customDelimiter);
        String filteredChars = customInput.substring(4,customInput.length())
                .chars()
                .mapToObj(c -> (char) c)
                .filter((word) -> word != customDelimiter)
                .map(Object::toString)
                .collect(Collectors.joining());

        if (!Constants.ONLY_NUMBER_PATTERN.matcher(filteredChars).matches()) {
            throw new IllegalArgumentException("커스텀 구분자 외 다른 문자가 포함되어 있습니다. 규칙에 맞게 입력해주세요");
        }
    }

    private void isDelimiterLast(char customDelimiter) {
        if (customDelimiter == customInput.charAt(customInput.length() - 1)) {
            throw new IllegalArgumentException("수로 마무리되지 않았습니다. 규칙에 맞게 입력해주세요");
        }
    }
}
