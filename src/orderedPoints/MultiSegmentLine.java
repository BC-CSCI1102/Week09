// file: MultiSegmentLine.java
// author: Bob Muller

public interface MultiSegmentLine extends Comparable<MultiSegmentLine> {

  public int segments();

  public Line segment(int i);

  public double length();

  public Point center();

  public void render();

  @Override
  public String toString();

  public int compareTo(MultiSegmentLine other);

  @Override
  public boolean equals(Object o);
}
