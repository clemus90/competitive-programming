import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;


public class GameOfTwoStacks{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st;

        long[] stackA = new long[1000000];
        long[] stackB = new long[1000000];


        int games = Integer.parseInt(br.readLine());

        for(int g=0; g<games; g++){
            st = new StringTokenizer(br.readLine());
            int sizeA, sizeB;
            long sum;
            sizeA = Integer.parseInt(st.nextToken());
            sizeB = Integer.parseInt(st.nextToken());
            sum = Long.parseLong(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=sizeA; i++){
                stackA[i] = Long.parseLong(st.nextToken()) + stackA[i-1]; 
            }
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=sizeB; i++){
                stackB[i] = Long.parseLong(st.nextToken()) + stackB[i-1]; 
            }

            int maxScore = sizeA + sizeB;
            boolean validScore = false;

            while(!validScore){
                for(int i=sizeA; i >= 0; i--){
                    if((maxScore - i) > sizeB || (maxScore - i) < 0)
                        continue;
                    if((stackA[i] + stackB[maxScore - i]) <= sum){
                        validScore = true;
                        break;
                    }
                }
                if(!validScore)
                    maxScore--;
            }

            out.println(maxScore);
        }
        out.close();
    }
}