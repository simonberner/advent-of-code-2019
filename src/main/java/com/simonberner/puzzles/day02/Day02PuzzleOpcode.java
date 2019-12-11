package com.simonberner.puzzles.day02;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Day02PuzzleOpcode {

    ADD(1),
    MULTIPLY(2),
    HALT(99);

    private final Integer value;
}