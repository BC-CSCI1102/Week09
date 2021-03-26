// file: Point.java
// author: Bob Muller
//
public interface OrderedColor {

  @Override
  public String toString();

  public void display(double x, double y);

  public int getRGB();

  public int getRed();

  public int getGreen();

  public int getBlue();

  public int compareTo(OrderedColor other);

  @Override
  public boolean equals(Object o);
}
