package com.healthycoderapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {

    /**
     * bad: assertTrue(BMICalculator.isDietRecommended(89.0, 1.72));
     */
    @Test
    void should_ReturnTrue_When_DietRecommended() {
        // given
        double weight = 89.0;
        double height = 1.72;

        // when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);

        // then
        assertTrue(recommended);
    }

    @Test
    void should_ReturnFalse_When_DietNotRecommended() {
        // given
        double weight = 89.0;
        double height = 1.95;

        // when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);

        // then
        assertFalse(recommended);
    }

    @Test
    void should_ThrowArithmeticException_When_HeightZero() {
        // given
        double weight = 89.0;
        double height = 0.0;

        // when
        Executable executable = () -> BMICalculator.isDietRecommended(weight, height);

        // then
        assertThrows(ArithmeticException.class, executable);
    }

    @Test
    void should_ReturnCoderWithWorstBMI_WhenCoderListNotEmpty() {
        // given
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.80, 60.0));
        coders.add(new Coder(1.82, 98.0));
        coders.add(new Coder(1.82, 64.7));

        // when
        Coder coderWithWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

        // then
        assertAll(
            () -> assertEquals(1.82, coderWithWorstBMI.getHeight()),
            () -> assertEquals(98.0, coderWithWorstBMI.getWeight())
        );
    }

    @Test
    void should_ReturnNullWorstBMI_WhenCoderListEmpty() {
        // given
        List<Coder> coders = new ArrayList<>();

        // when
        Coder coderWithWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

        // then
        assertNull(coderWithWorstBMI);
    }

    @Test
    void should_ReturnCorrectBMIScoreArray_When_CoderListNotEmpty() {
        // given
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.80, 60.0));
        coders.add(new Coder(1.82, 98.0));
        coders.add(new Coder(1.82, 64.7));
        double[] expected = {18.52, 29.59, 19.53};

        // when
        double[] bmiScore = BMICalculator.getBMIScores(coders);

        // then
        assertArrayEquals(expected, bmiScore);
    }

}