package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    private Feline feline;

    @Before
    public void setupFeline() {
        feline = new Feline();
    }

    @Test
    public void shouldBeFelionGetEatMeat() throws Exception {
        List<String> actualResult = feline.eatMeat();
        List<String> expectedFood = feline.getFood("Хищник");
        assertEquals(expectedFood, actualResult);
    }

    @Test
    public void houldgetFamilyFelion() {
        String result = feline.getFamily();
        assertEquals("Кошачьи", result);
    }

    @Test
    public void shouldgetKittenswhenFelion() {
        int actualResult = feline.getKittens();
        int expectedFood = 1;
        assertEquals("Должно быть котят: 1", expectedFood, actualResult);
    }

    @Test
    public void testGetKittens() {
        int result = feline.getKittens(10);
        assertEquals(10, result);
    }
}