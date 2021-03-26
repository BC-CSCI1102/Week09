// file: MultiSegmentLineC.java
// author: Bob Muller
//

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

import java.awt.Color;
import java.util.Arrays;


public class MultiSegmentLineC implements MultiSegmentLine {

  private final boolean DEBUG = false;

  private int N;
  private Line[] lines;
  private Color color;

  public MultiSegmentLineC(Line[] lines, java.awt.Color color) {
    N = lines.length;
    this.lines = lines;
    this.color = color;
  }

  public int segments() {
    return N;
  }

  public double length() {
    int len = 0;
    for (Line line : this.lines)
      len += line.length();
    return len;
  }

  // Retrieve the ith line segment.
  //
  public Line segment(int i) {
    return this.lines[i];
  }

  public void render() {
    StdDraw.setPenColor(this.color);
    for (Line line : this.lines)
      line.render();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Line line : this.lines)
      sb.append(String.format("%s ", line.toString()));
    return String.format("{mls: %s }", sb.toString());
  }

  private Point min() {
    double x =
            Arrays.stream(this.lines)
                  .map(Line::min)
                  .mapToDouble(Point::getX)
                  .reduce((x1, x2) -> Double.compare(x1, x2) < 0 ? x1 : x2)
                  .getAsDouble();
    double y =
            Arrays.stream(this.lines)
                  .map(Line::min)
                  .mapToDouble(Point::getY)
                  .reduce((y1, y2) -> Double.compare(y1, y2) < 0 ? y1 : y2)
                  .getAsDouble();
    return new PointC(x, y);
  }

  private Point max() {
    double x =
            Arrays.stream(this.lines)
                  .map(Line::max)
                  .mapToDouble(Point::getX)
                  .reduce((x1, x2) -> Double.compare(x1, x2) < 0 ? x2 : x1)
                  .getAsDouble();
    double y =
            Arrays.stream(this.lines)
                  .map(Line::max)
                  .mapToDouble(Point::getY)
                  .reduce((y1, y2) -> Double.compare(y1, y2) < 0 ? y2 : y1)
                  .getAsDouble();
    return new PointC(x, y);
  }

  public Point center() {
    return new LineC(this.min(), this.max()).midpoint();
  }

  // compare by center of bounding boxes
  public int compareTo(MultiSegmentLine other) {
    if (other == null)
      throw new RuntimeException("null MultiSegmentLine");
    return this.center().compareTo(other.center());
  }

  @Override
  public boolean equals(Object other) {
    if (other == null || other.getClass() != this.getClass())
      return false;
    return this.compareTo((MultiSegmentLine) other) == 0;
  }

  @Override
  public int hashCode() {
    return 343;
  }

  static double equilateralHeight(double side) {
    double half = side / 2.0;
    return Math.sqrt(Math.pow(side, 2.0) - Math.pow(half, 2.0));
  }

  public static void main(String[] args) {

    StdDraw.setCanvasSize(800, 800);
    StdDraw.setPenRadius(.006);
    double side = 0.25;
    double half = side / 2.0;
    double height = equilateralHeight(side);
    double
            x0 = 0.25, y0 = 0.5,
            x1 = x0 + half, y1 = y0 + height,
            x2 = x1 + side, y2 = y1,
            x3 = x2 + half, y3 = y0,
            x4 = x2, y4 = y3 - height,
            x5 = x1, y5 = y4;

    Point
            p0 = new PointC(x0, y0),
            p1 = new PointC(x1, y1),
            p2 = new PointC(x2, y2),
            p3 = new PointC(x3, y3),
            p4 = new PointC(x4, y4),
            p5 = new PointC(x5, y5),
            q1 = new PointC(x1 + 0.25, y1 + 0.25),
            q2 = new PointC(x2 + 0.25, y2 + 0.25),
            q3 = new PointC(x4 + 0.25, y4 + 0.25),
            q4 = new PointC(x5 + 0.25, y5 + 0.25);

    Line[] hexLines = {
            new LineC(p0, p1),
            new LineC(p1, p2),
            new LineC(p2, p3),
            new LineC(p3, p4),
            new LineC(p4, p5),
            new LineC(p5, p0)
    };
    Line[] squareLines = {
            new LineC(q1, q2),
            new LineC(q2, q3),
            new LineC(q3, q4),
            new LineC(q4, q1)
    };

    MultiSegmentLine[] msls = {
            new MultiSegmentLineC(squareLines, Color.RED),
            new MultiSegmentLineC(hexLines, Color.BLUE)
    };

    for (MultiSegmentLine msl : msls)
      msl.render();

    StdIn.readChar();
    StdDraw.clear();

    Arrays.sort(msls);

    System.out.println("The segmented lines have been sorted ...");

    for (MultiSegmentLine msl : msls)
      msl.render();
  }
}
