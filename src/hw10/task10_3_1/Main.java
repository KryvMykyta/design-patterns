package hw10.task10_3_1;

class PrintableString {
    protected final String base;

    public PrintableString(String base) {
        this.base = base;
    }

    public void print() {
        System.out.print(base);
    }
}

class PostComaDecorator extends PrintableString {
    private final PrintableString printableString;

    public PostComaDecorator(PrintableString printableString) {
        super("");
        this.printableString = printableString;
    }

    public void print() {
        printableString.print();
        System.out.print(",");
    }
}

class PostEndlDecorator extends PrintableString {
    private final PrintableString printableString;

    public PostEndlDecorator(PrintableString printableString) {
        super("");
        this.printableString = printableString;
    }

    public void print() {
        printableString.print();
        System.out.println();
    }
}

class PostSpaceDecorator extends PrintableString {
    private final PrintableString printableString;

    public PostSpaceDecorator(PrintableString printableString) {
        super("");
        this.printableString = printableString;
    }

    public void print() {
        printableString.print();
        System.out.print(" ");
    }
}

class PostExclaimDecorator extends PrintableString {
    private final PrintableString printableString;

    public PostExclaimDecorator(PrintableString printableString) {
        super("");
        this.printableString = printableString;
    }

    public void print() {
        printableString.print();
        System.out.print("!");
    }
}

class PostWordDecorator extends PrintableString {
    private final PrintableString printableString;
    private final String word;

    public PostWordDecorator(PrintableString printableString, String word) {
        super("");
        this.printableString = printableString;
        this.word = word;
    }

    public void print() {
        printableString.print();
        System.out.print(word);
    }
}

class PreWordDecorator extends PrintableString {
    private final PrintableString printableString;
    private final String word;

    public PreWordDecorator(PrintableString printableString, String word) {
        super("");
        this.printableString = printableString;
        this.word = word;
    }

    public void print() {
        System.out.print(word);
        printableString.print();
    }
}

class Main {
    public static void main(String[] args) {
        PrintableString str = new PrintableString("");
        str = new PreWordDecorator(str, "Hello");
        str = new PostComaDecorator(str);
        str = new PostSpaceDecorator(str);
        str = new PostWordDecorator(str, "World");
        str = new PostExclaimDecorator(str);
        str = new PostEndlDecorator(str);
        str.print();
    }
}