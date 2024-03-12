package com.baeldung;

public class ExponentialMovingAverage {

    private final double alpha;
    private Double previousEMA;

    public ExponentialMovingAverage(double alpha) {
        if (alpha <= 0 || alpha > 1) {
            throw new IllegalArgumentException("Alpha must be in the range (0, 1]");
        }
        this.alpha = alpha;
        this.previousEMA = null;
    }

    public double calculateEMA(double newValue) {
        if (previousEMA == null) {
            // First data point, EMA is same as the value itself
            previousEMA = newValue;
        } else {
            // Calculate EMA using the formula: EMA = alpha * newValue + (1 - alpha) * previousEMA
            previousEMA = alpha * newValue + (1 - alpha) * previousEMA;
        }
        return previousEMA;
    }
}
