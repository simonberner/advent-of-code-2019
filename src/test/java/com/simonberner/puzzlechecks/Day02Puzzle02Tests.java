package com.simonberner.puzzlechecks;

import com.simonberner.puzzles.day02.OpCodeException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.simonberner.puzzles.day02.Day02Puzzle02.findInput;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class Day02Puzzle02Tests {

    @Test
    void findInputTest() throws OpCodeException {
        var testList = Arrays.asList(1, 2, 2, 0, 1, 3, 3, 1, 99, 5, 6, 0);
        var result = findInput(testList, 4);

        assertEquals(5, result, "The result is not as expected!");
    }

}