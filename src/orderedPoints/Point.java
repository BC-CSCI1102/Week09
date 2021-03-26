// file: Point.java
// author: Bob Muller
//
public interface Point extends Comparable<Point> {

  public double getX();

  public double getY();

  public double distance();

  @Override
  public String toString();

  public int compareTo(Point other);

  @Override
  public boolean equals(Object o);
}
