// file: Line.java
// author: Bob Muller
//
public interface Line extends Comparable<Line> {

  public Point midpoint();

  public Point min();

  public Point max();

  public double length();

  public void render();

  @Override
  public String toString();

  public int compareTo(Line other);

  @Override
  public boolean equals(Object o);
}
