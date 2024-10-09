package problem;

import java.util.HashMap;
import java.util.Map;

public interface  ProblemDefinition {
	double evaluateFitness(double[] position);
    boolean isSolutionValid(double[] position);
}

