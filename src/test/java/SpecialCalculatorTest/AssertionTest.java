package SpecialCalculatorTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionTest {
    static class Person {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age && Objects.equals(name, person.name);
        }
    }

    @Test
    void assertEquals_Test() {
        // eqauls() 로 equal 한지 확인할 수 있음
        Person personA = new Person(24, "황성훈");
        Person personB = new Person(24, "황성훈");

        assertAll(
                () -> Assertions.assertEquals(personA, personB),
                () -> Assertions.assertSame(personA, personB));
    }
}
