import Utils.Constants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomValidatorTest {
    private CustomValidator customValidator;

    @Test
    @DisplayName("Custom_문자열_단독_숫자_정상")
    void ends_with_numbers_Then_Normal() {
        customValidator = new CustomValidator(new String("//:\n33"));
        Assertions.assertThatNoException();
    }

    @Test
    @DisplayName("Custom_문자열_커스텀_구분자_외_문자_포함_비정상")
    void other_Delimiter_Included_Then_Wrong() {
        Assertions.assertThatThrownBy(() -> customValidator = new CustomValidator(new String("//:\n1,33:")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("커스텀 구분자 외 다른 문자가 포함되어 있습니다.");
    }

    @Test
    @DisplayName("Custom_문자열_숫자가_없다면_비정상")
    void no_Numbers_Included_Then_Wrong() {
        Assertions.assertThatThrownBy(() -> customValidator = new CustomValidator(new String("//:\n")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("//로 시작하는");
    }

    @Test
    @DisplayName("Custom_문자열_음수_포함_비정상")
    void negative_Included_Then_Wrong() {
        Assertions.assertThatThrownBy(() -> customValidator = new CustomValidator(new String("//:\n1:33:-2")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("커스텀 구분자 외 다른 문자가 포함되어 있습니다.");
    }

    @Test
    @DisplayName("Custom_문자열_구분자로_마무리_비정상")
    void ends_With_Delimiter_Then_Wrong() {
        Assertions.assertThatThrownBy(() -> customValidator = new CustomValidator(new String("//:\n33:")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("수로 마무리되지 않았습니다.");
    }

    @Test
    @DisplayName("Custom_문자열_구분자_없다면_비정상")
    void no_Delimiter_Then_Wrong() {
        Assertions.assertThatThrownBy(() -> customValidator = new CustomValidator(new String("//\n33:")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("//로 시작하는");
    }


    @Test
    @DisplayName("Custom_문자열_정상")
    void matches_All_Rule_Then_Right() {
        customValidator = new CustomValidator(new String("//:\n331:2:30"));
        Assertions.assertThatNoException();
    }
}
