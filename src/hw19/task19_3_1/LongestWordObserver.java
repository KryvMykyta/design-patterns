package hw19.task19_3_1;

public class LongestWordObserver implements Observer {
    private String longestWord = "";
    private int maxWordLength = -1;

    @Override
    public void update(String line) {
        String[] words = line.split("\\s+");
        for (String word : words) {
            if (word.length() > maxWordLength) {
                maxWordLength = word.length();
                longestWord = word;
            }
        }
    }

    public String getLongestWord() {
        return longestWord;
    }

    public int getMaxWordLength() {
        return maxWordLength;
    }
}