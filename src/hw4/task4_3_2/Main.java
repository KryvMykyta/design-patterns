package hw4.task4_3_2;

interface StringBuilderInterface {
    void reset();
    void append(String sequence);
    void insert(int position, String sequence);
    String getResult();
}

class CustomStringBuilder implements StringBuilderInterface {
    private java.lang.StringBuilder stringBuilder;

    public CustomStringBuilder() {
        reset();
    }

    public void reset() {
        stringBuilder = new java.lang.StringBuilder();
    }

    public void append(String sequence) {
        stringBuilder.append(sequence);
    }

    public void insert(int position, String sequence) {
        stringBuilder.insert(position, sequence);
    }

    public String getResult() {
        return stringBuilder.toString();
    }
}

class StringDirector {
    private StringBuilderInterface stringBuilder;

    public StringDirector(StringBuilderInterface stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public String buildSimpleString() {
        stringBuilder.reset();
        stringBuilder.append("Hello");
        stringBuilder.append(" World!");
        return stringBuilder.getResult();
    }

    public String buildComplexString() {
        stringBuilder.reset();
        stringBuilder.append("World!");
        stringBuilder.insert(0, "Hello ");
        stringBuilder.append(" Welcome to Java.");
        stringBuilder.insert(6, ",");
        return stringBuilder.getResult();
    }
}

class Main {
    public static void main(String[] args) {
        StringBuilderInterface builder = new CustomStringBuilder();
        StringDirector director = new StringDirector(builder);

        String simpleString = director.buildSimpleString();
        String complexString = director.buildComplexString();

        System.out.println(simpleString);
        System.out.println(complexString);
    }
}