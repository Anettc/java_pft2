package ru.stqa.pft.sandbox;

/**
 * Created by Work on 27.10.2016.
 */
public class Rectangle {
  public double a;
     public double b;

           public Rectangle(double a, double b) {
            this.a = a;
           this.b = b;
       }

  public double area() {
           return this.a * this.b;
       }

}
