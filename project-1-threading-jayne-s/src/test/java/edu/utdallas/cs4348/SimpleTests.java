package edu.utdallas.cs4348;

import org.junit.jupiter.api.Test;

public class SimpleTests {

    private final String[] singleWord = {"Abba"};
    @Test
    public void testSingle() throws Exception {
        Tester.testAnArray(singleWord);
    }

    private final String[] singleLetterList = {"Ally", "Abba", "Away"};

    @Test
    public void testSingleStartingLetter() throws Exception {
        Tester.testAnArray(singleLetterList);
    }
}
