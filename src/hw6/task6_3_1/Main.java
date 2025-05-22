package hw6.task6_3_1;

import java.io.*;

class FileProcessor {
    private static FileProcessor instance;

    private FileProcessor() {}

    public static synchronized FileProcessor getInstance() {
        if (instance == null) {
            instance = new FileProcessor();
        }
        return instance;
    }

    public String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    public void writeFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }

    public String processContent(String content) {
        return content.toUpperCase();
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            FileProcessor processor = FileProcessor.getInstance();

            String content = processor.readFile(System.getProperty("user.dir") + "\\src\\hw6\\task6_3_1\\input.txt");
            String processedContent = processor.processContent(content);
            processor.writeFile(System.getProperty("user.dir") + "\\src\\hw6\\task6_3_1\\output.txt", processedContent);

            System.out.println("File processed successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}