package com.simonberner.puzzlechecks;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.simonberner.puzzles.day01.Day01Puzzle02;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day01Puzzle02Tests {

    @Test
    void calcTotalFuelNeededForAModule() {
        assertAll(
                () -> assertEquals(2, Day01Puzzle02.calcTotalFuelNeededForAModule(12)),
                () -> assertEquals(2, Day01Puzzle02.calcTotalFuelNeededForAModule(14)),
                () -> assertEquals(966, Day01Puzzle02.calcTotalFuelNeededForAModule(1969)),
                () -> assertEquals(50346, Day01Puzzle02.calcTotalFuelNeededForAModule(100756))
        );
    }

    @Test
    void calcTotalRequiredFuelTest() {
        double[] moduleMasses = { 12, 14, 1969, 100756 };
        assertEquals(51316, Day01Puzzle02.calcTotalRequiredFuel(moduleMasses));
    }

}