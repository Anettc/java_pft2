package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Work on 31.10.2016.
 */
public class PointTest {
  @Test
  public void testpoint() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(3, 4);
    Assert.assertEquals(p1.distance(p2), 5.0);
  }

  public class PointTest2 {
    @Test
    public void testpoint() {
      Point p1 = new Point(0, 0);
      Point p2 = new Point(3, 4);
      Assert.assertEquals(p1.distance(p2), Math.sqrt(25.0));
    }
  }
}






