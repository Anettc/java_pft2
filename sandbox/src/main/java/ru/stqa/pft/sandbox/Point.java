package ru.stqa.pft.sandbox;

/**
 * Created by Work on 24.10.2016.
 */
public class Point {
  public double x;
  public double y;

  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }
  public double distance(Point p2) {
    double x = this.x - p2.x;
    double y = this.y - p2.y;
    return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

  }


}
