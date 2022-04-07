/*
  1. Написать набор тестов для задачи №1 (по 3-4 варианта входных данных).
       Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
       Вх: [ 1 2 4 4 2 4 ] -> вых: [ ].
       Вх: [ 1 2 4 4 1 7 5 6 1 ] -> вых: [ 1 7 5 6 1 ].
       Вх: [ 1 2 1 7 444 44 14 ] -> вых: RuntimeException.

  2. Написать набор тестов для задачи №2 (по 3-4 варианта входных данных).
     [ 1 1 1 4 4 1 4 4 ] -> true
     [ 1 1 1 1 1 1 ] -> false
     [ 4 4 4 4 ] -> false
     [ 1 4 4 1 1 4 3 ] -> false
*/
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class JUnitArrayOpsTest {
    // данные для тестирования первой задачи
    static Stream<Arguments> task1_testingData() {
        return Stream.of(
                Arguments.arguments(new int[] { 1, 7 }, new int[] { 1, 2, 4, 4, 2, 3, 4, 1, 7 }),
                Arguments.arguments(new int[] { }, new int[] { 1, 2, 4, 4, 2, 4 }),
                Arguments.arguments(new int[] { 1, 7, 5, 6, 1 }, new int[] { 1, 2, 4, 4, 1, 7, 5, 6, 1 })
        );
    }

    // данные для тестирования второй задачи
    static Stream<Arguments> task2_testingData() {
        return Stream.of(
                Arguments.arguments(true, new int[] { 1, 1, 1, 4, 4, 1, 4, 4 }),
                Arguments.arguments(false, new int[] { 1, 1, 1, 1, 1, 1 }),
                Arguments.arguments(false, new int[] { 4, 4, 4, 4 }),
                Arguments.arguments(false, new int[] { 1, 4, 4, 1, 1, 4, 3 })
        );
    }

    @ParameterizedTest
    @MethodSource("task1_testingData")
    // тестирование значений, возвращаемых первой задачей
    void task1_testForValues(int[] expected, int[] arr) {
        Assertions.assertArrayEquals(expected, Main.getAfterLastNumber(arr, 4));
    }

    // тестирование выброса исключения первой задачей
    @Test void task1_testForException() {
        Assertions.assertThrows(
                RuntimeException.class,
                () -> Main.getAfterLastNumber(new int[] { 1, 2, 1, 7, 444, 44, 14 }, 4));
    }

    // для второй задачи: допустимые числа в массиве
    int[] task2_validValues = new int[] { 1, 4 };

    @ParameterizedTest
    @MethodSource("task2_testingData")
    // тестирование значений, возвращаемых второй задачей
    void task2_testForValues(boolean expected, int[] arr) {
        Assertions.assertEquals(expected, Main.containsValidNumbers(arr, task2_validValues));
    }
}