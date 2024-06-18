public class Maths_NumberOfRectanglesInACircle {
  int rectanglesInCircle(int r) {

    int rectangles = 0;

    // max len of diagonal of a rectangle that a circle of radius r can have 2 * r
    int diameter = 2 * r;
    int diameter_squared = diameter * diameter;

    for (int a = 1; a < diameter; a++) {
      for (int b = 1; b < diameter; b++) {

        int diagonal_squared = a * a + b * b;

        if (diagonal_squared <= (diameter_squared)) {
          rectangles++;
        }

      }
    }

    return rectangles;
  }
}
