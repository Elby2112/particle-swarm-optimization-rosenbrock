package test;

import pso.PSO;
import problem.ProblemDefinition;
import problem.RosenbrockProblem;

public class Main {
	public static void main(String[] args) {
        int numberOfParticles = 30; // Number of particles in the swarm
        int dimensions = 2; // Rosenbrock function has 2 dimensions (x and y)
        ProblemDefinition problem = new RosenbrockProblem();

        PSO pso = new PSO(numberOfParticles, dimensions, problem);
        int iterations = 100; // Number of iterations for optimization
        pso.optimize(iterations);
    }
}

