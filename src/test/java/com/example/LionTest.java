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
public class LionTest {
    private Lion lion;
    List<String> Meat = List.of("Животные", "Птицы", "Рыба");

    @Mock
    Feline feline;

    @Before
    public void setupLion() {
        lion = new Lion(feline);
    }

    @Test
    public void shoulgetKittenswhenLion() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualResult = lion.getKittens();
        int expectedFood = 1;
        assertEquals("Должно быть котят: 1", expectedFood, actualResult);

    }

    @Test
    public void shouldBeLionGetFoodMeat() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(Meat);
        List<String> actualResult = lion.getFood();
        List<String> expectedFood = Meat;
        assertEquals("Должно быть: Животные, Птицы, Рыба", expectedFood, actualResult);
    }
}