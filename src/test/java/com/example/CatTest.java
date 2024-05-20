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
    List<String> Meat = List.of("Животные", "Птицы", "Рыба");
    private Cat cat;

    @Mock
    Feline feline;

    @Before
    public void setupCat() {
        cat = new Cat(feline);
    }

    @Test
    public void shouldGetSoundWhenCat() {
        String result = cat.getSound();
        assertEquals("Мяу", result);
    }

    @Test
    public void shouldEatMeatwhenCat() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(Meat);
        List<String> actualResult = cat.getFood();
        List<String> expectedFood = Meat;
        assertEquals("Должно быть: Животные, Птицы, Рыба", expectedFood, actualResult);
    }
}