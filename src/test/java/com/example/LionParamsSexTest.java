package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionParamsSexTest {

    boolean expectedResult;

    String sex;

    @Parameterized.Parameters(name = "{index} sex = {0}")
    public static Object[][] data() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    public LionParamsSexTest(String sex, boolean expectedResult) {
        this.sex = sex;
        this.expectedResult = expectedResult;
    }

    @Test
    public void shouldBeMaleWhenHaveMane() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals(expectedResult, lion.doesHaveMane());
    }
}