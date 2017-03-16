import java.io.*;

public class Poles {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int k = Integer.parseInt(data[1]);

        BestItem[][] best = new BestItem[n+1][k+1];
        long[] altitudes = new long[n+1];
        long[] weights = new long[n+1];

        for(int i=1; i<=n; i++){
            data = br.readLine().split(" ");
            altitudes[i] = Long.parseLong(data[0]);
            weights[i] = Long.parseLong(data[1]);
        }

        for(int i=1; i<=k; i++){
            for(int j=i; j<=n; j++){
                if(j==i){
                    best[j][i] = new BestItem(0, altitudes[j]);
                }
                else if(i==1){
                    long costAddition = weights[j] * (altitudes[j] - best[j-1][i].stackPos);
                    best[j][i] = new BestItem(costAddition + best[j-1][i].cost , best[j-1][i].stackPos);
                }else {
                    long costAddingToLastStack = weights[j] * (altitudes[j] - best[j-1][i].stackPos);
                    costAddingToLastStack += best[j-1][i].cost;
                    long costCreatingStackInplace = best[j-1][i-1].cost;
                    if(costAddingToLastStack <= costCreatingStackInplace){
                        best[j][i] = new BestItem(costAddingToLastStack , best[j-1][i].stackPos);
                    }else{
                        best[j][i] = new BestItem(costCreatingStackInplace , altitudes[j]);
                    }
                }
            }
        }

        System.out.println(best[n][k].cost);
    }
}

class BestItem {
    public long cost;
    public long stackPos;

    public BestItem(long c, long s){
        cost = c;
        stackPos = s;
    }
}