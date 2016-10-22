import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AplusB2{
  static Scanner newInput() throws IOException {
    if (System.getProperty("JUDGE") != null) {
      return new Scanner(new File("aplusbb.in"));
    } else {
        return new Scanner(System.in);
    }
  }

  static PrintWriter newOutput() throws IOException {
    if (System.getProperty("JUDGE") != null) {
      return new PrintWriter("aplusbb.out");
    } else {
      return new PrintWriter(System.out);
    }
  }
  public static void main(String[] args) throws IOException{
    try (Scanner in = newInput(); PrintWriter out = newOutput()) {
      long a = in.nextLong();
      long b = in.nextLong();
      out.println(a + b*b);
    }
  }
}