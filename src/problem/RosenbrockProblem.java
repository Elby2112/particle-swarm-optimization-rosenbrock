package problem;

public class RosenbrockProblem implements  ProblemDefinition {
    private static final double A = 1.0;
    private static final double B = 100.0;
    private static final double LOWER_BOUND = -5.0;
    private static final double UPPER_BOUND = 5.0;

    @Override
    public double evaluateFitness(double[] position) {
        double x = position[0];
        double y = position[1];
        return Math.pow(A - x, 2) + B * Math.pow(y - x * x, 2);
    }

    @Override
    public boolean isSolutionValid(double[] position) {
        double x = position[0];
        double y = position[1];
        return x >= LOWER_BOUND && x <= UPPER_BOUND && y >= LOWER_BOUND && y <= UPPER_BOUND;
    }
}
