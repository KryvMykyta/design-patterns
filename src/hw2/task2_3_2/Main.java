package hw2.task2_3_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Equation {
    protected double[] coefficients;

    public Equation(double[] coefficients) {
        this.coefficients = coefficients;
    }

    public abstract List<Double> solve();

    protected boolean isZero(double value) {
        return Math.abs(value) < 1e-10;
    }
}

class LinearEquation extends Equation {
    public LinearEquation(double[] coefficients) {
        super(coefficients);
    }

    @Override
    public List<Double> solve() {
        List<Double> solutions = new ArrayList<>();
        double b = coefficients[0];
        double c = coefficients[1];

        if (isZero(b)) {
            if (isZero(c)) {
                return null;
            } else {
                return solutions;
            }
        }

        solutions.add(-c / b);
        return solutions;
    }
}

class QuadraticEquation extends Equation {
    public QuadraticEquation(double[] coefficients) {
        super(coefficients);
    }

    @Override
    public List<Double> solve() {
        List<Double> solutions = new ArrayList<>();
        double a = coefficients[0];
        double b = coefficients[1];
        double c = coefficients[2];

        if (isZero(a)) {
            return new LinearEquation(new double[]{b, c}).solve();
        }

        double discriminant = b * b - 4 * a * c;

        if (isZero(discriminant)) {
            solutions.add(-b / (2 * a));
        } else if (discriminant > 0) {
            solutions.add((-b + Math.sqrt(discriminant)) / (2 * a));
            solutions.add((-b - Math.sqrt(discriminant)) / (2 * a));
        }

        return solutions;
    }
}

class BiQuadraticEquation extends Equation {
    public BiQuadraticEquation(double[] coefficients) {
        super(coefficients);
    }

    @Override
    public List<Double> solve() {
        List<Double> solutions = new ArrayList<>();
        double a = coefficients[0];
        double b = coefficients[2];
        double c = coefficients[4];

        double[] quadCoeffs = {a, b, c};
        List<Double> ySolutions = new QuadraticEquation(quadCoeffs).solve();

        if (ySolutions == null) {
            return null;
        }

        for (double y : ySolutions) {
            if (y > 0) {
                solutions.add(Math.sqrt(y));
                solutions.add(-Math.sqrt(y));
            } else if (isZero(y)) {
                solutions.add(0.0);
            }
        }

        return solutions;
    }
}

class EquationFactory {
    public static Equation createEquation(double[] coefficients) {
        switch (coefficients.length) {
            case 2:
                return new LinearEquation(coefficients);
            case 3:
                return new QuadraticEquation(coefficients);
            case 5:
                return new BiQuadraticEquation(coefficients);
            default:
                throw new IllegalArgumentException("Invalid number of coefficients: " + coefficients.length);
        }
    }
}

class EquationSolver {
    public static void main(String[] args) {
        // Default input files
        String[] inputFiles = {
            "C:\\Users\\Mykyta\\IdeaProjects\\design-patterns\\src\\hw2\\task2_3_2\\input01.txt",
            "C:\\Users\\Mykyta\\IdeaProjects\\design-patterns\\src\\hw2\\task2_3_2\\input02.txt",
            "C:\\Users\\Mykyta\\IdeaProjects\\design-patterns\\src\\hw2\\task2_3_2\\input03.txt"
        };

        for (String file : inputFiles) {
            processFile(file);
        }
    }

    private static void processFile(String filename) {
        List<Equation> equations = new ArrayList<>();
        File file = new File(filename);

        if (!file.exists()) {
            System.err.println("Error: File '" + filename + "' not found in " + file.getAbsolutePath());
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                double[] coefficients = Arrays.stream(line.trim().split("\\s+"))
                        .mapToDouble(Double::parseDouble)
                        .toArray();
                equations.add(EquationFactory.createEquation(coefficients));
            }
        } catch (IOException e) {
            System.err.println("Error reading file '" + filename + "': " + e.getMessage());
            return;
        }

        int[] solutionCounts = new int[5];
        int infiniteSolutions = 0;
        Double minSingleSolution = null;
        Double maxSingleSolution = null;
        String minSingleEquation = null;
        String maxSingleEquation = null;

        for (int i = 0; i < equations.size(); i++) {
            Equation eq = equations.get(i);
            List<Double> solutions = eq.solve();
            String equationStr = Arrays.toString(eq.coefficients);

            if (solutions == null) {
                infiniteSolutions++;
            } else {
                int numSolutions = solutions.size();
                if (numSolutions <= 4) {
                    solutionCounts[numSolutions]++;
                }
                if (numSolutions == 1) {
                    double solution = solutions.get(0);
                    if (minSingleSolution == null || solution < minSingleSolution) {
                        minSingleSolution = solution;
                        minSingleEquation = equationStr;
                    }
                    if (maxSingleSolution == null || solution > maxSingleSolution) {
                        maxSingleSolution = solution;
                        maxSingleEquation = equationStr;
                    }
                }
            }
        }

        System.out.println("Results for " + filename + ":");
        System.out.println("Equations with no solutions: " + solutionCounts[0]);
        System.out.println("Equations with one solution: " + solutionCounts[1]);
        System.out.println("Equations with two solutions: " + solutionCounts[2]);
        System.out.println("Equations with three solutions: " + solutionCounts[3]);
        System.out.println("Equations with four solutions: " + solutionCounts[4]);
        System.out.println("Equations with infinite solutions: " + infiniteSolutions);
        if (minSingleSolution != null) {
            System.out.printf("Equation with smallest single solution: %s, solution: %.4f%n",
                    minSingleEquation, minSingleSolution);
        } else {
            System.out.println("No equations with exactly one solution");
        }
        if (maxSingleSolution != null) {
            System.out.printf("Equation with largest single solution: %s, solution: %.4f%n",
                    maxSingleEquation, maxSingleSolution);
        } else {
            System.out.println("No equations with exactly one solution");
        }
        System.out.println();
    }
}