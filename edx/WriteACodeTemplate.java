import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Hashtable;
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

  static int calcDistance(Point a, Point b){
    int max = Integer.MIN_VALUE;
    int diff = Math.abs(a.x - b.x);
    if(diff > max){
      max = diff;
    }
    diff = Math.abs(a.y - b.y);
    if(diff > max){
      max = diff;
    }
    return max;

  }

  public static void main(String[] args) throws IOException{
    try (Scanner in = newInput(); PrintWriter out = newOutput()) {
      int w, h;
      w = in.nextInt();
      h = in.nextInt();
      //Discards new line character
      in.nextLine();

      //126 is the max ASCII id
      Point[] coord = new Point[127];

      for(int i=0; i<h; i++){
        String line = in.nextLine();
        for(int j=0; j<line.length(); j++){
          char c = line.charAt(j);
          coord[(int)c] = new Point(j,i);
        }
      }

      //Discards empty line
      in.nextLine();

      String fastestLang = null;
      int fastestDist = Integer.MAX_VALUE;

      while(in.hasNext()){
        String languageName = in.nextLine();
        int totalDistance = 0;
        String line;
        Point curr = null;
        while(in.hasNext() && (line = in.nextLine()) != null && line.trim().length() > 0){
          if(curr == null){
            curr = coord[(int)line.charAt(0)];
          }
          for(int i=0; i<line.length(); i++){
            Point newKey = coord[(int)line.charAt(i)];
            totalDistance += calcDistance(curr, newKey);
            curr = newKey;
          }
        }
        if(totalDistance < fastestDist){
          fastestLang = languageName;
          fastestDist = totalDistance;
        }
      }
      out.println(fastestLang);
      out.println(fastestDist);
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

  @Override
  public String toString(){
    return "(" + String.valueOf(this.x) + "," + String.valueOf(this.y) + ")";
  }
}