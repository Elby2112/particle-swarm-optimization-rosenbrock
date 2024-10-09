package pso;

import problem.SwarmParticle;
import problem.ProblemDefinition;

public class PSO {

    private SwarmParticle[] swarm;
    private double[] globalBestPosition;
    private double globalBestScore;
    private int dimension;
    private ProblemDefinition problem;

    public PSO(int numberOfParticles, int dimension, ProblemDefinition problem) {
        this.problem = problem;
        this.dimension = dimension;
        this.swarm = new SwarmParticle[numberOfParticles];
        this.globalBestPosition = new double[dimension];
        this.globalBestScore = Double.POSITIVE_INFINITY;
        initializeSwarm();
    }

    private void initializeSwarm() {
        for (int i = 0; i < swarm.length; i++) {
            SwarmParticle particle = new SwarmParticle(dimension);
            swarm[i] = particle;

            double[] initialPosition = particle.getPosition();
            double initialFitness = problem.evaluateFitness(initialPosition);

            if (initialFitness < globalBestScore) {
                globalBestScore = initialFitness;
                System.arraycopy(initialPosition, 0, globalBestPosition, 0, dimension);
            }
        }
    }

    public void optimize(int iterations) {
        for (int i = 0; i < iterations; i++) {
            updateParticles();

            // Optional: Print or log progress
            if (i % 10 == 0) {
                System.out.printf("Iteration %d: Global Best Score = %.4f\n", i, globalBestScore);
            }
        }

        // Final output of the best found solution
        System.out.println("Optimization complete!");
        System.out.printf("Best Solution Found: Score = %.4f\n", globalBestScore);
        System.out.print("Best Position: ");
        for (double value : globalBestPosition) {
            System.out.printf("%.4f ", value);
        }
        System.out.println();
    }

    private void updateParticles() {
        double inertiaWeight = 0.5;
        double cognitiveComponent = 2.0;
        double socialComponent = 2.0;

        for (SwarmParticle particle : swarm) {
            double[] velocity = particle.getVelocity();
            double[] position = particle.getPosition();
            double[] personalBest = particle.getPersonalBestPosition();

            for (int i = 0; i < velocity.length; i++) {
                double randCognitive = Math.random();
                double randSocial = Math.random();

                velocity[i] = inertiaWeight * velocity[i] +
                        cognitiveComponent * randCognitive * (personalBest[i] - position[i]) +
                        socialComponent * randSocial * (globalBestPosition[i] - position[i]);
            }

            for (int i = 0; i < position.length; i++) {
                position[i] += velocity[i];
            }

            particle.setPosition(position);
            particle.setVelocity(velocity);

            double fitness = problem.evaluateFitness(position);
            if (fitness < particle.getPersonalBestScore()) {
                particle.setPersonalBestScore(fitness);
                particle.setPersonalBestPosition(position.clone());
            }

            if (fitness < globalBestScore) {
                globalBestScore = fitness;
                System.arraycopy(position, 0, globalBestPosition, 0, position.length);
            }
        }
    }
}
