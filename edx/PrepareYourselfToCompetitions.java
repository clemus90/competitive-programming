import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PrepareYourselfToCompetitions{
  static Scanner newInput() throws IOException {
    if (System.getProperty("JUDGE") != null) {
      return new Scanner(new File("prepare.in"));
    } else {
        return new Scanner(System.in);
    }
  }

  static PrintWriter newOutput() throws IOException {
    if (System.getProperty("JUDGE") != null) {
      return new PrintWriter("prepare.out");
    } else {
      return new PrintWriter(System.out);
    }
  }
  public static void main(String[] args) throws IOException{
    try (Scanner in = newInput(); PrintWriter out = newOutput()) {
      int n = in.nextInt();
      int[] practice = new int[n];
      int[] theory = new int[n];
      for(int i=0; i<n; i++){
        practice[i] = in.nextInt();
      }
      for(int i=0; i<n; i++){
        theory[i] = in.nextInt();
      }

      int countP, countT, minLoss;
      countP = countT = 0;
      minLoss = Integer.MAX_VALUE;
      int ability = 0;
      for(int i=0; i<n; i++){
        if(practice[i]>theory[i]){
          ability += practice[i];
          countP++;
          int tradeoff = practice[i] - theory[i];
          if(tradeoff < minLoss){
            minLoss = tradeoff;
          }
        }else{
          ability += theory[i];
          countT++;
          int tradeoff = theory[i] - practice[i];
          if(tradeoff < minLoss){
            minLoss = tradeoff;
          }
        }
      }

      if(countT == 0 || countP == 0){
        ability -= minLoss;
      }

      out.println(ability);
    }
  }
}