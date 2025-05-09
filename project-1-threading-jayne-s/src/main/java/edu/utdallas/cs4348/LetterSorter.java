package edu.utdallas.cs4348;

import java.util.ArrayList;
import java.util.List;

public class LetterSorter implements Runnable {

    private final List<String> sortedStrings = new ArrayList<>();

    private Thread thread;

    private String newWord = null;

    private boolean done = false;

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public synchronized void run() {
        while(true) {
            if(newWord != null) {
                sortedStrings.add(newWord);
                newWord = null;

                int j;
                for(int i = 1; i < sortedStrings.size(); i++) {
                   String temp = sortedStrings.get(i);
                   for(j = i; j > 0 && temp.compareTo(sortedStrings.get(j-1)) < 0; j--) {
                       sortedStrings.set(j, sortedStrings.get(j-1));
                   }
                   sortedStrings.set(j, temp);
                }
                notifyAll();
            }

            if(done) {
                break;
            }
            try {
                wait();
            } catch(InterruptedException e) {
                //ignore
            }
        }
    }

    public synchronized void addWord(String word) {
        while(newWord != null) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                //ignore
            }
        }
        newWord = word;
        notify();
    }

    public void stop() {
        synchronized(this) {
            done = true;
            notify();
        }
        try {
            thread.join();
        } catch (InterruptedException e) {
            //ignore
        }
    }

    public List<String> getSortedStrings() {
        return sortedStrings;
    }
}
