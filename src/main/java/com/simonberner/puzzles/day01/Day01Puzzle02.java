package com.simonberner.puzzles.day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day01Puzzle02 {

    public static void main(String[] args) {

        List<Double> moduleMassesInput = null;

        try {
            moduleMassesInput = getPuzzleInput();
        } catch (FileNotFoundException e) {
            log.error("Puzzle input-file not found!");
        }

        var moduleMasses = moduleMassesInput.stream().mapToDouble(Number::doubleValue).toArray();
        log.info("The total required fuel for all the modules (including the fuel needed for the mass of the required fuel) on my spaceship is: " + calcTotalRequiredFuel(moduleMasses));

    }

    public static double calcTotalRequiredFuel(double[] moduleMasses) {
        var totalAmountOfFuel = 0;

        for (var moduleMass : moduleMasses) {
            totalAmountOfFuel += calcTotalFuelNeededForAModule(moduleMass);
        }

        return totalAmountOfFuel;
    }

    // Solution with a tail recursion https://www.baeldung.com/java-recursion#2-tail-recursion-versus-head-recursion
    public static double calcTotalFuelNeededForAModule(double fuelMass) {
        var fuelNeeded = calcRequiredFuel(fuelMass);

        if (fuelNeeded <= 0) {
            return 0;
        }
        return fuelNeeded + calcTotalFuelNeededForAModule(fuelNeeded);
    }

    private static double calcRequiredFuel(double mass) {
        return Math.floor(mass / 3) - 2;
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