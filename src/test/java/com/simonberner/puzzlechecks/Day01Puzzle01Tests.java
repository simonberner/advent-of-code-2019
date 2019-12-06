package com.simonberner.puzzlechecks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.simonberner.puzzles.day01.Day01Puzzle01;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day01Puzzle01Tests {

    @Test
    void calcRequiredFuelForAModuleTest() {
        Assertions.assertEquals(2, Day01Puzzle01.calcRequiredFuelForAModule(12));
        Assertions.assertEquals(2, Day01Puzzle01.calcRequiredFuelForAModule(14));
        Assertions.assertEquals(654, Day01Puzzle01.calcRequiredFuelForAModule(1969));
        Assertions.assertEquals(33583, Day01Puzzle01.calcRequiredFuelForAModule(100756));
    }

    @Test
    void calcTotalRequiredFuelTest() {
        double[] moduleMasses = { 12, 14, 1969, 100756 };
        Assertions.assertEquals(34241, Day01Puzzle01.calcTotalRequiredFuel(moduleMasses));
    }
}