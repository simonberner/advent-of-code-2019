package com.simonberner.puzzlechecks;

import static com.simonberner.puzzles.day02.Day02Puzzle01.runIntCodeAlgorithm;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.simonberner.puzzles.day02.OpCodeException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day02Puzzle01Tests {

    @Test
    void runIntCodeAlgorithmAddTest() throws OpCodeException {
        var testInputAddition = Arrays.asList(1, 2, 2, 0, 1, 3, 3, 1, 99, 5, 6, 0);
        var expectedList = Arrays.asList(4, 0, 2, 0, 1, 3, 3, 1, 99, 5, 6, 0);
        var resultList = runIntCodeAlgorithm(testInputAddition);

        assertEquals(expectedList, resultList, "Lists are not equal!");
    }

    @Test
    void runIntCodeAlgorithmMultiplyTest() throws OpCodeException {
        var testInputAddition = Arrays.asList(2, 2, 2, 0);
        var expectedList = Arrays.asList(4, 2, 2, 0);
        var resultList = runIntCodeAlgorithm(testInputAddition);

        assertEquals(expectedList, resultList, "Lists are not equal!");
    }

    @Test
    void runIntCodeAlgorithmExceptionTest() throws OpCodeException {
        var testInputAddition = Arrays.asList(1, 2, 2, 0, 1, 3, 3, 1, 1000, 5, 6, 0);

        assertThrows(OpCodeException.class, () -> {
            runIntCodeAlgorithm(testInputAddition);
        });

    }

}