package hw21.task21_3_2;

public class SubtractOperation implements OperationStrategy {
    public int execute(int a, int b) {
        int res = a - b;
        System.out.printf("%s - %s = %s%n", a, b, res);
        return res;
    }
}