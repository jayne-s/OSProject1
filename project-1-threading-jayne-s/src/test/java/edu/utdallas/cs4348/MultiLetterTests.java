package edu.utdallas.cs4348;

import org.junit.jupiter.api.Test;

public class MultiLetterTests {

    private final String[] onePerLetterList = {"Vader", "Yoda", "Ben", "Han"};
    @Test
    public void testOnePerLetter() throws Exception {
        Tester.testAnArray(onePerLetterList);
    }

    private final String[] multiLetterList =
            {"Coruscant", "Corellia", "Crait",
            "Nevarro", "Naboo", "Neral", "Nal Hutta",
            "Trandosha", "Tatooine", "Taanab"};
    @Test
    public void testMultiPerLetter() throws Exception {
        Tester.testAnArray(multiLetterList);
    }
}
