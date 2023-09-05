import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NameValidatorTest {
    @Test
    void name_Validate() {
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(()->new NameValidator("pobi,crong,honux"));
    }

    @Test
    void name_Validate_More_Member() {
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(()->new NameValidator("pobi,crong,honux,samsg,linux"));
    }

    @Test
    void name_Validate_Only_One_Car() {
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(()->new NameValidator("pobi"));
    }

    @Test
    void names_Including_Whitespace_Then_Error() {
        Assertions.assertThatThrownBy(() -> new NameValidator("po bi,samsu,Apple"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("공백이");
    }

    @Test
    void no_Delimiter_And_Over_Five_Letters_Error() {
        Assertions.assertThatThrownBy(() -> new NameValidator("pobiss"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("','없이 입력했습니다.");
    }

    @Test
    void FIVE_글자_넘으면_Error() {
        Assertions.assertThatThrownBy(() -> new NameValidator("pobi,SungHun,honux"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("5자를");
    }

    @Test
    void 중복된_이름_Error() {
        Assertions.assertThatThrownBy(() -> new NameValidator("pobi,pobi,honux"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("중복된");
    }




}
