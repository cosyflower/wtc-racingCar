import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void Car_Register_Test() {
        Car car = new Car("pobi,honux,samsu");
        int randomNumber = RandomGenerator.generateRandomNumber();
        Assertions.assertTrue(randomNumber < 10);
    }
}
