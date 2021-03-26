// file: PointC.java
// author: Bob Muller
// The revision improves compareTo and provides a few alternate
// versions that are presently commented-out.
//

public class PointC implements Point {

  private static boolean DEBUG = false;

  private double x;
  private double y;

  public PointC(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public String toString() {
    return String.format("(%.2f, %.2f)", this.getX(), this.getY());
  }

  private static final double EPSILON = 1.0 * Math.pow(10.0, -6.0);

  private boolean closeEnough(double a, double b) {
    return Math.abs(a - b) < EPSILON;
  }

  // Our natural ordering compares distance to the origin. This equates Points
  // in rings around the origin.
  //
  public int compareTo(Point other) {
    if (other == null)
      throw new RuntimeException("compareTo: you provided null, I needed a Point");
    if (closeEnough(this.distance(), other.distance()))
      return 0;
    else
      return Double.compare(this.distance(), other.distance());
  }

  // The most direct way to ensure that equals is consistent with compareTo.
  @Override
  public boolean equals(Object other) {
    if (other == null || (other.getClass() != this.getClass()))
      return false;
    return this.compareTo((Point) other) == 0;
  }

  /* OTHER compareTo's
   *
      // An alternative ordering: just compare the distance from the Y-axis.
      //
      public int compareTo(Point other) {
          return Double.compare(this.getX(), other.getX());
      }

      // A lexicographic ordering: first compare x's. If no difference compare y's.
      //
      public int compareTo(Point other) {
          int xResult = Double.compare(this.getX(), other.getX());
          if (xResult != 0) return xResult;
          return Double.compare(this.getY(), other.getY());
      }
  */

  @Override
  public int hashCode() {
    return 343;
  }

  public double distance() {
    double x = this.getX();
    double y = this.getY();
    return Math.sqrt(x * x + y * y);
  }

  public static void main(String[] args) {

    Point p = new PointC(.5, .5);
    Point q = new PointC(.5, 0.0);
    System.out.format("Point %s at dist = %f.%n", p.toString(), p.distance());
    System.out.format("Point %s at dist = %f.%n", q.toString(), q.distance());
  }
}
