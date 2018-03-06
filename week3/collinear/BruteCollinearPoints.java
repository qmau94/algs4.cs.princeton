package algs4.week3.collinear;

import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {

    private ArrayList<LineSegment> lineSegments = new ArrayList<LineSegment>();

    public BruteCollinearPoints(Point[] points) {
        int N = points.length;
        if (invalidPoints(points))
            throw new IllegalArgumentException("invalid points");
        for (int p = 0; p < N - 3; p++) {
            for (int q = p + 1; q < N - 2; q++) {
                double slopePQ = points[p].slopeTo(points[q]);
                for (int r = q + 1; r < N - 1; r++) {
                    double slopePR = points[p].slopeTo(points[r]);
                    if (slopePQ == slopePR) {
                        for (int s = r + 1; s < N; s++) {
                            double slopePS = points[p].slopeTo(points[s]);
                            if (slopePS == slopePR) {
                                lineSegments.add(new LineSegment(points[p], points[s]));
                            }
                        }
                    }
                }
            }
        }

    }

    private boolean invalidPoints(Point[] points) {
        Arrays.sort(points);
        if (points == null) {
            StdOut.print(points);
            return true;
        }
        for (int i = 0; i < points.length - 2; i++) {
            if (points[i].compareTo(points[i + 1]) == 0 || points[i] == null) {
                return true;
            }
        }
        return false;
    }

    public int numberOfSegments() {
        return lineSegments.size();
    }

    public LineSegment[] segments() {
        return lineSegments.toArray(new LineSegment[numberOfSegments()]);
    }

    private void printOut(Point[] points) {
        for (int i = 0; i < points.length; i++) {
            StdOut.print(points[i].toString());
        }
    }

    public static void main(String[] args) {

        // read the n points from a file
        // In in = new In(args[0]);
        // int n = in.readInt();
        // Point[] points = new Point[n];
        // for (int i = 0; i < n; i++) {
        // int x = in.readInt();
        // int y = in.readInt();
        // points[i] = new Point(x, y);
        // }
        Point[] points = new Point[6];

        points[0] = new Point(19000, 10000);
        points[1] = new Point(18000, 10000);
        points[2] = new Point(32000, 10000);
        points[3] = new Point(21000, 10000);
        points[4] = new Point(1234, 5678);
        points[5] = new Point(14000, 10000);

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        if (collinear.numberOfSegments() > 0) {
            for (LineSegment segment : collinear.segments()) {
                StdOut.println(segment);
                segment.draw();
            }
            StdDraw.show();
        }
    }
}
