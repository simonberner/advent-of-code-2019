package com.simonberner.puzzles.day02;

import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static com.simonberner.puzzles.day02.Day02Puzzle01.getPuzzleInput;
import static com.simonberner.puzzles.day02.Day02Puzzle01.runIntCodeAlgorithm;

@Slf4j
public class Day02Puzzle02 {

    public static void main(String[] args) {
        List<Integer> intCodeList = null;
        var result = 0;

        try {
            intCodeList = getPuzzleInput();
        } catch (FileNotFoundException e) {
            log.error("Puzzle input-file not found!");
        }

        try {
            result = findInput(intCodeList, 19690720);
        } catch (OpCodeException e) {
            log.error(e.getMessage());
        }

        log.info("The result is {} ", result);

    }

    // Determine what pair of inputs produces the expected output (value at address 0)
    public static int findInput(List<Integer> intList, int expectedOutput) throws OpCodeException {
        var result = 0;
        // Outer loop for the noun (value placed at address 1)
        for (var noun = 0; noun < 100; noun++) {
            // Nested loop for the verb (value placed at address 2)
            for (var verb = 0; verb < 100; verb++) {
                // Each time when trying a pair, we have to make sure to first reset the computer's memory
                var list = new ArrayList<Integer>(resetMemory(intList, noun, verb));
                // Then run the int code algorithm
                var newList = new ArrayList<Integer>(runIntCodeAlgorithm(list));
                // Break out of the outer and the nested loop
                // See https://www.baeldung.com/java-breaking-out-nested-loop
                if (newList.get(0).equals(expectedOutput)) {
                    return result = 100 * newList.get(1) + newList.get(2);
                }
            }
        }
        return result;
    }

    private static List<Integer> resetMemory(List<Integer> intCodeList, int noun, int verb) {
        intCodeList.set(1, noun);
        intCodeList.set(2, verb);

        return intCodeList;
    }

}
