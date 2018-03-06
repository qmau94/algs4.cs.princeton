package algs4.week3.collinear;

import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class FastCollinearPoints {

    private ArrayList<LineSegment> lineSegments = new ArrayList<LineSegment>();

    public FastCollinearPoints(Point[] points) {
        Point[] pCopy = points.clone();
        Arrays.sort(pCopy);
        int N = points.length;
        invalidPoints(pCopy);
        for (int i = 0; i < N - 3; i++) {
            Arrays.sort(pCopy);
            Arrays.sort(pCopy, pCopy[i].slopeOrder());
            for (int p = 0, first = 1, last = 2; last < N; last++) {
                while (last < pCopy.length
                        && pCopy[p].slopeTo(pCopy[first]) == pCopy[p].slopeTo(pCopy[last])) {
                    last++;
                }
                if (last - first > 2 && pCopy[p].compareTo(pCopy[first]) < 0) {
                    lineSegments.add(new LineSegment(pCopy[p], pCopy[last - 1]));
                }
                first = last;
            }
        }
    }

    private void invalidPoints(Point[] points) {
        if (points == null)
            throw new NullPointerException("null points");

        if (hasDuplicate(points)) {
            throw new IllegalArgumentException("duplicate points");
        }
    }

    private boolean hasDuplicate(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].compareTo(points[i + 1]) == 0) {
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
        StdOut.println("");
    }

    public static void main(String[] args) {

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
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        if (collinear.numberOfSegments() > 0) {
            for (LineSegment segment : collinear.segments()) {
                StdOut.println(segment);
                segment.draw();
            }
            StdDraw.show();
        }
    }
}
