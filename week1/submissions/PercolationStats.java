import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] threshold;
    private final int size;
    private final int trials;
    private final double CONFIDENCE_95 = 1.96;
    
    public PercolationStats(int n, int t) {
        if (n < 0 || t < 0)
            throw new IllegalArgumentException("n < 0 || t < 0");
        threshold = new double[t];
        size = n;
        trials = t;
        for (int i = 0; i < t; i++) {
            Percolation p = new Percolation(size);
            while (!p.percolates()) {
                int row = StdRandom.uniform(size) + 1;
                int col = StdRandom.uniform(size) + 1;
                if (!p.isOpen(row, col)) {
                    p.open(row, col);
                }
            }
            threshold[i] = p.numberOfOpenSites() / (double) (size * size);
        }
    }
    
    public double mean() {
        return StdStats.mean(threshold);
    }
    
    public double stddev() {
        return StdStats.stddev(threshold);
    }
    
    public double confidenceLo() {
        return mean() - ((CONFIDENCE_95 * stddev()) / Math.sqrt(trials));
    }
    
    public double confidenceHi() {
        return mean() + ((CONFIDENCE_95 * stddev()) / Math.sqrt(trials));
    }
    
    public static void main(String[] args) {
        try {
            int size = 200;
            int trials = 3;
            
            PercolationStats percolationStats = new PercolationStats(size, trials);
            StdOut.println("mean                    = " + percolationStats.mean());
            StdOut.println("stddev                  = " + percolationStats.stddev());
            StdOut.println("95% confidence interval = " + percolationStats.confidenceLo() + ", "
                           + percolationStats.confidenceHi());
        } catch (NumberFormatException e) {
            StdOut.println("Argument must be an integer");
            return;
        }
    }
    
}
