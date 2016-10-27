import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class WriteACodeTemplate{
  static Scanner newInput() throws IOException {
    if (System.getProperty("JUDGE") != null) {
      return new Scanner(new File("template.in"));
    } else {
        return new Scanner(System.in);
    }
  }

  static PrintWriter newOutput() throws IOException {
    if (System.getProperty("JUDGE") != null) {
      return new PrintWriter("template.out");
    } else {
      return new PrintWriter(System.out);
    }
  }

  public static void main(String[] args) throws IOException{
    try (Scanner in = newInput(); PrintWriter out = newOutput()) {
      int w, h;
      w = in.nextInt();
      h = in.nextInt();

      //126 is the max ASCII id
      Point[] coord = new Point[127];

      for(int i=0; i<h; i++){
        String line = in.readLine();
        for(int j=0; j<line.length(); j++){
          coord[]
        }
      }
    }
  }
}

class Point{
  int x;
  int y;

  public Point(int x, int y){
    this.x = x;
    this.y = y;
  }
}