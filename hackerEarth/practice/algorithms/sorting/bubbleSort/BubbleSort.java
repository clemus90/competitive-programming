import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BubbleSort {

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int size = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int switchs = 0;
        for(int i=0; i<size - 1; i++){
            for(int j=0; j<size - 1 - i; j++){
                if(array[j] > array[j+1]){
                    switchs++;
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        out.println(switchs);
        out.close();
    }
}