package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionExceptionTest {
    private static final String EXTENTED_ERROR = "Используйте допустимые значения пола животного - самей или самка";

    String sex;

    @Parameterized.Parameters(name = "{index} sex = {0}")
    public static Object[][] data() {
        return new Object[][] {
                {"unknown"},
                {null},
                {"Альфа-Самка"},
                {"Бетта-Самка"}
        };
    }

    public LionExceptionTest(String sex) {
        this.sex = sex;
    }

    @Test
    public void shouldBeMaleWhenHaveMane() throws IndexOutOfBoundsException {
        IndexOutOfBoundsException indexOutOfBoundsException = assertThrows(IndexOutOfBoundsException.class,
                () -> new Lion(sex, null));
        Assert.assertEquals(EXTENTED_ERROR,
                indexOutOfBoundsException.getMessage());
    }
}