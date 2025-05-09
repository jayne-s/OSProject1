package edu.utdallas.cs4348;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tester {
    public static void testAnArray(String[] stringArray) throws Exception {
        MapReduceStringSort sorter = new MapReduceStringSort();
        for ( String word : stringArray) {
            sorter.addWord(word);
        }
        sorter.done();
        List<String> sortedList = sorter.getResults();
        List<String> referenceList = Arrays.asList(stringArray);
        Collections.sort(referenceList);
        assert(sortedList.size() == referenceList.size())
                : "Size isn't right: " + sortedList.size() + ", expected " + referenceList.size();
        for ( int i=0; i<sortedList.size(); i++) {
            assert(sortedList.get(i).equals(referenceList.get(i)))
                    : "Not sorted at " + i + ": " + sortedList.get(i) + ", expected " + referenceList.get(i);
        }
    }
}
