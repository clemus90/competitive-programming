import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class PutTheChairsTheRightWay{
  static Scanner newInput() throws IOException {
    if (System.getProperty("JUDGE") != null) {
      return new Scanner(new File("chairs.in"));
    } else {
        return new Scanner(System.in);
    }
  }

  static PrintWriter newOutput() throws IOException {
    if (System.getProperty("JUDGE") != null) {
      return new PrintWriter("chairs.out");
    } else {
      return new PrintWriter(System.out);
    }
  }

  public static void main(String[] args) throws IOException{
    try (Scanner in = newInput(); PrintWriter out = newOutput()) {
      double[] sides = new double[3];
      //Theorem: The line segment connecting the midpoints of  two sides of a triangle is parallel to the third side and is congruent to one half of the third side.
      double avg = 0;
      for(int i=0; i<3; i++){
        sides[i] = (in.nextDouble())/2.0;
        avg += sides[i];
      }
      avg /= 3;
      NumberFormat f = new DecimalFormat("#0.0000000");
      out.println(f.format(avg));
    }
  }
}
