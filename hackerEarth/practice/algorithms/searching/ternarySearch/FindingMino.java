import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FindingMino {

    public static double f(double x){
        return 2 * x * x - 12 * x + 7;
    }

    public static double ts(double start, double end) {
        double l = start;
        double r = end;
        for(int i=0; i<100; i++){
            double l1 = l + (r-l)/3;
            double l2 = r - (r-l)/3;
            if(f(l1) <= f(l2)) r= l2; else l = l1;
        }
        if(f(l) <= f(r)) return f(l);
        else return f(r);
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int cases = Integer.parseInt(br.readLine());

        for(int i=0; i<cases; i++){
            double start, end;
            String[] ln = br.readLine().split(" ");
            start = Double.parseDouble(ln[0]);
            end = Double.parseDouble(ln[1]);

            out.println((int)ts(start, end));
        }

        out.close();
    }
}