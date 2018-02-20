package algorithms.week1.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final int n;
    private final WeightedQuickUnionUF uf;
    private boolean[] grid;
    private int num;

    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("n > 0");
        num = 0;
        this.n = n;
        grid = new boolean[n * n];
        uf = new WeightedQuickUnionUF(n * n + 2);
        connectToVirtualSites();
    }

    private void connectToVirtualSites() {
        for (int i = 0; i < n; i++) {
            uf.union(i, n * n);
        }
        for (int i = n * (n - 1); i < n * n; i++) {
            uf.union(i, n * n + 1);
        }
    }

    private void valid(int row, int col) {
        if (row < 1 || row > n)
            throw new IllegalArgumentException("1 < row < n");
        if (col < 1 || col > n)
            throw new IllegalArgumentException("1 < col < n");
    }

    public void open(int row, int col) {
        valid(row, col);
        int i = to1dIndex(row, col);
        if (grid[i])
            return;
        grid[i] = true;
        num++;
        // top
        if (row > 1 && isOpen(row - 1, col))
            uf.union(i, to1dIndex(row - 1, col));
        // bot
        if (row < n && isOpen(row + 1, col))
            uf.union(i, to1dIndex(row + 1, col));
        // left
        if (col > 1 && isOpen(row, col - 1))
            uf.union(i, to1dIndex(row, col - 1));
        // right
        if (col < n && isOpen(row, col + 1))
            uf.union(i, to1dIndex(row, col + 1));
    }

    private int to1dIndex(int row, int col) {
        valid(row, col);
        return ((row - 1) * n + col - 1);
    }

    public boolean isOpen(int row, int col) {
        valid(row, col);
        return grid[to1dIndex(row, col)];
    }

    public boolean isFull(int row, int col) {
        valid(row, col);
        int i = to1dIndex(row, col);
        return grid[i] && uf.connected(n * n, i);
    }

    public int numberOfOpenSites() {
        return num;
    }

    public boolean percolates() {
        return uf.connected(n * n, n * n + 1);
    }


}
