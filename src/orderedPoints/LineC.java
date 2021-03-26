// file: LineC.java
// author: Bob Muller


import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

public class LineC implements Line {

  private final boolean DEBUG = false;

  private Point p1;
  private Point p2;

  public LineC(Point p1, Point p2) {
    this.p1 = p1;
    this.p2 = p2;
  }

  public Point midpoint() {

    Point min = this.min();
    Point max = this.max();

    double x1 = min.getX(), y1 = min.getY();
    double x2 = max.getX(), y2 = max.getY();

    return new PointC(x1 + (x2 - x1) / 2.0, y1 + (y2 - y1) / 2.0);
  }

  public Point min() {
    return this.p1.compareTo(p2) <= 0 ? p1 : p2;
  }

  public Point max() {
    return this.p1.compareTo(p2) <= 0 ? p2 : p1;
  }

  public double length() {
    double
            x1 = this.min().getX(), y1 = this.min().getY(),
            x2 = this.max().getX(), y2 = this.max().getY(),
            dx = Math.abs(x2 - x1),
            dy = Math.abs(y2 - y1);
    return Math.sqrt(dx * dx + dy * dy);
  }

  public void render() {
    StdIn.readChar();
    System.out.format("rendering %s", this.toString());
    StdDraw.line(this.min().getX(), this.min().getY(),
                 this.max().getX(), this.max().getY());
  }

  public String toString() {
    return String.format("{p1 = %s, p2 = %s}", this.min(), this.max());
  }

  // A natural ordering comparing midpoints.
  //
  public int compareTo(Line other) {
    if (other == null)
      throw new RuntimeException("compareTo: you provided null, I needed a Line");
    return this.midpoint().compareTo(other.midpoint());
  }

  @Override
  public boolean equals(Object other) {
    if (other == null || other.getClass() != this.getClass())
      return false;
    return this.compareTo((Line) other) == 0;
  }

  public static void main(String[] args) {

    Point p = new PointC(0.0, 0.0);
    Point q = new PointC(1.0, 0.0);

    Line line = new LineC(p, q);

    line.render();

    System.out.println(line.toString());
    System.out.format("midpoint is %s.%n", line.midpoint().toString());
    System.out.format("distance is %.2f%n", line.midpoint().distance());
  }
}
