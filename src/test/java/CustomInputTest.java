import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class CustomInputTest {

    @Test
    @DisplayName("//:\n155:2:3")
    void 구성된_수_확인() {
        CustomInput customInput = new CustomInput("//:\n155:2:3");
        ValidatedTokens numberTokens = customInput.splitToTokens();
        Assertions.assertThat(numberTokens.getNumberTokens()).containsExactly(155, 2, 3);
    }

    @Test
    @DisplayName("//:\n1:2:3")
    void 구성된_수_확인_2() {
        CustomInput customInput = new CustomInput("//:\n1:2:3");
        ValidatedTokens numberTokens = customInput.splitToTokens();
        Assertions.assertThat(numberTokens.getNumberTokens()).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("//,\n155,2,3")
    void 구성된_수_확인_3() {
        CustomInput customInput = new CustomInput("//,\n155,2,3");
        ValidatedTokens numberTokens = customInput.splitToTokens();
        Assertions.assertThat(numberTokens.getNumberTokens()).containsExactly(155, 2, 3);
    }

    @Test
    @DisplayName("//,\n1,2,3")
    void 구성된_수_확인_4() {
        CustomInput customInput = new CustomInput("//,\n1,2,3");
        ValidatedTokens numberTokens = customInput.splitToTokens();
        Assertions.assertThat(numberTokens.getNumberTokens()).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("//,\n1")
    void 구성된_수_확인_5() {
        CustomInput customInput = new CustomInput("//,\n1");
        ValidatedTokens numberTokens = customInput.splitToTokens();
        Assertions.assertThat(numberTokens.getNumberTokens()).containsExactly(1);
    }




}
