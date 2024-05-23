package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    List<String> eatMeat = List.of("Животные", "Птицы", "Рыба");
    private Cat cat;

    @Mock
    Feline feline;

    @Before
    public void setupCat() {
        cat = new Cat(feline);
    }

    @Test
    public void shouldGetSoundWhenCat() {
        String resultSound = cat.getSound();
        assertEquals("Мяу", resultSound);
    }

    @Test
    public void shouldEatMeatWhenCat() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(eatMeat);
        List<String> actualResult = cat.getFood();
        List<String> expectedFood = eatMeat;
        assertEquals("Должно быть: Животные, Птицы, Рыба", expectedFood, actualResult);
    }
}