import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class CreateATeam{
  static Scanner newInput() throws IOException {
    if (System.getProperty("JUDGE") != null) {
      return new Scanner(new File("team.in"));
    } else {
        return new Scanner(System.in);
    }
  }

  static PrintWriter newOutput() throws IOException {
    if (System.getProperty("JUDGE") != null) {
      return new PrintWriter("team.out");
    } else {
      return new PrintWriter(System.out);
    }
  }

  static long maximizeEfficiency(int[][] levels, int[] availableRoles, int row){
    if(row == 2){
      return levels[row][availableRoles[0]] * levels[row][availableRoles[0]];
    }
    long max = 0L;
    for(int i=0; i<availableRoles.length; i++){
      int[] nonTaken = new int[availableRoles.length-1];
      for(int j=0; j<i; j++){
        nonTaken[j] = availableRoles[j];
      }
      for(int j=i+1; j<availableRoles.length; j++){
        nonTaken[j-1] = availableRoles[j];
      }
      long currMaximitation = (levels[row][availableRoles[i]] * levels[row][availableRoles[i]]) + maximizeEfficiency(levels, nonTaken, row + 1);
      if (currMaximitation > max){
        max = currMaximitation;
      }
    }
    return max;
  }
  public static void main(String[] args) throws IOException{
    try (Scanner in = newInput(); PrintWriter out = newOutput()) {
      int[][] members = new int[3][3];
      for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
          members[i][j] = in.nextInt();
        }
      }
      NumberFormat f = new DecimalFormat("#0.0000000");
      out.println(f.format(Math.sqrt(maximizeEfficiency(members, new int[]{0,1,2}, 0))));
    }
  }
}