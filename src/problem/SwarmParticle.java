package problem;

import java.util.Random;

public class SwarmParticle {
    private double[] position;
    private double[] velocity;
    private double[] personalBestPosition;
    private double personalBestScore;

    public SwarmParticle(int dimension) {
        Random rand = new Random();
        this.position = new double[dimension];
        this.velocity = new double[dimension];
        this.personalBestPosition = new double[dimension];

        // Initialize position and velocity randomly
        for (int i = 0; i < dimension; i++) {
            position[i] = rand.nextDouble() * 5; // Initial position in range [0, 5]
            velocity[i] = rand.nextDouble() - 0.5; // Initial velocity in range [-0.5, 0.5]
        }
        this.personalBestScore = Double.POSITIVE_INFINITY; // Start with infinity for best score
    }

    public double[] getPosition() {
        return position;
    }

    public double[] getVelocity() {
        return velocity;
    }

    public void setPosition(double[] position) {
        this.position = position;
    }

    public void setVelocity(double[] velocity) {
        this.velocity = velocity;
    }

    public double getPersonalBestScore() {
        return personalBestScore;
    }

    public void setPersonalBestScore(double score) {
        this.personalBestScore = score;
    }

    public double[] getPersonalBestPosition() {
        return personalBestPosition;
    }

    public void setPersonalBestPosition(double[] position) {
        this.personalBestPosition = position;
    }
}

