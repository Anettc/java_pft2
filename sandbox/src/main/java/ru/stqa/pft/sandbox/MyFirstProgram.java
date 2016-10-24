package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Anna");
    double l = 5;
    System.out.println("Площадь квадрата со стороной " + l + " = " + area(l));

    double a = 4;
    double b = 6;
    System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " = " + area(a, b));

    Point p1 = new Point(0, 0);
    Point p2 = new Point(3, 4);
    System.out.println("Расстояние между двумя точками:" + "(" + p1.x + "," + p1.y + ")" + " и " + "(" + p2.x + "," + p2.y + ")" + " = " + distance(p1, p2));

    System.out.println("Расстояние между двумя точками:" + "(" + p1.x + "," + p1.y + ")" + " и " + "(" + p2.x + "," + p2.y + ")" + " = " + p2.distance(p1));

       }


  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");

  }

  public static double area(double len) {

    return len * len;
  }

  public static double area(double a, double b) {
    return a * b;
  }

  public static double distance(Point p1, Point p2) {
    double x = p1.x - p2.x;
    double y = p1.y - p2.y;
    return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
  }

  }


