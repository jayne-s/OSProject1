package edu.utdallas.cs4348;

import java.util.ArrayList;
import java.util.List;

public class MapReduceStringSort {

    private static final int ASCII_A = 65;

    private final List<LetterSorter> letterSorters = new ArrayList<>();

    public MapReduceStringSort() {
        for(int i = 0; i < 26; i++) {
            LetterSorter sorter = new LetterSorter();
            letterSorters.add(sorter);
            sorter.start();
        }
    }

    public void addWord(String word) throws Exception {
        if(word.isEmpty()) {
            throw new Exception("Word is empty");
        }
        if(!Character.isUpperCase(word.charAt(0))) {
            throw new Exception("Not upper case letter");
        }
        if (word.charAt(0) < ASCII_A || word.charAt(0) > (ASCII_A + 25)) {
            throw new Exception("Not an Alphabet");
        }
        int index = word.charAt(0) - ASCII_A;
        letterSorters.get(index).addWord(word);
    }

    public List<String> getResults() {
       if(!letterSorters.isEmpty()) {
           List<String> results = new ArrayList<>();

           for (LetterSorter letterSorter : letterSorters) {
               List<String> temp = letterSorter.getSortedStrings();
               if (!temp.isEmpty()) {
                   results.addAll(temp);
               }
           }
           return results;
       }
       return null;
    }

    public void done() {
        for (LetterSorter letterSorter : letterSorters) {
            if (letterSorter != null) {
                letterSorter.stop();
            }
        }
    }
}
