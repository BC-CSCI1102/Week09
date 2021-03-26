// file: OrderedColorC.java
// author: Bob Muller
//

import edu.princeton.cs.algs4.StdDraw;

import java.awt.Color;

public class OrderedColorC implements OrderedColor {

  private Color color;

  public OrderedColorC(int red, int green, int blue) {
    this.color = new Color(red, green, blue);
  }

  @Override
  public String toString() {
    int red = this.getRed();
    int green = this.getGreen();
    int blue = this.getBlue();
    return String.format("0x%02x%02x%02x", red, green, blue);
  }

  @Override
  public boolean equals(Object other) {
    if (other == null || other.getClass() != this.getClass())
      return false;
    return this.compareTo((OrderedColor) other) == 0;
  }

  // Ordered by amount of red
  public int compareTo(OrderedColor other) {
    if (other == null)
      throw new RuntimeException("compareTo - you gave me null, wanted color");
    return Integer.compare(this.getRed(), other.getRed());
  }

  @Override
  public int hashCode() {
    return 5;
  }
  
  public void display(double x, double y) {
    StdDraw.setPenColor(this.color);
    StdDraw.filledRectangle(x, y, 0.25, 0.25);
  }

  public int getRGB() {
    return this.color.getRGB();
  }


  public int getRed() {
    return this.color.getRed();
  }

  public int getGreen() {
    return this.color.getGreen();
  }

  public int getBlue() {
    return this.color.getBlue();
  }

  public static void main(String[] args) {
    StdDraw.setCanvasSize(600, 600);

    OrderedColor oc1 = new OrderedColorC(0x64, 0x64, 0x64);
    OrderedColor oc2 = new OrderedColorC(0x80, 0x0, 0x0);
    System.out.format("oc1 = %s, oc2 = %s.%n", oc1.toString(), oc2.toString());
    if (oc1.compareTo(oc2) < 0) {
      oc1.display(0.25, 0.75);
      StdDraw.pause(1000);
      oc2.display(0.75, 0.25);
    }
    else {
      oc2.display(0.25, 0.75);
      StdDraw.pause(1000);
      oc1.display(0.75, 0.25);
    }
  }
}

/*
  @Override
  public String toString() {
    int red = this.color.getRed();
    int green = this.color.getGreen();
    int blue = this.color.getBlue();
    return String.format("0x%02x%02x%02x", red, green, blue);
  }

  @Override
  public boolean equals(Object other) {
    if (other == null || other.getClass() != this.getClass())
      return false;
    return this.compareTo((OrderedColor) other) == 0;
  }

  @Override
  public int hashCode() {
    return 12;
  }

  public void display(double x, double y) {
    StdDraw.setPenColor(this.color);
    StdDraw.filledRectangle(x, y, 0.25, 0.25);
  }

  public int getRGB() {
    return this.color.getRGB();
  }


  public int getRed() {
    return this.color.getRed();
  }

  public int getGreen() {
    return this.color.getGreen();
  }

  public int getBlue() {
    return this.color.getRed();
  }

  public int compareTo(OrderedColor other) {
    if (other == null)
      throw new RuntimeException("compareTo given null, wanted OrderedColor");
    return Integer.compare(this.color.getRGB(), other.getRGB());
  }

  public int compareTo(OrderedColor other) {
    if (other == null)
      throw new RuntimeException("null OrderedColor");
    int red = this.color.getRed(),
            green = this.color.getGreen(),
            blue = this.color.getBLue();
    if (red == green && green == blue) return 0;
    return Integer.compare(average(this.col))
  }

  public static void main(String[] args) {
    StdDraw.setCanvasSize(600, 600);

    OrderedColor oc1 = new OrderedColorC(0x64, 0x64, 0x64);
    OrderedColor oc2 = new OrderedColorC(0x80, 0x0, 0x0);
    System.out.format("oc1 = %s, oc2 = %s.%n", oc1.toString(), oc2.toString());
    if (oc1.compareTo(oc2) < 0) {
      oc1.display(0.25, 0.75);
      StdDraw.pause(1000);
      oc2.display(0.75, 0.25);
    }
    else {
      oc2.display(0.25, 0.75);
      StdDraw.pause(1000);
      oc1.display(0.75, 0.25);
    }
  }
}
*/
