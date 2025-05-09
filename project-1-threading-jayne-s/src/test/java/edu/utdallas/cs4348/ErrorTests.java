package edu.utdallas.cs4348;

import org.junit.jupiter.api.Test;

public class ErrorTests {

    @Test
    public void testBlankString() {
        MapReduceStringSort sorter = new MapReduceStringSort();

        try {
            sorter.addWord("");
            throw new RuntimeException("Blank word accepted");
        } catch ( Exception e) {
            // Expected :)
        }

        sorter.done();
        assert(sorter.getResults().isEmpty()) : "Blank string accepted???";
    }

    @Test
    public void testNonCapitalLetters() {
        MapReduceStringSort sorter = new MapReduceStringSort();
        try {
            sorter.addWord("babble");
            throw new RuntimeException("Lowercase 1st letter accepted");
        } catch ( Exception e) {
            // Expected :)
        }

        try {
            sorter.addWord("1234");
            throw new RuntimeException("Numbered 1st letter accepted");
        } catch ( Exception e) {
            // Expected :)
        }
        sorter.done();
        assert ( sorter.getResults().isEmpty()) : "Somehow invalid entries got added???";
    }
}
