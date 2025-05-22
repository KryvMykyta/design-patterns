package hw19.task19_3_1;

public class WordCountObserver implements Observer {
    private int wordCount = 0;

    @Override
    public void update(String line) {
        String[] words = line.split("\\s+");
        wordCount += words.length;
    }

    public int getWordCount() {
        return wordCount;
    }
}