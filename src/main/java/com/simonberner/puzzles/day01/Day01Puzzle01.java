package com.simonberner.puzzles.day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.extern.slf4j.Slf4j;

// The description of this puzzle can be found here: https://adventofcode.com/2019/day/1
@Slf4j
public class Day01Puzzle01 {

    private static List<Double> moduleMassesInput;

    public static void main(String[] args) {

        try {
            moduleMassesInput = getPuzzleInput();
        } catch (FileNotFoundException e) {
            log.error("Puzzle input-file not found!");
        }

        var moduleMasses = moduleMassesInput.stream().mapToDouble(Number::doubleValue).toArray();

        log.info("The total required fuel for all the modules on my spaceship is: " + calcTotalRequiredFuel(moduleMasses));

    }

    public static double calcTotalRequiredFuel(double[] moduleMasses) {
        var totalAmountOfFuel = 0;
        var minModuleMass = 9; // A module needs to have at least a mass of 9 in order that the fuel-formula can be applied

        for (var moduleMass : moduleMasses) {
            if (moduleMass >= minModuleMass) {
                totalAmountOfFuel += calcRequiredFuelForAModule(moduleMass);
            } else {
                throw new NumberFormatException("The mass of a module must be >= 9!");
            }
        }

        return totalAmountOfFuel;
    }

    public static double calcRequiredFuelForAModule(double moduleMass) {
        return Math.floor(moduleMass / 3) - 2;
    }

    private static List<Double> getPuzzleInput() throws FileNotFoundException {
        var records = new ArrayList<Double>();
        try (Scanner scanner = new Scanner(new File("src/main/resources/Day01PuzzleInput.csv"));) {
            while (scanner.hasNextLine()) {
                records.add(scanner.nextDouble());
            }
        }
        return records;
    }

}