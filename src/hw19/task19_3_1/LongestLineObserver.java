package hw19.task19_3_1;

public class LongestLineObserver implements Observer {
    private String longestLine = "";
    private int maxLength = -1;

    @Override
    public void update(String line) {
        if (line.length() > maxLength) {
            maxLength = line.length();
            longestLine = line;
        }
    }

    public String getLongestLine() {
        return longestLine;
    }

    public int getMaxLength() {
        return maxLength;
    }
}