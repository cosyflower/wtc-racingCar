import SpecialCalculator.InputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.StringTokenizer;

public class InputTest {
    private String userInput;

    @Test
    @DisplayName("수_콜론_포함하면_정상")
    void match_Number_And_Colon_Then_Normal() {
        userInput = new String("1:2:3");
        InputValidator inputValidator = new InputValidator(userInput);
        Assertions.assertThatNoException();
    }

    @Test
    @DisplayName("수_쉼표_포함하면_정상")
    void match_Number_And_Comma_Then_Normal() {
        userInput = new String("1,2,3");
        InputValidator inputValidator = new InputValidator(userInput);
        Assertions.assertThatNoException();
    }

    @Test
    @DisplayName("수_콜론_포함하면_정상")
    void match_Number_Colon_Comma_Then_Normal() {
        userInput = new String("1:2,3");
        InputValidator inputValidator = new InputValidator(userInput);
        Assertions.assertThatNoException();
    }

    @Test
    @DisplayName("빈_문자열_정상")
    void emtpy_String_Then_Normal() {
        userInput = new String("");
        InputValidator inputValidator = new InputValidator(userInput);
        Assertions.assertThatNoException();
    }

    @Test
    @DisplayName("이외의_문자_비정상")
    void extraOrdinary_input_Then_Wrong() {
        userInput = new String("1/4;");
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
                () -> new InputValidator(userInput));
    }

    @Test
    @DisplayName("공백_포함_비정상")
    void whiteSpace_included_Then_Wrong() {
        userInput = new String(" 1/4;");
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
                () -> new InputValidator(userInput));
    }

    @Test
    @DisplayName("null_입력_비정상")
    void null_input_Then_Wrong() {
        userInput = null;
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
                () -> new InputValidator(userInput));
    }

    @Test
    @DisplayName("음수_입력_비정상")
    void negative_input_Then_Wrong() {
        userInput = new String("-1:3,4");
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
                () -> new InputValidator(userInput));
    }

    @Test
    @DisplayName("Delimiter_복수")
    void 여러_Delimiter_Test() {
        StringTokenizer stringTokenizer = new StringTokenizer("1,2:3", ",|\\:");
        while (stringTokenizer.hasMoreTokens()) {
            System.out.println("stringTokenizer.nextToken() = " + stringTokenizer.nextToken());
        }

    }







}
