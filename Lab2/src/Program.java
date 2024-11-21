import java.util.Scanner;

public class Program {

  public static class Point {
    protected double x, y;

    public Point(double x, double y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "Точка (" + x + ", " + y + ")";
    }
  }

  public static class Circle extends Point {
    protected double radius;

    public Circle(double x, double y, double radius) {
      super(x, y);
      this.radius = radius;
    }

    @Override
    public String toString() {
      return super.toString() + ", Радиус: " + radius;
    }
  }

  public static class Bowl extends Circle {
    private double height;

    public Bowl(double x, double y, double radius, double height) {
      super(x, y, radius);
      this.height = height;
    }

    public double calculateSoupVolume() {
      return Math.PI * Math.pow(radius, 2) * height * 0.99; // 99% объема
    }

    @Override
    public String toString() {
      return super.toString() + ", Высота: " + height + ", Объем супа: " + calculateSoupVolume();
    }
  }
}
