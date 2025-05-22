package hw19.task19_3_1;

public class LineWithLongestWordObserver implements Observer {
    private String lineWithLongestWord = "";
    private String longestWord = "";
    private int maxWordLength = -1;

    @Override
    public void update(String line) {
        String[] words = line.split("\\s+");
        for (String word : words) {
            if (word.length() > maxWordLength) {
                maxWordLength = word.length();
                longestWord = word;
                lineWithLongestWord = line;
            }
        }
    }

    public String getLineWithLongestWord() {
        return lineWithLongestWord;
    }

    public String getLongestWord() {
        return longestWord;
    }

    public int getMaxWordLength() {
        return maxWordLength;
    }
}