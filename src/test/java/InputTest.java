import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("이외의_문자_비정상")
    void extraOrdinary_input_Then_Wrong() {
        userInput = new String("1/4;");
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
                () -> new InputValidator(userInput));
    }




}
