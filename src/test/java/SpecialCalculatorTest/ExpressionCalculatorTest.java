package SpecialCalculatorTest;

import SpecialCalculator.CustomInput;
import SpecialCalculator.ExpressionCalculator;
import SpecialCalculator.InputString;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExpressionCalculatorTest {
    @Test
    @DisplayName("empty면_0")
    void is_Empty_Then_0() {
        InputString userInput = new InputString(new String(""));
        ExpressionCalculator expressionCalculator = new ExpressionCalculator();
        int result = expressionCalculator.calculate(userInput.splitToTokens());
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자로만_구성되면_바로_변환한_결과_출력")
    void no_Delimiter_Then_Parsing() {
        InputString userInput = new InputString(new String("123"));
        ExpressionCalculator expressionCalculator = new ExpressionCalculator();
        int result = expressionCalculator.calculate(userInput.splitToTokens());
        Assertions.assertThat(result).isEqualTo(123);
    }

    @Test
    @DisplayName("콤마로만_구성된_식")
    void only_Commas_Then_Calculate() {
        InputString userInput = new InputString(new String("1,2,3"));
        ExpressionCalculator expressionCalculator = new ExpressionCalculator();
        int result = expressionCalculator.calculate(userInput.splitToTokens());
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("콜론으로만_구성된_식")
    void only_Colons_Then_Calculate() {
        InputString userInput = new InputString(new String("1:2:3"));
        ExpressionCalculator expressionCalculator = new ExpressionCalculator();
        int result = expressionCalculator.calculate(userInput.splitToTokens());
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("콜론으로만_구성된_식")
    void commas_Colons_Then_Calculate() {
        InputString userInput = new InputString(new String("1:23"));
        ExpressionCalculator expressionCalculator = new ExpressionCalculator();
        int result = expressionCalculator.calculate(userInput.splitToTokens());
        Assertions.assertThat(result).isEqualTo(24);
    }

    @Test
    @DisplayName("custom_Input_숫자_하나")
    void custom_Input_One_Number() {
        CustomInput userInput = new CustomInput(new String("//:\n1"));
        ExpressionCalculator expressionCalculator = new ExpressionCalculator();
        int result = expressionCalculator.calculate(userInput.splitToTokens());
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("custom_Input_숫자_복수")
    void custom_Input_Many_Numbers() {
        CustomInput userInput = new CustomInput(new String("//:\n1:2:3"));
        ExpressionCalculator expressionCalculator = new ExpressionCalculator();
        int result = expressionCalculator.calculate(userInput.splitToTokens());
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("custom_Input_잘못된_Delimiter")
    void custom_Input_Different_Delimiter() {
        Assertions.assertThatThrownBy(() -> new CustomInput(new String("//:\n1:2,3")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("커스텀 구분자 외");
    }


}
