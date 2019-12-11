package com.simonberner.puzzles.day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day02Puzzle01 {

    public static void main(String[] args) throws OpCodeException {
        List<Integer> intCodeList = null;

        try {
            intCodeList = getPuzzleInput();
        } catch (FileNotFoundException e) {
            log.error("Puzzle input-file not found!");
        }

        restoreState(intCodeList);
        runIntCodeAlgorithm(intCodeList);

        log.info("The value left at position 0 is {} ", intCodeList.get(0));

    }

    public static List<Integer> runIntCodeAlgorithm(List<Integer> intCodeList) throws OpCodeException {

        for (int i = 0; i < intCodeList.size(); i += 4) {
            var opCode = intCodeList.get(i);

            switch (opCode) {

            case 1:
                add(intCodeList, i);
                break;
            case 2:
                multiply(intCodeList, i);
                break;
            case 99:
                i = intCodeList.size();
                break;
            default:
                throw new OpCodeException("Something went wrong! (Unknown opcode: " + opCode + ")");

            }
        }
        return intCodeList;

    }

    private static void multiply(List<Integer> intCodeList, int i) {
        var indexOfNoOne = intCodeList.get(i + 1);
        var indexOfNoTwo = intCodeList.get(i + 2);
        var indexOfOutput = intCodeList.get(i + 3);
        var numberOne = intCodeList.get(indexOfNoOne);
        var numberTwo = intCodeList.get(indexOfNoTwo);
        var result = numberOne * numberTwo;
        intCodeList.set(indexOfOutput, result);
    }

    private static void add(List<Integer> intCodeList, int i) {
        var indexOfNoOne = intCodeList.get(i + 1);
        var indexOfNoTwo = intCodeList.get(i + 2);
        var indexOfOutput = intCodeList.get(i + 3);
        var numberOne = intCodeList.get(indexOfNoOne);
        var numberTwo = intCodeList.get(indexOfNoTwo);
        var result = numberOne + numberTwo;
        intCodeList.set(indexOfOutput, result);
    }

    // Restore the gravity assist program to the "1202 program alarm" state it had just before the last computer caught fire
    public static void restoreState(List<Integer> intCodeList) {
        // From the puzzle description:
        // Replace position 1 with the value 12
        intCodeList.set(1, 12);
        // Replace position 2 with the value 2
        intCodeList.set(2, 2);
    }

    // Java Scanner see: https://www.baeldung.com/java-scanner#10-change-scanner-delimiter
    private static List<Integer> getPuzzleInput() throws FileNotFoundException {
        var records = new ArrayList<Integer>();
        try (Scanner scanner = new Scanner(new File("src/main/resources/Day02PuzzleInput.csv"));) {
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                records.add(scanner.nextInt());
            }
        }
        return records;
    }

}
