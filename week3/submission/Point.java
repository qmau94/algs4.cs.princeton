import java.util.Comparator;

import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {
    
    private final int x;
    private final int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void draw() {
        StdDraw.point(x, y);
    }
    
    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }
    
    public double slopeTo(Point that) {
        double X = that.x - this.x;
        double Y = that.y - this.y;
        
        if (X == 0.0 && Y == 0.0)
            return Double.NEGATIVE_INFINITY;
        
        if (Y == 0.0)
            return +0.0f;
        
        if (X == 0.0)
            return Double.POSITIVE_INFINITY;
        
        return Y / X;
    }
    
    public int compareTo(Point that) {
        if (that == null) {
            throw new NullPointerException();
        }
        if (this.x == that.x && this.y == that.y) {
            return 0;
        }
        if (this.y < that.y || (this.y == that.y && this.x < that.x)) {
            return -1;
        }
        return 1;
    }
    
    public Comparator<Point> slopeOrder() {
        return new bySlope();
    }
    
    private class bySlope implements Comparator<Point> {
        public int compare(Point p1, Point p2) {
            return Double.compare(slopeTo(p2), slopeTo(p1));
        }
    }
    
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
}
